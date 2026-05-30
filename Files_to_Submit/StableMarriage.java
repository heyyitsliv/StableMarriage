import java.io.*;
import java.util.*;

public class StableMarriage {
    public static void main(String[] args) {
        runTest("matchmaking.txt");
    }

    public static void runTest(String filename) {
        ArrayList<Person> males = new ArrayList<>();
        ArrayList<Person> females = new ArrayList<>();

        // new scanner that separates the male/female when hitting end
        boolean isParsingMen = true;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // if line is END, finish current section
                if (line.equalsIgnoreCase("END")) {
                    isParsingMen = false;   // switch to woman parsing
                    continue;
                }

                // split line by : or whitespace
                String[] parts = line.split("[:\\s]+");
                String name = parts[0];

                // all other elements in line are preferences
                ArrayList<Integer> preferences = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    preferences.add(Integer.parseInt(parts[i]));
                }

                // assign gender based on bool (before/after END)
                if (isParsingMen) {
                    males.add(new Person(name, preferences, 'M'));
                } else {
                    females.add(new Person(name, preferences, 'W'));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: file " + filename + " not found");
            return;
        }
        
        // run 1: men favored
        System.out.println("Men favored run\n");
        stablePairings(males, females);
        printOutput(males, females); 

        // reset data for run 2
        males.clear();
        females.clear();
        // repopulate after clearing
        isParsingMen = true;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // if line is END, finish current section
                if (line.equalsIgnoreCase("END")) {
                    isParsingMen = false;   // switch to woman parsing
                    continue;
                }

                // split line by : or whitespace
                String[] parts = line.split("[:\\s]+");
                String name = parts[0];

                // all other elements in line are preferences
                ArrayList<Integer> preferences = new ArrayList<>();
                for (int i = 1; i < parts.length; i++) {
                    preferences.add(Integer.parseInt(parts[i]));
                }

                // assign gender based on bool (before/after END)
                if (isParsingMen) {
                    males.add(new Person(name, preferences, 'M'));
                } else {
                    females.add(new Person(name, preferences, 'W'));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("error: file " + filename + " not found");
            return;
        }

        // run 2: woman favored
        System.out.println("Woman favored run\n");
        stablePairings(females, males);
        printOutput(males, females);  
    }

    public static void stablePairings(ArrayList<Person> proposers, ArrayList<Person> receivers) {
        // set each person to be free;
        for (Person p : proposers) {
            p.makeFree();
        }
        for (Person r : receivers) {
            r.makeFree();
        }

        boolean freeProposerExists = true;

        // while (some proposer p with a nonempty preference list is free) {
        while (freeProposerExists) {
            freeProposerExists = false;

            // go through all proposers for free one w/ options left
            for (int pId = 0; pId < proposers.size(); pId++) {
                Person p = proposers.get(pId);

                if (!p.isEngaged() && p.getTopPreference() != null) {
                    freeProposerExists = true;

                    // r = first reviewer on proposers list
                    int rId = p.getTopPreference();
                    Person r = receivers.get(rId);

                    // if (some proposer t is engaged to r) {set t to be free}
                    if (r.isEngaged()) {
                        int tId = r.getEngagedTo();
                        proposers.get(tId).makeFree();
                    }

                    // set p & r to be engaged to each other
                    p.setEngagedTo(rId);
                    r.setEngagedTo(pId);

                    ArrayList<Integer> removedSuccessorIds = r.removeAllProceedingValuesFromPreferenceList(pId);

                    // for (each successor q of p on r's list) {delete r from q's preference list; delete q from r's preference list}
                    for (Integer qId : removedSuccessorIds) {
                        Person q = proposers.get(qId);
                        q.removeValueFromPreferenceList(rId);
                    }

                    break;
                }
            }               
        }
    }

    public static void printOutput(ArrayList<Person> males, ArrayList<Person> females) {
        System.out.printf("%-12s%6s    %s%n", "Name", "Choice", "Partner");
        System.out.println("--------------------------------------");
        for (Person male: males) {
            if (male.getEngagedTo() != null) {
                System.out.printf("%-12s%6d    %s%n", male.getName(), male.getFinalChoiceIndex(), females.get(male.getEngagedTo()).getName());
            } 
        }
        System.out.println();   
    }
}
