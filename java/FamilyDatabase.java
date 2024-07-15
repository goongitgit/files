import java.io.*;
import java.util.*;
public class FamilyDatabase {
   public static void main(String[] args) throws FileNotFoundException{
      //Creates an input Scanner to read tudor.dat file
      Scanner input = new Scanner(new File("tudor.dat"));
        /* Sets the ArrayList of Person objects equal to the method convertFileToArrayList which 
       takes the input scanner as a parameter and returns an ArrayList of Person objects with 
      the father, mother, and child relationships already initialized. */
      ArrayList<Person> names = convertFileToArrayList(input);
      input.close();
      //Used for debugging
      String s = "144";
       /*the following while loop embodies the user interaction and processes 
      user input for searchable names while the user has not entered "quit"
      New Scanner to read user input */
      Scanner in = new Scanner(System.in);
      while (!(s.equalsIgnoreCase("quit"))) {
         System.out.println();
         //Asks user to enter input (a name to search)
         System.out.println("Which name would you like to search? (Or enter \"quit\" to exit the program) ");
         s = in.nextLine();
            /* After user input is captured in a string, the method processInput, which examines 
           the input to know what to output back is called. processInput takes the parameters of the 
          userSearch(String s), and the ArrayList of Persons so that if a valid name is entered, the 
         family information is able to be obtained. */
         processInput(s, names);
      }
      in.close();
   }
   //The below static method takes in the user input and proccesses it
   public static void processInput (String s, ArrayList<Person> names) {
      //Checks if user has not entered quit
      if (!(s.equalsIgnoreCase("quit"))) {
         boolean found = false;
          //For loop that goes through Person array, and checks if a name in it is equal to the user input.
         //If a match is found, creates output
         for (Person chosenPerson : names) {
            if (chosenPerson.getName().equalsIgnoreCase(s.toLowerCase())) {
               //Name of person outputted
               System.out.println("Name: " + chosenPerson.getName());

               //Following are if/elses that check whether or not mother, father, or children fields are null.
              //If they are not null, fields are outputted, if they are null, a "No information" message is outputted
              if (chosenPerson.getMother() != null) {
                 System.out.println("Mother: " + chosenPerson.getMother());
               } else {
                 System.out.println("No information on mother");
               }
               if (chosenPerson.getFather() != null) {
                System.out.println("Father: " + chosenPerson.getFather());
               } else {
                  System.out.println("No information on father");
               }
               if (chosenPerson.getChildren() != null) {
               System.out.println("Children: " + chosenPerson.getChildren());  
               } else {
                  System.out.println("No children");
               }
               found = true;
               break; 
            }
         }
         // If the name entered by user was not a valid name
         if (!found){
            System.out.println("That person could not be found. Try again or enter a different name");
         } 
      //Else for if the user typed "quit" to exit the program           
      } else {
         System.out.println("Goodbye");
      }
   }
    //Following static method that was called at beginning of test client initializes 
   //person objects and their fields. Returns an ArrayList<Person>.   
   public static ArrayList<Person> convertFileToArrayList(Scanner inputFile){
      //Array to be returned
      ArrayList<Person> namesList = new ArrayList<Person>();
      //String that acts as a placeholder for each line in file.
      String name = inputFile.nextLine();
       //While loop that goes through first list of searchable names, 
      //creates a Person object with the name, and adds that Person object to the Array
      while(inputFile.hasNextLine() && !(name.equals("END"))) {
         namesList.add(new Person(name));
         name = inputFile.nextLine();
      }
      if(inputFile.hasNextLine()){
         name = inputFile.nextLine();
      }
      //This while loop initializes family relationships while the next line does not equal END
      while(inputFile.hasNextLine() && !(name.equals("END"))) {
         //Process second list in groups of 3
            //Mother and father initialized to next 2 lines after name of person
            String mother = inputFile.nextLine();
            String father = inputFile.nextLine();
             //For loop that goes through the Person array, and compares the
            //Person's name in each index of the array to the relationship of the mother and father
            for (Person i : namesList) {
               //If the Person's name is equal to the first line, the mother and father fields are initalized
               if (i.getName().equals(name)) {
                  i.setMother(mother);
                  i.setFather(father);
               }
               //If the Person's name is equal to the mother or father, then the child (1st line) is intialized for that Person
               if (i.getName().equals(mother) || i.getName().equals(father)) {
                  i.addChild(name);
               }
         }
         name = inputFile.nextLine();
      }
      //Returns Array of Persons and initialized respective fields of each Person
      return namesList;
   }
}
