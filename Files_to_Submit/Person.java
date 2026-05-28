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
        if (preference.isEmpty()){ //checks list is empty
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
    //added to check if person has a partner alr
    public boolean isEngaged() {
    return this.engagedTo != null; //should retunr true if have a partner
}
    // remove value from preference list
    public void removValueFromPreferenceList(Integer value) {
        this.preferences.remove(value); //removes speitc id from list
    } 
    // remove all proceeding values from preference list

    // getname

    // isEngaged

    // getEngagedTo

    // getFinalChoiceIndex

}
