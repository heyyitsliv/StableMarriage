# StableMarriage
cs22 group project

Nikki's thoughts 
- What should the person’s classes look like?
- What should the input data structures be stored in?
Created inital test input file "matchmaking.txt" of 40 men and 35 women with unacceptable matchings purged.
Created a first pass of the Person class with using the data structure of an ArrayList for the preferences for easy lookup and removal, while also doubly storing the list so that the copy can be manipulated within the algorithum to better help with the stable matches but also allow for us to retain the information of what number choice each person is.  In the constructor, initially storing all persons to have a null state of who they are engaged to so they are initially all set to free.  Wrote pseudocode for the methods needed in the persons class.