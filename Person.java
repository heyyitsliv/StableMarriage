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

    // make person free

    // set engaged to

    // remove value from preference list

    // remove all proceeding values from preference list

    // getname

    // isEngaged

    // getEngagedTo

}
