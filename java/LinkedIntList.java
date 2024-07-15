/*Zohaib Javed HW 07 Chapter 16 LinkedIntList - TEST CLIENT
James Livingston - CS 211 - Fall 2019
10/24/19*/

public class LinkedIntList implements IntList{
   private ListNode front;  // first value in the list

   // post: constructs an empty list
   public LinkedIntList() {
      front = null;
   }
   
   //Chapter 16 LinkedIntList - HW07 - Exercise 08 - switchPairs()
        //Write a method called switchPairs that switches the order of values in the list in 
       //a pairwise fashion. Your method should switch the order of the first two values, then 
      //switch the order of the next two, switch the order of the next two, and so on. If the list 
     //contains an odd number of values, the final element is not moved. For example, if the list 
    //initially stores [10, 25, 31, 47, 52, 68, 77], your method should switch the first pair (10 and 25), 
   //the second pair (31 and 47), and the third pair (52 and 68) to yield [25, 10, 47, 31, 68, 52, 77].
   public void switchPairs(){
       //node set for traversal
      ListNode current = front;
      //check for empty list and next element exists
      while(front != null && current.next != null){
         //store current node data
         int currentData = current.data;
         //set current node's data to next node's data
         current.data = current.next.data;
          //set next node's data to the previous node's data that we stored
         //in temp int variable currentData
         current.next.data = currentData;
            //if there are two more nodes present, skip from the current node 
           //to 2 nodes ahead, if that evaluates to false, we can break since if there
          //aren't two more values ther is only 1 value left, and we don't need to change 
         //that value.
         if(current.next.next != null){
            current = current.next.next;
         } else { 
            break;}
      }
   }
   
   //Chapter 16 LinkedIntList - HW07 - Exercise 12 - split()
        //Write a method called split that rearranges the elements of a list so that all of the negative values appear 
       //before all of the nonnegatives. For example, suppose a variable list stores the values [8, 7, -4, 19, 0, 43, -8, -7, 2]. 
      //The call of list.split(); should rearrange the list to put the negatives first: [-4, -8, -7, 8, 7, 19, 0, 43, 2]. 
     //It doesn't matter what order the numbers are in, only that the negatives appear before the nonnegatives, so this is 
    //only one possible solution. You must solve the problem by rearranging the links of the list, not by swapping data values 
   //or creating new nodes. You also may not use auxiliary structures like arrays or ArrayLists to solve this problem.
   public void split(){
       //node for traversal
      ListNode currentNode = front;
      //check for empty list and that next element exists
      while(currentNode != null && currentNode.next != null){
          //check's if next value is negative
         if(currentNode.next.data < 0){
             //save the negative node in a temp
            ListNode temp = currentNode.next;
            //join together the current node and teh node after the negative node
            currentNode.next = temp.next;
            //connects negative node to front node
            temp.next = front;
            //point fornt node to the negative node stored in temp
            front = temp;
            
             //this process automatically points current.next to next value to be examined,
            //so if the neg value check never entered, we just move to the next node
         } else {
            currentNode = currentNode.next;
         }
      }
   }
   
   // post: returns the current number of elements in the list
   public int size() {
      int count = 0;
      ListNode current = front;
      while (current != null) {
         current = current.next;
         count++;
      }
      return count;
   }

   // pre : 0 <= index < size()
   // post: returns the integer at the given index in the list
   public int get(int index) {
      return nodeAt(index).data;
   }

   // post: creates a comma-separated, bracketed version of the list
   public String toString() {
      if (front == null) {
         return "[]";
      } else {
         String result = "[" + front.data;
         ListNode current = front.next;
         while (current != null) {
            result += ", " + current.data;
            current = current.next;
         }
         result += "]";
         return result;
      }
   }

   // post : returns the position of the first occurrence of the given
   //        value (-1 if not found)
   public int indexOf(int value) {
      int index = 0;
      ListNode current = front;
      while (current !=  null) {
         if (current.data == value) {
            return index;
         }
         index++;
         current = current.next;
      }
      return -1;
   }

   // post: appends the given value to the end of the list
   public void add(int value) {
      if (front == null) {
         front = new ListNode(value);
      } else {
         ListNode current = front;
         while (current.next != null) {
            current = current.next;
         }
         current.next = new ListNode(value);
      }
   }

   // pre: 0 <= index <= size()
   // post: inserts the given value at the given index
   public void add(int index, int value) {
      if (index == 0) {
         front = new ListNode(value, front);
      } else {
         ListNode current = nodeAt(index - 1);
         current.next = new ListNode(value, current.next);
      }
   }

   // pre : 0 <= index < size()
   // post: removes value at the given index
   public void remove(int index) {
      if (index == 0) {
         front = front.next;
      } else {
         ListNode current = nodeAt(index - 1);
         current.next = current.next.next;
      }
   }

   // pre : 0 <= i < size()
   // post: returns a reference to the node at the given index
   private ListNode nodeAt(int index) {
      ListNode current = front;
      for (int i = 0; i < index; i++) {
         current = current.next;
      }
      return current;
   }
   
   public void clear(){
      front =null;
   }
}