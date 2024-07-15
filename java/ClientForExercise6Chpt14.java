/* Zohaib Javed HW 04 Exercise 06 Chapter 14
James Livingston - CS 211 - Fall 2019
10/10/19
Chapter 14 Exercise 6:Write a method called rearrange that accepts a queue of integers as a parameter and rearranges
the order of the values so that all of the even values appear before the odd values and that otherwise
preserves the original order of the queue. For example, if the queue stores
[3, 5, 4, 17, 6, 83, 1, 84, 16, 37], your method should rearrange it to store

[4, 6, 84, 16, 3, 5, 17, 83, 1, 37]. Notice that all of the evens appear at the front followed by the odds
and that the relative order of the evens and odds is the same as in the original. Use one stack as auxiliary storage.*/
import java.util.*;

public class ClientForExercise6Chpt14
{
   public static void main(String[] args) {
      //Create test queue
      Queue<Integer> test = new LinkedList<Integer>();
      test.add(3);
      test.add(5);
      test.add(4);
      test.add(17);
      test.add(6);
      test.add(83);
      test.add(1);
      test.add(84);
      test.add(16);
      test.add(37);
      System.out.println("\n----------------Testing for Exercise 6 (rearrange) BEGIN----------------\n");
   
      System.out.println("test queue before calling rearrange: " + test);
      rearrange(test);
      System.out.println("test queue after calling rearrange: " + test);
      
      System.out.println("\n----------------Testing for Exercise 6 (rearrange) END----------------\n");
   
   }

   public static void rearrange(Queue<Integer> givenQueue){
      Stack<Integer> auxStorage = new Stack<Integer>();
      //Used to make sure loop goest through queue correct number of times   
         int initialSize = givenQueue.size();
      
        //The following loop works by looking at first element of queue, if it is even, 
       //it removes it from the front and adds it to the back.
      //If the value is odd, it removes that value and adds it to the aux Stack.
      for(int i = 0; i<initialSize; i++){
         if((givenQueue.peek() % 2) != 0){
           
            auxStorage.push(givenQueue.remove());
         } else{
            givenQueue.add(givenQueue.remove());
           
         }
      }
   
        //Once all the odd numbers are in the aux stack, they are re-added to the Queue.
       //And since all we did with even numbers was move them to the back in the order we 
      //encountered them, they retain their order while staying at the front of the queue.
      while(!auxStorage.isEmpty()){
         givenQueue.add(auxStorage.pop());
      }
   
         //Now the even numbers retain their order and are followed by odd numbers in the stack. 
        //However, the odd #'s are reversed, so they are added to the stack and re-added to the queue
       //once more to re-reverse their order, thereby maintaining the order of both odd and even numbers,
      //with the correct precedence. The following two blocks achieve that task.
      for(int i = 0; i<initialSize; i++){
         if((givenQueue.peek() % 2) != 0){
           
            auxStorage.push(givenQueue.remove());
         } else{
            givenQueue.add(givenQueue.remove());
           
         }
      }
   
      while(!auxStorage.isEmpty()){
         givenQueue.add(auxStorage.pop());
      }
   
   }

}