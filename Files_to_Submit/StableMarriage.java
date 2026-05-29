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
        ArrayList<String[]> fileLines = new ArrayList<>();
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()){
                    fileLines.add(line.split("\\s+"));
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: File " + filename + " not found.");
                return;
        }
                        
        // creates persons from person class
        ArrayList<Person> allPerson = new ArrayList<>();
        for (String[] parts : fileLines) {
            String name = parts[0];
            char gender = parts[1].toUpperCase().charAt(0);
            ArrayList<Integer> preferences = new ArrayList<>();
            for (int i = 2; i < parts.length; i++) {
                preferences.add(Integer.parseInt(parts[i]));
            }
            //added: constructs and save new ppl
            allPerson.add(new Person(name, preferences, gender));
        }
 // creates an ArrayList for males
        ArrayList<Person> males = new ArrayList<>();
        
        // creates an ArrayList for females
        ArrayList<Person> females = new  ArrayList<>();
        
            //added: distribute ppl into separate lists
            for (int i = 0; i < allPerson.size(); i++) {
            char gender = fileLines.get(i)[1].toUpperCase().charAt(0);
            if (gender == 'M') {
                males.add(allPerson.get(i));
            } else if (gender == 'F') {
                females.add(allPerson.get(i));
            }
        }
        
        
        
    }

    // generate stable pairings method (pass in two ArrayLists of men and women)
    public static void stablePairings(ArrayList<Person> males, ArrayList<Person> females) {
        // set each person to be free;
        // while (some man m with a nonempty preference list is free) {
        //      w = first woman on m's list;
        //      if (some man p is engaged to w) {
        //          set p to be free
        //      }
        //      set m and w to be engaged to each other
        //      for (each successor q of m on w's list) {
        //          delete w from q's preference list
        //          delete q from w's preference list
        //      }
        // }
    }

    // print output method [prints the final successful pairings with male's choice # of female]
    public static void printOutput(ArrayList<Person> males) {
        // Output headers
        // iterate through male Arraylist and call isEngage function to evalute who to print
        // call finalChoiceIndex to get original choice number
        // call getEngageTo to grab female name
    }
}
