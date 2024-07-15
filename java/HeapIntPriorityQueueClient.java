/*Zohaib Javed HW 09 Chapter 18 Advanced Data Structures - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/16/19*/

import java.util.*;

public class HeapIntPriorityQueueClient
{
   public static void main(String[] args) {
      
      System.out.println("************BEGIN TEST CLIENT FOR HEAP/PRIORITYQUEUE EXERCISES 9 AND 11 OF CHAPTER 18 HW09************\n\n");
   	
   	/*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
   	
      System.out.println("^^^^^^^^^^^^^^^^BEGIN PROVIDED CLIENT FROM CANVAS MODULES^^^^^^^^^^^^^^^^");
       
      HeapIntPriorityQueue pq = new HeapIntPriorityQueue();
      int[] elements = {65, 50, 20, 90, 44, 60, 80, 70, 99, 10};
      for (int n : elements) {
         pq.add(n);
         System.out.println(pq);
      }
      
      // System.out.println(pq);
      while (!pq.isEmpty()) {
         System.out.println(pq.remove());
         System.out.println(pq + ", size "+ pq.size());
      }
      
      System.out.println("^^^^^^^^^^^^^^^^END PROVIDED CLIENT FROM CANVAS MODULES^^^^^^^^^^^^^^^^\n\n");
      
      /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
      
      System.out.println("<<<<<<<<<<<<<<<<<BEGIN TESTING FOR HW09 CHAPTER 18 EXERCISE 09 kthSmallest() FOR PRIORITYQUEUE>>>>>>>>>>>>>>>>>");
      
       //For example, if the queue passed stores the 
      //integers [42, 50, 45, 78, 61] and k is 4, return the fourth-smallest integer, which is 61. 
      HeapIntPriorityQueue pq1 = new HeapIntPriorityQueue();
      pq1.add(42);
      pq1.add(50);
      pq1.add(45);
      pq1.add(78);
      pq1.add(61);
      
      System.out.println("(From book)Test 1: \nheapintpriorityqueue(pq1): " + pq1);
      System.out.println("(From book)Test 1: Calling kthSmallest(pq1, 4) returns (should return 61): \n" + kthSmallest(pq1, 4) + "\n");
      
      HeapIntPriorityQueue pq2 = new HeapIntPriorityQueue();
      pq2.add(1);
      pq2.add(2);
      pq2.add(3);
      
      System.out.println("Test 2: \nheapintpriorityqueue(pq2): " + pq2);
      System.out.println("Test 2: Calling kthSmallest(pq2, 3) returns (should return 3): \n" + kthSmallest(pq2, 3) + "\n");
      
      HeapIntPriorityQueue pq3 = new HeapIntPriorityQueue();
      pq3.add(1);
      pq3.add(2);
      pq3.add(3);
      pq3.add(4);
      pq3.add(5);
      pq3.add(6);
      
      System.out.println("Test 3: \nheapintpriorityqueue(pq3): " + pq3);
      System.out.println("Test 3: Calling kthSmallest(pq3, 4) returns (should return 4): \n" + kthSmallest(pq3, 4) + "\n");
      
      HeapIntPriorityQueue pq4 = new HeapIntPriorityQueue();
      pq4.add(30);
      pq4.add(29);
      pq4.add(1);
      pq4.add(-4);
      pq4.add(9);
      pq4.add(109);
      
      System.out.println("Test 4: \nheapintpriorityqueue(pq4): " + pq4);
      System.out.println("Test 4: Calling kthSmallest(pq4, 1) returns (should return -4): \n" + kthSmallest(pq4, 1));
      
      System.out.println("<<<<<<<<<<<<<<<<<END TESTING FOR HW09 CHAPTER 18 EXERCISE 09 kthSmallest() FOR PRIORITYQUEUE>>>>>>>>>>>>>>>>>\n\n");
      
      /*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
      
      System.out.println("##################BEGIN TESTING FOR HW09 CHAPTER 18 EXERCISE 11 removeDuplicates() FOR PRIORITYQUEUE##################");
   
      //[7, 7, 8, 8, 8, 10, 45, 45]
      HeapIntPriorityQueue pq6 = new HeapIntPriorityQueue();
      pq6.add(7);
      pq6.add(7);
      pq6.add(8);
      pq6.add(8);
      pq6.add(8);
      pq6.add(10);
      pq6.add(45);
      pq6.add(45);
      
      System.out.println("(From book)Test 1: \nheapintpriorityqueue(pq6): " + pq6);
      removeDuplicates(pq6);
      System.out.println("(From book)Test 1: Calling removeDuplicates(pq6) (should return [7, 8, 10, 45]): \n" + pq6 + "\n");
      
      HeapIntPriorityQueue pq7 = new HeapIntPriorityQueue();
      pq7.add(3);
      pq7.add(6);
      pq7.add(3);
      pq7.add(6);
      pq7.add(3);
      pq7.add(6);
      pq7.add(3);
      pq7.add(45);
      
      System.out.println("Test 2: \nheapintpriorityqueue(pq7): " + pq7);
      removeDuplicates(pq7);
      System.out.println("Test 2: Calling removeDuplicates(pq7) (should return [3, 45, 6]): \n" + pq7 + "\n");
      
      HeapIntPriorityQueue pq8 = new HeapIntPriorityQueue();
      
      System.out.println("Test 3: \nheapintpriorityqueue(pq8): " + pq8);
      removeDuplicates(pq8);
      System.out.println("Test 3: Calling removeDuplicates(pq8) (should return []): \n" + pq8 + "\n");
      
      HeapIntPriorityQueue pq9 = new HeapIntPriorityQueue();
      pq9.add(30);
      pq9.add(300);
      pq9.add(30);
      pq9.add(320);
      pq9.add(62);
      pq9.add(-62);
      pq9.add(35);
      pq9.add(0);
      pq9.add(-62);
      
      System.out.println("Test 4: \nheapintpriorityqueue(pq9): " + pq9);
      removeDuplicates(pq9);
      System.out.println("Test 4: Calling removeDuplicates(pq8) (should return [-62, 35, 0, 320, 62, 300, 30]): \n" + pq9);
      
      System.out.println("##################END TESTING FOR HW09 CHAPTER 18 EXERCISE 11 removeDuplicates() FOR PRIORITYQUEUE##################\n\n");
   	
   	/*|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||BLOCK SEPARATOR|||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||*/
   	
      System.out.println("************END TEST CLIENT FOR HEAP/PRIORITYQUEUE EXERCISES 9 AND 11 OF CHAPTER 18 HW09************");
   }

	//CHAPTER 18 HW09 EXERCISE 09 kthSmallest()
        //Write a method called kthSmallest that accepts a PriorityQueue of integers and an integer k as parameters 
       //and returns the kth-smallest integer from the priority queue. For example, if the queue passed stores the 
      //integers [42, 50, 45, 78, 61] and k is 4, return the fourth-smallest integer, which is 61. 
     //If k is 0 or negative or greater than the size of the queue, throw an IllegalArgumentException. 
    //If your method modifies the state of the queue during its computation, it should restore the queue before it returns. 
   //You may use one stack or queue as auxiliary storage.
   public static int kthSmallest(HeapIntPriorityQueue pq, int k){
       //throw exception if k is greater than size of queue, because that element would not exist
      //or if k is less than or equal to zero as that element doesn't exist either
      if(k <= 0 || k >pq.size()){throw new IllegalArgumentException();}
      //initialization of variable which will store int to return
      int kthSmallest = 0;
      //aux structure to hold data
      Queue<Integer> aux = new LinkedList<Integer>();
      //for loop that runs based on k, taking out elements of pq
      for(int i = 0; i < k; i++){
           //since the class operates on a min-heap, we know everytime we get the ith samllest element
          //so all we need to do is remove the root element of the heap k-1 times so we can just peek at the root 
         //and store that int into the variable to return. We cannot just return here because the queue's state has been modified 
         
         //if the root is not the kth - 1 element, keep removing values and add to auxillary structure
         if(i != k-1){
            aux.add(pq.remove());
         //otherwise store the kth smallest element (current root of heap), so it can be returned
         //later
         } else {
            kthSmallest = pq.peek();
         }
      }
      //now that we have the target element, use a for loop to go through auxillary structure to restore the queue's state
      int endIndex = aux.size();
      for(int i = 0; i < endIndex; i++){
         pq.add(aux.remove());
      }
      //now return the target value which was found in first for loop
      return kthSmallest;
   }
   
   //CHAPTER 18 HW09 EXERCISE 11 - removeDuplicates()
      //Write a method called removeDuplicates that accepts a PriorityQueue of integers as a parameter 
     //and modifies the queue's state so that any element that is equal to another element in the queue is removed. 
    //For example, if the queue stores [7, 7, 8, 8, 8, 10, 45, 45], your method should modify the queue to store 
   //[7, 8, 10, 45]. You may use one stack or queue as auxiliary storage.
   public static void removeDuplicates(HeapIntPriorityQueue pq){
      //store end index for pq so that for loop runs a proper amount of times
      int end = pq.size();
      //aux structure
      Stack<Integer> aux = new Stack<Integer>();
      //if queue isn't empty take root from pq, and add to aux structure so that checks for duplicates can begin 
      if(!pq.isEmpty()){
         aux.push(pq.remove());
      }
      for(int i = 0; i < end; i++){
            //next if checks compare last value of aux structure and next value to come out of pq
           //(root of pq) to see how to handle root, whether or not to remove the value from the pq structure completely
          //or add it to aux structure because its not a duplicate, we can test this way because if there are any duplicates
         //in the pq, they will come out right after one another because of the way a pq is designed.
         
          //if pq has a root node, compare it ot the first last value in the aux, if they are not equal 
         //(i.e. they are not duplicates), add to the auxillary structure
         if(!pq.isEmpty() && pq.peek() != aux.peek()){
            aux.push(pq.remove());
         //if the value in the root of pq is the same as the last value in the aux,
         //remove the value from pq and do not add it to aux
         } else if(!pq.isEmpty() && pq.peek() == aux.peek()) {
            pq.remove();
         }
      }
      //record initial size of queue
      end = aux.size();
      //add all non duplicate elements stored in queue from aux structure back into pq
      for(int i = 0; i < end; i++){
         pq.add(aux.pop());
      }
   }
}