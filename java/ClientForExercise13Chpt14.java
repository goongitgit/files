/*Zohaib Javed HW 04 Exercise 06 Chapter 14
James Livingston - CS 211 - Fall 2019
10/10/19
Write a method called expunge that accepts a stack of integers as a parameter and makes
sure that the stack's elements are in nondecreasing order from top to bottom, by removing
from the stack any element that is smaller than any element(s) on top of it. For example,
if the stack stores [4, 20, 15, 15, 8, 5, 7, 12, 3, 10, 5, 1], the
element values 3, 7, 5, 8, and 4 should be removed because
each has an element above it with a larger value. So your method should change the stack
to store [20, 15, 15, 12, 10, 5, 1]. Notice that now the elements are in nondecreasing order
from top to bottom. If the stack is empty or has just one element, nothing changes. Use one queue
or stack (but not both) as auxiliary storage.*/
import java.util.*;

public class ClientForExercise13Chpt14
{
   public static void main(String[] args) {
      Stack<Integer> test = new Stack<Integer>();
      test.push(4);
      test.push(20);
      test.push(15);
      test.push(15);
      test.push(8);
      test.push(5);
      test.push(7);
      test.push(12);
      test.push(3);
      test.push(10);
      test.push(5);
      test.push(1);
   
      System.out.println("\n----------------Testing for Exercise 13 (expunge) BEGIN----------------\n");   
      System.out.println("test before call to expunge: " + test);
      expunge(test);
      System.out.println("test after call to expunge: " + test);
      System.out.println("\n----------------Testing for Exercise 13 (expunge) END----------------\n");
   }

   public static void expunge(Stack<Integer> inputStack){
   
      Stack<Integer> auxStack = new Stack<Integer>();
      
      //Check to make sure emptyStackException will not be thrown
      if(inputStack.size() > 1){
         //Pulls values from input stack, the top, and element after it
         int top = inputStack.pop();
         int nextInt = inputStack.peek();
         
          //The following checks for nondecreasing order of the first elemnet pair, and adds the top and nextInt if the top is less than or equal to nextInt, 
         //i.e, non-decreasing order. If top<= nextInt is false, it will add to the auxStack the nextInt, since it is larger than the top.
         if(top <= nextInt){
            auxStack.push(top);
            auxStack.push(inputStack.pop());
         } else {        
            auxStack.push(inputStack.pop());
         }
      
             //Since we have at least one value in the auxStack, now we can have a while loop that will
            //peek at the auxStack, and compare it to the top value of the input stack. If the values compared
           //are in nondecreasing order (top value of auxStack is less than top value of inputStack), then
          //the inputStack's value is added to the AuxStack, if the values are not in nondecreasing order,
         //then inputStack's top value is removed so the next value can be compared.
         while(!inputStack.isEmpty()){
         
            if(auxStack.peek() <= inputStack.peek()){
               auxStack.push(inputStack.pop());
            } else {
               inputStack.pop();
            }
           
         }
      
           //Now that the auxStack contains the numebrs is nondecreasing order they can be added back to the input stack. Since 
          //we initially took the numbers out of a stack and put them back into the stack, the order is maintained, so we just add
         //the values back
         while(!auxStack.isEmpty()){
            inputStack.push(auxStack.pop());
         }
      }
       
   }
}
