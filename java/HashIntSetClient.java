/*Zohaib Javed HW 09 Chapter 18 Advanced Data Structures - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/16/19*/

import java.util.*;

public class HashIntSetClient
{
   public static void main(String[] args) {
      System.out.println("************BEGIN TEST CLIENT FOR HASHINTSET EXERCISES 1-3 OF CHAPTER 18 HW09************\n\n");
   
   /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
   
      System.out.println("^^^^^^^^^^^^^^^^BEGIN PROVIDED CLIENT FROM CANVAS MODULES^^^^^^^^^^^^^^^^");
       
      HashIntSet set = new HashIntSet();
      set.add(7);
      set.add(5);
      set.add(1);
      set.add(9);
      
      // test addcleaing duplicates
      set.add(7);
      set.add(7);
      set.add(5);
      
      // test collisions and linked lists
      set.add(45);
      set.add(91);
      set.add(71);
      
      // test rehashing
      set.add(810);   // re-hash should occur here (8/10, load = 0.8)
      set.add(62);
      set.add(1238);
      set.add(-99);
      set.add(-30);
      set.add(42);
      set.add(49857);
      set.add(1520);  // re-hash should occur here (15/20, load = 0.75)
      set.add(2);
      set.add(31);
      set.add(11);
      set.add(21);
      
      // test removal
      set.remove(7);
      set.remove(9);
      set.remove(1);
      set.remove(1);
      set.remove(21);
      set.remove(71);
      
      for (int n : new int[] {1520, 99, 2, 55, 42, 11, 45, 0, 5, -10, 810}) {
         System.out.println("contains " + n + "? " + set.contains(n));
      }
      
      System.out.println(set + ", size " + set.size());
      
      System.out.println("^^^^^^^^^^^^^^^^END PROVIDED CLIENT FROM CANVAS MODULES^^^^^^^^^^^^^^^^\n\n");
      
      /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
      
      System.out.println("<<<<<<<<<<<<<<<<<BEGIN TESTING FOR HW09 CHAPTER 18 EXERCISE 01 addAll() FOR HASHINTSET>>>>>>>>>>>>>>>>>");
      
      //for example given from book [-5, 1, 2, 3] and the method is passed [2, 3, 6, 44, 79], your set would store [-5, 1, 2, 3, 6, 44, 79].
      set.clear();
      set.add(-5);
      set.add(1);
      set.add(2);
      set.add(3);
      
      HashIntSet set2 = new HashIntSet();
      set2.add(2);
      set2.add(3);
      set2.add(6);
      set2.add(44);
      set2.add(79);
      
      System.out.println("(From book)Test 1: set: " + set  + "\nset 2: " + set2);
      set.addAll(set2);
      System.out.println("(From book)Test 1: Calling set.addAll(set2) returns (should return [-5, 1, 2, 3, 6, 44, 79]): \n" + set + "\n");
      
      set.clear();
      set.add(1);
      set.add(2);
      set.add(3);
      
      set2.clear();
      set2.add(4);
      set2.add(5);
      set2.add(6);
      
      System.out.println("Test 2: set: " + set  + "\nset 2: " + set2);
      set.addAll(set2);
      System.out.println("Test 2: Calling set.addAll(set2) returns (should return [1, 2, 3, 4, 5, 6]): \n" + set + "\n");
      
      set.clear();
      set.add(-5);
      set.add(4);
      set.add(29);
      
      set2.clear();
      set2.add(87);
      set2.add(0);
      set2.add(3);
      
      System.out.println("Test 3: set: " + set  + "\nset 2: " + set2);
      set.addAll(set2);
      System.out.println("Test 3: Calling set.addAll(set2) returns (should return [0, 3, 4, -5, 87, 29]): \n" + set + "\n");
      
      set.clear();
      
      set2.clear();
      set2.add(2);
      set2.add(3);
      set2.add(6);
      
      System.out.println("Test 4: set: " + set  + "\nset 2: " + set2);
      set.addAll(set2);
      System.out.println("Test 4: Calling set.addAll(set2) returns (should return [2, 3, 6]): \n" + set);
      
      System.out.println("<<<<<<<<<<<<<<<<<END TESTING FOR HW09 CHAPTER 18 EXERCISE 01 addAll() FOR HASHINTSET>>>>>>>>>>>>>>>>>\n\n");
      
      /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
      
      System.out.println("##################BEGIN TESTING FOR HW09 CHAPTER 18 EXERCISE 02 containsAll() FOR HASHINTSET##################");
      
       //[-2, 3, 5, 6, 8] and the method is passed [3, 6, 8], your method would return true. If the method were 
      //passed [3, 6, 7, 8], your method would return false because your set does not contain the value 7.
      set.clear();
      set.add(-2);
      set.add(3);
      set.add(5);
      set.add(6);
      set.add(8);
      
      set2.clear();
      set2.add(3);
      set2.add(8);
      set2.add(6);
      
      HashIntSet set3 = new HashIntSet();
      set3.add(3);
      set3.add(8);
      set3.add(6);
      set3.add(7);
      
      System.out.println("(From book)Test 1: \nset: " + set  + "\nset 2: " + set2 + "\nset 3: " + set3);
      System.out.println("(From book)Test 1: Calling set.containsAll(set2) returns (should return true): \n" + set.containsAll(set2) + "\nAnd calling set.containsAll(set3) (should return false): \n" + set.containsAll(set3) + "\n");
      
      set.clear();
      set.add(4);
      set.add(8);
      set.add(-3);
      set.add(17);
      set.add(29);
      
      set2.clear();
      set2.add(-3);
      set2.add(8);
      set2.add(29);
      
      set3.clear();
      set3.add(-3);
      set3.add(3);
      set3.add(30);
      
      System.out.println("Test 2: \nset: " + set  + "\nset 2: " + set2 + "\nset 3: " + set3);
      System.out.println("Test 2: Calling set.containsAll(set2) returns (should return true): \n" + set.containsAll(set2) + "\nAnd calling set.containsAll(set3) (should return false): \n" + set.containsAll(set3) + "\n");
      
      
      
      set.clear();
      
      
      set2.clear();
      set2.add(1);
      
      set3.clear();
   
      
      System.out.println("Test 3: \nset: " + set  + "\nset 2: " + set2 + "\nset 3: " + set3);
      System.out.println("Test 3: Calling set.containsAll(set2) returns (should return false): \n" + set.containsAll(set2) + "\nAnd calling set3.containsAll(set) (should return true): \n" + set3.containsAll(set) + "\n");
      
      System.out.println("Test 4: \nset: " + set  + "\nset 2: " + set2 + "\nset 3: " + set3);
      System.out.println("Test 4: Calling set3.containsAll(set) returns (should return true): \n" + set3.containsAll(set));
   
      System.out.println("##################END TESTING FOR HW09 CHAPTER 18 EXERCISE 02 containsAll() FOR HASHINTSET##################\n\n");
      
      /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
   
      System.out.println("[[[[[[[[[[[[[[BEGIN TESTING FOR HW09 CHAPTER 18 EXERCISE 03 equals() FOR HASHINTSET]]]]]]]]]]]]]]");
      
      set.clear();
      set.add(1);
      set.add(2);
      set.add(3);
        
      set2.clear();
      set2.add(1);
      set2.add(2);
      set2.add(3);
        
      System.out.println("Test 1: \nset: " + set  + "\nset 2: " + set2 + "\nset 3: " + set3);
      System.out.println("Test 1: Calling set.equals(set2) returns (should return true): \n" + set.equals(set2) + "\nAnd calling set.equals(set3) (should return false): \n" + set.equals(set3) + "\n");
        
      set.clear();
        
      set2.clear();
        
      System.out.println("Test 2: \nset: " + set  + "\nset 2: " + set2);
      System.out.println("Test 2: Calling set.equals(set2) returns (should return true): \n" + set.equals(set2) + "\n");
        
      set.clear();
        
      set2.clear();
      set2.add(90);
        
      System.out.println("Test 3: \nset: " + set  + "\nset 2: " + set2);
      System.out.println("Test 3: Calling set.equals(set2) returns (should return false): \n" + set.equals(set2) + "\n");
        
      set.clear();
      set.add(0);
      set.add(1);
      set.add(-3);
        
        
      set2.clear();
      set2.add(90);
        
      System.out.println("Test 4: \nset: " + set  + "\nset 2: " + set2);
      System.out.println("Test 4: Calling set.equals(set2) returns (should return false): \n" + set.equals(set2));
   
      System.out.println("[[[[[[[[[[[[[[END TESTING FOR HW09 CHAPTER 18 EXERCISE 03 equals() FOR HASHINTSET]]]]]]]]]]]]]]\n\n");
   
   /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
   
      System.out.println("************END TEST CLIENT FOR HASHINTSET EXERCISES 1-3 OF CHAPTER 18 HW09************");
   }

}