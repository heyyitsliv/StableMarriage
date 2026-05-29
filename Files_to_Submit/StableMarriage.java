import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StableMarriage {
    public static void main(String[] args) {
        // call run test method with file as arument
        runTest("matchmaking.txt");
    }

    // run test method (imports the file as an argument)
    public static void runTest(String filename) {
        // read input file
        // ArrayList<String[]> fileLines = new ArrayList<>();
        // try {
        //     File file = new File(filename);
        //     Scanner scanner = new Scanner(file);
        //     while (scanner.hasNextLine()) {
        //         String line = scanner.nextLine();
        //         if (!line.isEmpty() && !line.equalsIgnoreCase("END")){  // skip empty lines and "END" lines
        //             fileLines.add(line.split("[:\\s]+"));
        //         }
        //     }
        //     scanner.close();
        // } catch (FileNotFoundException e) {
        //     System.out.println("Error: File " + filename + " not found.");
        //         return;
        // }
                        
        // creates persons from person class
        // ArrayList<Person> allPerson = new ArrayList<>();
        // for (String[] parts : fileLines) {
        //     String name = parts[0];
        //     char gender = parts[1].toUpperCase().charAt(0);
        //     ArrayList<Integer> preferences = new ArrayList<>();
        //     for (int i = 2; i < parts.length; i++) {
        //         preferences.add(Integer.parseInt(parts[i]));
        //     }
        //     //added: constructs and save new ppl
        //     allPerson.add(new Person(name, preferences, gender));
        // }

        // creates an ArrayList for males
        ArrayList<Person> males = new ArrayList<>();
        
        // creates an ArrayList for females
        ArrayList<Person> females = new ArrayList<>();
        
        //added: distribute ppl into separate lists
        // for (int i = 0; i < allPerson.size(); i++) {
        //     char gender = fileLines.get(i)[1].toUpperCase().charAt(0);
        //     if (gender == 'M') {
        //         males.add(allPerson.get(i));
        //     } else if (gender == 'F') {
        //         females.add(allPerson.get(i));
        //     }
        // }

        // new scanner that separates the male/female when hitting end
        boolean isParsingMen = true;
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();

                // if line is END, finish current section
                if (line.equalsIgnoreCase("END")) {
                    isParsingMen = false;   // switch to woam parsing
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
        
        // distribute peple into separate lists
        // for (String[] parts : fileLines) {
        //     String name = parts[0].replace(":", "");    // also removes the :
        //     char gender = parts[1].toUpperCase().charAt(0);
        //     ArrayList<Integer> preferences = new ArrayList<>();
        //     for (int i = 2; i < parts.length; i++) {
        //         preferences.add(Integer.parseInt(parts[i]));
        //     }

        //     Person newPerson = new Person(name, preferences, gender);
        //     if (gender == 'M') {
        //         males.add(newPerson);
        //     } else if (gender == 'F') {
        //         females.add(newPerson);
        //     }
        // }
        
            }
        }
        
        
        
    }

    // generate stable pairings method (pass in two ArrayLists of men and women)
    public static void stablePairings(ArrayList<Person> proposers, ArrayList<Person> recievcers) {
        // set each person to be free;
        for (Person p : proposers) {
            p.makeFree();
        }
        for (Person r : recievcers) {
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
                    Person r = recievcers.get(rId);

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
                        q.removValueFromPreferenceList(rId);
                    }

                    break;
                }
            }               
        }
    }

    // print output method [prints the final successful pairings with male's choice # of female]
    public static void printOutput(ArrayList<Person> males) {
        // Output headers
        // iterate through male Arraylist and call isEngage function to evalute who to print
        // call finalChoiceIndex to get original choice number
        // call getEngageTo to grab female name
    }
}
