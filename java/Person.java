import java.io.*;
import java.util.*;
public class Person {
   //fields to store family information
   private String name;
   private String mother;
   private String father;
   //ArrayList of children to hold multiple children
   private ArrayList<String> children = new ArrayList<String>();
   public Person (String namein) {
      name = namein;
   }
   //Getter methods to output field information
   public String getName (){
      return name;
   }
   public String getMother (){
      return mother;
   }
   public String getFather (){
      return father;
   }
   public String getChildren (){
        //Checks if there are children, if true, 
       //returns string of ArrayList fo children, and
      //null if false
      if (children.size() > 0) {
         String out = "";
         for (int i = 0; i < children.size(); i++) {
            out += children.get(i);
            out += ", ";
         }
         return out;
      } else {
         return null;
      }
   }
   //Mutator mehods to edit family fields
   public void setMother (String motherin){
      mother = motherin;
   }
   public void setFather (String fatherin){
      father = fatherin;
   }
   public void addChild (String childin){
      children.add(childin);
   }
}
