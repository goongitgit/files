/*Zohaib Javed HW 05 Chapter 15 - TEST CLIENT
James Livingston - CS 211 - Fall 2019
10/15/19*/

import java.util.*;

public class TestClient{
   
   public static void main(String[] args){
   
      System.out.println("---------Testing for HW05EX01 lastIndexOf BEGIN---------");
      ArrayIntList testArray1Ex01 = new ArrayIntList();
      testArray1Ex01.add(0); //i=0
      testArray1Ex01.add(20); //i=1
      //size is 2
      
      ArrayIntList testArray2Ex01 = new ArrayIntList();
      //size 0
   
      ArrayIntList testArray3Ex01 = new ArrayIntList();
      testArray3Ex01.add(1); //i=0
      testArray3Ex01.add(18); //i=1
      testArray3Ex01.add(2); //i=2
      testArray3Ex01.add(7); //i=3
      testArray3Ex01.add(18); //i=4
      testArray3Ex01.add(39); //i=5
      testArray3Ex01.add(40); //i=6
      //size is 7
      
      System.out.println("Test 1 for lastIndexOfMethod using testArray1Ex01 (should return 21 b/c value 1 is not found in array):\ntestArray1Ex01: " + testArray1Ex01 + "\nResult of testArray1Ex01.lastIndexOf(1): " + testArray1Ex01.lastIndexOf(1)+ "\n");
      System.out.println("Test 2 for lastIndexOfMethod using testArray2Ex01 (should return 21 b/c array is empty)\ntestArray2Ex01: " + testArray2Ex01 + "\nResult of testArray2Ex01lastIndexOf(12): " + testArray2Ex01.lastIndexOf(12) + "\n");
      System.out.println("Test 3 for lastIndexOfMethod using testArray3Ex01 (should return 4 b/c last appearance of value 18 is at that index):\ntestArray3Ex01: " + testArray3Ex01 + "\nResult of testArray3Ex01.lastIndexOf(18): " + testArray3Ex01.lastIndexOf(18)+ "\n");
      System.out.println("---------Testing for HW05EX01 lastIndexOf END---------\n\n");
      
      System.out.println("---------Testing for HW05EX02 indexOfSublist BEGIN---------");
      //Array example from book (this one calls the method)
      ArrayIntList list1 = new ArrayIntList();
      list1.add(11);
      list1.add(-7);
      list1.add(3);
      list1.add(42);
      list1.add(0);
      list1.add(14);
      
      //2nd array that acts as sublist of 1st array from book(passed as parameter into method)
      ArrayIntList list2 = new ArrayIntList();
      list2.add(3);
      list2.add(42);
      list2.add(0);
      
      System.out.println("Test 1 for indexOfSublist using list 1 and list 2(list 1 calls indexOfSublist passing list 2 as param, should return index 2)(from book): \n" + "list1: " + list1 + "\nlist2: " + list2 + "\nlist1.indexOfSubList(list2): " + list1.indexOfSubList(list2) + "\n");
      
      //esdgeCase2, mentioned in exercise code
      ArrayIntList edgeCase1Calls = new ArrayIntList();
      edgeCase1Calls.add(0);
      edgeCase1Calls.add(12);
      edgeCase1Calls.add(22);
      edgeCase1Calls.add(23);
      
      ArrayIntList edgeCase1Param = new ArrayIntList();
      edgeCase1Param.add(22);
      edgeCase1Param.add(23);
      edgeCase1Param.add(36);
      edgeCase1Param.add(49);
      edgeCase1Param.add(62);
      edgeCase1Param.add(43);
      
      System.out.println("Test 2 for indexOfSublist using edgeCase1Calls and edgeCase1Param(edgeCase1Calls passing edgeCase1Param as param, should return 21): \n" + "edgeCase1Calls: " + edgeCase1Calls + "\nedgeCase1Param: " + edgeCase1Param + "\nedgeCase1Calls.indexOfSubList(edgeCase1Param): " + edgeCase1Calls.indexOfSubList(edgeCase1Param) + "\n");
      
      ArrayIntList edgeCase2Calls = new ArrayIntList();
      edgeCase2Calls.add(83);
      edgeCase2Calls.add(-43);
      edgeCase2Calls.add(54);
           
      ArrayIntList edgeCase2Param = new ArrayIntList();
   
      System.out.println("Test 3 for indexOfSublist using edgeCase2Calls and edgeCase2Param(edgeCase2Calls passing edgeCase2Param as param, should return 21): \n" + "edgeCase2Calls: " + edgeCase2Calls + "\nedgeCase2Param: " + edgeCase2Param + "\nedgeCase2Calls.indexOfSubList(edgeCase2Param): " + edgeCase2Calls.indexOfSubList(edgeCase2Param) + "\n");
   
      ArrayIntList test4Calls = new ArrayIntList();
      test4Calls.add(673);
      test4Calls.add(38);
      test4Calls.add(-32);
      test4Calls.add(30);
      test4Calls.add(96);
      test4Calls.add(17);
      test4Calls.add(0);
      
      ArrayIntList test4Param = new ArrayIntList();
      test4Param.add(-32);
      test4Param.add(30);
      test4Param.add(96);
      test4Param.add(0);
      test4Param.add(17);
      
      System.out.println("Test 4 for indexOfSublist using test4Calls and test4Param(test4Calls passing test4Param as param, should return 21): \n" + "test4Calls: " + test4Calls + "\ntest4Param: " + test4Param + "\ntest4Calls.indexOfSubList(test4Param): " + test4Calls.indexOfSubList(test4Param) + "\n");
   
      ArrayIntList test5Calls = new ArrayIntList();
      test5Calls.add(0);
      test5Calls.add(-2);
      test5Calls.add(1);
            
      ArrayIntList test5Param = new ArrayIntList();
      test5Param.add(-2);
      test5Param.add(1);
   
      
      System.out.println("Test 5 for indexOfSublist using test5Calls and test5Param(test5Calls passing test5Param as param, should return 1): \n" + "test5Calls: " + test5Calls + "\ntest5Param: " + test5Param + "\ntest5Calls.indexOfSubList(test5Param): " + test5Calls.indexOfSubList(test5Param) + "\n");
   
      System.out.println("---------Testing for HW05EX02 indexOfSublist END---------\n\n");
      
      
      System.out.println("---------Testing for HW05EX05 runningTotal BEGIN---------");
      
      ArrayIntList test1Ex05 = new ArrayIntList();
      test1Ex05.add(2);
      test1Ex05.add(3);
      test1Ex05.add(5);
      test1Ex05.add(4);
      test1Ex05.add(7);
      test1Ex05.add(15);
      test1Ex05.add(20);
      test1Ex05.add(7);
      
      System.out.println("Test 1 for running total using test1Ex05: \ntest1Ex05: " + test1Ex05 + "\nExpected array: [2, 5, 10, 14, 21, 36, 56, 63]\nResult after call test1Ex05.runningTotal(): " + test1Ex05.runningTotal() + "\n" );
   
      ArrayIntList test2Ex05 = new ArrayIntList();
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      test2Ex05.add(1);
      
      System.out.println("Test 2 for running total using test2Ex05: \ntest2Ex05: " + test2Ex05 + "\nExpected array: [1, 2, 3, 5, 6, 7, 8, 9, 10]\nResult after call test2Ex05.runningTotal(): " + test2Ex05.runningTotal() + "\n" );
   
      ArrayIntList test3Ex05 = new ArrayIntList();
   
      System.out.println("Test 3 for running total using test3Ex05: \ntest3Ex05: " + test3Ex05 + "\nExpected array: []\nResult after call test3Ex05.runningTotal(): " + test3Ex05.runningTotal() + "\n" );
   
      
      System.out.println("---------Testing for HW05EX05 runningTotal END---------\n\n");
   
      System.out.println("---------Testing for HW05EX08 count BEGIN---------");
      
      ArrayIntList list= new ArrayIntList();
      list.add(2);
      list.add(-3);
      list.add(2);  
      list.add(0);
      list.add(5);
      list.add(2);
      list.add(2);
      list.add(6);
   
      System.out.println("Test 1 for count using list (from book) and param as 2:\nlist: " + list + "\nResult after call list.count(2): " + list.count(2) + "\n");
      
      ArrayIntList test2 = new ArrayIntList();
      
      System.out.println("Test 2 for count using test2 and param as 0:\ntest2: " + test2 + "\nResult after call test2.count(2): " + test2.count(2) + "\n");
   
      System.out.println("---------Testing for HW05EX08 count END---------\n\n");
      
      System.out.println("---------Testing for HW05EX11 removeLast BEGIN---------");
      
      ArrayIntList listEx11 = new ArrayIntList(); 
      listEx11.add(8);
      listEx11.add(17);
      listEx11.add(42);
      listEx11.add(3);
      listEx11.add(8);
      
      System.out.println("Test 1 multiple calls of removeLast and proof of return by variable storage - using a for loop (using listEx11):\nlistEx11: " + listEx11);
      
      int removeLastReturn;
      int end = listEx11.size();
      for(int i=0; i<end; i++){
         removeLastReturn = listEx11.removeLast();
         System.out.println("i: " + i + "\nValue removed: "  + removeLastReturn + "\nlistEx11: " + listEx11);
      }
      System.out.println("\nNow since the array is empty, we will try to remove the last value once more. This will cause \nan EXCEPTION, as per exercise guidelines.\n(END OF CLIENT)Result of listEx11.removeLast(): ");
      listEx11.removeLast();
            
      System.out.println("---------Testing for HW05EX11 removeLast END---------");
   
   }

}