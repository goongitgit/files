/* Zohaib Javed - HW03Ex05
CS211 - Fall 2019
Prof: James Livingston 
10/5/19*/

import java.util.*;

public class HW03Ex11
{
   public static void main(String[] args) {
   System.out.println("\n----------------Testing for Exercise 11 (symmetricSetDifference) BEGIN----------------\n");

      Set<Integer> numbersA = new HashSet<Integer>();
      Set<Integer> numbersB = new HashSet<Integer>();
      
      //Adds values 1-10 to numbersA and values 6-15 to numbersB
      for(int i = 1; i < 11; i++){
         numbersA.add(i);
         numbersB.add(i+5);
      }
      //Prints sets
      System.out.println("Set A is: " + numbersA);
      System.out.println("Set B is: " + numbersB);
      System.out.println();
   
       //Initializes symmetric difference of set a and set b to the method 
      //symmetricSetDifference with parameters(numbersA, numbers B)
      Set<Integer> symmetricDifference = symmetricSetDifference(numbersA, numbersB);
      
      //Output of SymmetricDifference
      System.out.println("Symmetric Difference of Set A and B is: " + symmetricDifference);
      System.out.println("\n----------------Testing for Exercise 11 (symmetricSetDifference) END----------------\n");
   
   }

   public static Set<Integer> symmetricSetDifference(Set<Integer> setA, Set<Integer> setB){
   
      Set<Integer> copyOfA = new HashSet<Integer>();
      copyOfA.addAll(setA);
   
      Set<Integer> symmetricDifference = new HashSet<Integer>();
   
      copyOfA.removeAll(setB);
      symmetricDifference.addAll(copyOfA);
   
      setB.removeAll(setA);
      symmetricDifference.addAll(setB);
   
      return symmetricDifference;
   
   }

}
