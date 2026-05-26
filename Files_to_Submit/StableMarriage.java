import java.util.*;

public class StableMarriage {
    public static void main(String[] args) {
        // call run test method with file as arument
    }

    // run test method (imports the file as an argument)
    public static void runTest(String filename) {
        // read input file
        // creates persons from person class
        // creates an ArrayList for males
        // creates an ArrayList for females
        // calls stable pairings method
        // call print output method
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
