/* Zohaib Javed - HW03Ex05
CS211 - Fall 2019
Prof: James Livingston 
10/5/19*/

import java.util.*;

public class HW03Ex13{

   public static void main(String[] args){
   
      System.out.println("\n----------------Testing for Exercise 13 (isUnique) BEGIN----------------\n");
   
      //Creates a map that is unique. Passing this through the isUnique method should return true.
      Map<String, String> testMapUnique = new HashMap<String, String>();
      testMapUnique.put("Marty", "Stepp");
      testMapUnique.put("Stuart", "Reges");
      testMapUnique.put("Jessica", "Miller");
      testMapUnique.put("Amanda", "Camp");
      testMapUnique.put("Hal", "Perkins");
      
      System.out.println("The following is a unique map (testMapUnique): \n" + testMapUnique);
      System.out.println("After passing the unique test map through the isUnique method (should return true): \n\n" + isUnique(testMapUnique));
      System.out.println();
      
      Map<String, String> testMapNotUnique = new HashMap<String, String>();
      testMapNotUnique.put("Marty", "Stepp");
      testMapNotUnique.put("Stuart", "Reges");
      testMapNotUnique.put("Jessica", "Miller");
      testMapNotUnique.put("Amanda", "Reges");
      testMapNotUnique.put("Hal", "Miller");
   
      System.out.println("The following is NOT a unique map (testMaNotUnique): \n" + testMapNotUnique);
      System.out.println("After passing the unique test map through the isUnique method (should return false): \n\n" + isUnique(testMapNotUnique));
      
      System.out.println("\n----------------Testing for Exercise 13 (isUnique) END----------------\n");
   
   
      
   
   }
   
   public static boolean isUnique(Map<String, String> inputMap){
      //boolean to be returned
      boolean isUnique = true;
      
      //Creates a new comparison map to see how many times a value appears in the inputMap
      Map<String, Integer> comparisonMap = new HashMap<String, Integer>();
   
        //Assigns values of input map to comparison map as keys.
       //the values for those keys is the amount of times the value in
      //inputMap appears.
      for(String name : inputMap.keySet()){
         String value = inputMap.get(name);
         if (comparisonMap.containsKey(value)) {  
            int count = comparisonMap.get(value);
            comparisonMap.put(value, count + 1);
         } else { 
            comparisonMap.put(value, 1);
         }
      }
      
            //Checks in comparison map if a value is more than 2. If it is, this means that the
           //key whose value is more than 2 (referring to comparison Map) is a VALUE (in "input map")
          //that appears more than once, and since you cannot have duplicate keys in a map,
         //it means that two (or more) keys map to the same value. If it finds the count to be more than
        //1, it will set isUnique to false and break out of the loop. Else it sets isUnique to true (meaning
       //the input map is unique) and breaks.
   
      for(String name : comparisonMap.keySet()){
         int count = comparisonMap.get(name);
         if(count > 1){
            isUnique = false;
            break;
         }else{
            isUnique = true;
            break;
         }
      }
      return isUnique;
   }  

}