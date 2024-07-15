/* Zohaib Javed - HW03Ex05
CS211 - Fall 2019
Prof: James Livingston 
10/5/19*/

import java.util.*;

public class HW03Ex05
{
   public static void main(String[] args) {
      System.out.println("\n----------------Testing for Exercise 05 (sortAndRemoveDuplicates) BEGIN----------------\n");
      List<Integer> testList = new ArrayList<Integer>();
      //Creates an ordered list with duplicates
      int i;
      for(i = -5; i < 6; i++){
         if(i % 2 == 0){
            testList.add(i);
         }
         testList.add(i);
      }
      //Shuffles list that contains duplicates into random order (just searched up how to shuffle a list, I think its also in the book).
      Collections.shuffle(testList);
      System.out.println("List before removing duplicates and sorting: " + testList + "\n");
      //Prints the list after sorting and removing duplicates
      System.out.println("List after removing duplicates and sorting: " + sortAndRemoveDuplicates(testList));
      System.out.println("\n----------------Testing for Exercise 05 (sortAndRemoveDuplicates) END----------------\n");   
   }

   public static List<Integer> sortAndRemoveDuplicates(List<Integer> setA){
      Set<Integer> removedDups = new HashSet<Integer>(setA);
      List<Integer> sortedAndRemoved = new ArrayList<Integer>(removedDups);
      Collections.sort(sortedAndRemoved);
   
      return sortedAndRemoved;
   }
}