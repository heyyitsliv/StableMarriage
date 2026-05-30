import java.util.*;

public class Person {
    // instant variables: data fields
    private String name;
    private ArrayList<Integer> originalPreferences; // allows for the lookup in the end of choice # 
    private ArrayList<Integer> preferences; // ArrayList allows for easy lookup and removal
    private Integer engagedTo; // allows for lookup of partner or null for "free" state
    private char gender;

    // constructor
    public Person(String name, ArrayList<Integer> preferences, char gender) {
        this.name = name;
        this.originalPreferences = preferences;
        this.preferences = new ArrayList<Integer>(preferences);
        this.engagedTo = null;  // allows for everyone to start out as "free"
        this.gender = gender;
    }

    // getTopPreference 
    public Integer getTopPreference() {
        if (preferences.isEmpty()){ //checks list is empty
            return null;
        }
        return preferences.get(0);
    }
    
    // make person free
    public void makeFree() {
        this.engagedTo = null; //clears the partner variable
    }

    // set engaged to
    public void setEngagedTo(Integer partnerId) {
        this.engagedTo = partnerId; //saves partner id
    }
    
    // remove value from preference list
    public void removeValueFromPreferenceList(Integer value) {
        this.preferences.remove(value); //removes speitc id from list
    } 
    // remove all proceeding values from preference list
    public ArrayList<Integer> removeAllProceedingValuesFromPreferenceList(Integer partnerId) { 
        ArrayList<Integer> removedSuccessors = new ArrayList<>(); // makes list to hold removed ppl
        int index = preferences.indexOf(partnerId); // finds where partner is in list
        if (index != -1) { // checks if parrtner is found
            while (preferences.size() > index + 1) { // loops through all remaning ppl after partner
                removedSuccessors.add(preferences.remove(index + 1)); // removes the worse choice
            }
        }
        return removedSuccessors;
    }
    // getname
    public String getName() { // return the name
        return name;
    }

    // isEngaged
    public boolean isEngaged() {
        return this.engagedTo != null; //should retunr true if have a partner
    }
    // getEngagedTo
    public Integer getEngagedTo(){
        return engagedTo; // returnd partner id
    }
    // getFinalChoiceIndex
    public int getFinalChoiceIndex(){
        if (engagedTo == null) { // checks if ended up alone
            return -1; // should return -2 for single ppl
        }
        return originalPreferences.indexOf(engagedTo) + 1; // find og index and +1
    }
}
