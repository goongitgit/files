/*Zohaib Javed HW 09 Chapter 18 Advanced Data Structures - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/16/19*/

import java.util.*;

// Implements a set of integers using a hash table.
// The hash table uses separate chaining to resolve collisions.
public class HashIntSet {
   private static final double MAX_LOAD_FACTOR = 0.75;
   private HashEntry[] elementData;
   private int size;
   
   // Constructs an empty set.
   public HashIntSet() {
      elementData = new HashEntry[10];
      size = 0;
   }
   
   //CHAPTER 18 HW09 EXERCISE 01 addAll()
     //Write a method in the HashIntSet class called addAll that accepts another hash set as a parameter and 
    //adds all of the elements from the other set into the current set. For example, if the set stores [-5, 1, 2, 3] 
   //and the method is passed [2, 3, 6, 44, 79], your set would store [-5, 1, 2, 3, 6, 44, 79].
   public void addAll(HashIntSet inputSet){
      //need to go through elementData array's chain
      int endindex = inputSet.elementData.length;
      for(int i = 0; i < endindex; i++){
          //if a node at index i is not null, save that node to go through 
         //a possible linked chain
         if(inputSet.elementData[i] != null){
            //saving of node to go through possible node chain
            HashEntry nodeAtI = inputSet.elementData[i];
             //go through possible chain by beginning from node at index i
            //checking if null, if not null add value of node to parent set
            while(nodeAtI != null){
               //add value
               add(nodeAtI.data);
               //make nodeAtI equal to next field, so traversal can continue
               nodeAtI = nodeAtI.next;
            }
         }
      }
   }
   
   //CHAPTER 18 HW09 - EXERCISE 02 containsAll()
      //Write a method in the HashIntSet class called containsAll that accepts another hash set as a parameter 
     //and returns true if your set contains every element from the other set. For example, if the set stores 
    //[-2, 3, 5, 6, 8] and the method is passed [3, 6, 8], your method would return true. If the method were 
   //passed [3, 6, 7, 8], your method would return false because your set does not contain the value 7.
   public boolean containsAll(HashIntSet inputSet){
         //Quick cases to evaluate the two sets based on whether or not they are empty
        //If parent set is empty and input isnt empty, parent does not contain inputSet
       //If parent set is not empty and input is, return true because parent does contain 
      //"no element"
      if(isEmpty() && !inputSet.isEmpty()){
         return false;}
      if(!isEmpty() && inputSet.isEmpty()){
         return true;}
   
      //Storage of endindex
      int endindex = inputSet.elementData.length;
      for(int i = 0; i < endindex; i++){
           //if a node at index i is not null, save that node to go through 
          //a possible linked chain to check for possible data values that 
         //exist in the parent set
         if(inputSet.elementData[i] != null){
            //saving of node to go through possible node chain
            HashEntry nodeAtI = inputSet.elementData[i];
              //go through possible chain by beginning from node at index i
             //checking if null, if not null check to see if value exists in 
            //parent set
            while(nodeAtI != null){
                //if parent set does not have current node value
               //immediately return false
               if(!contains(nodeAtI.data)){  
                  return false;   
               }
               //advance to next node
               nodeAtI = nodeAtI.next;
            }
         }
         
      }
      //no differences found, return inital flag value true
      return true;
   }
   
   //CHAPTER 18 HW09 EXERCISE 03 equals FOR HashIntSetIntSet    
     //Write a method in the HashIntSet class called equals that accepts another hash set as a parameter and returns 
    //true if the two sets contain exactly the same elements. The internal hash table size and ordering of the elements does not matter, 
   //only the sets of elements themselves.
   public boolean equals(HashIntSet inputSet){
      if(isEmpty() && inputSet.isEmpty()){
         return true;}
      //code of equals method is same as contains except that size of both sets also need to be compared
      if(!isEmpty() && !inputSet.isEmpty() && size() == inputSet.size()){
         //Storage of endindex
         int endindex = inputSet.elementData.length;
         for(int i = 0; i < endindex; i++){
          //if a node at index i is not null, save that node to go through 
         //a possible linked chain to check for possible data values that 
         //exist in the parent set
            if(inputSet.elementData[i] != null){
            //saving of node to go through possible node chain
               HashEntry nodeAtI = inputSet.elementData[i];
             //go through possible chain by beginning from node at index i
            //checking if null, if not null chekc to see if value exists in 
            //parent set
               while(nodeAtI != null){
               //if parent set does not have current ndoe value
               //immediately return false
                  if(!contains(nodeAtI.data)){  
                     return false;
                  }
               //advance to next node
                  nodeAtI = nodeAtI.next;
               }
            }
         
         }
      //no differnces found, return inital flag value true
         return true;
      } else {
         return false;
      }
   }
   
   
   // Adds the given element to this set, if it was not already
   // contained in the set.
   public void add(int value) {
      if (!contains(value)) {
         if (loadFactor() >= MAX_LOAD_FACTOR) {
            rehash();
         }
         
         // insert new value at front of list
         int bucket = hashFunction(value);
         elementData[bucket] = new HashEntry(value, elementData[bucket]);
         size++;
      }
   }
   
   // Removes all elements from the set.
   public void clear() {
      for (int i = 0; i < elementData.length; i++) {
         elementData[i] = null;
      }
      size = 0;
   }
   
   // Returns true if the given value is found in this set.
   public boolean contains(int value) {
      int bucket = hashFunction(value);
      HashEntry current = elementData[bucket];
      while (current != null) {
         if (current.data == value) {
            return true;
         }
         current = current.next;
      }
      return false;
   }
   
   // Returns true if there are no elements in this queue.
   public boolean isEmpty() {
      return size == 0;
   }
   
   // Removes the given value if it is contained in the set.
   // If the set does not contain the value, has no effect.
   public void remove(int value) {
      int bucket = hashFunction(value);
      if (elementData[bucket] != null) {
         // check front of list
         if (elementData[bucket].data == value) {
            elementData[bucket] = elementData[bucket].next;
            size--;
         } else {
            // check rest of list
            HashEntry current = elementData[bucket];
            while (current.next != null && current.next.data != value) {
               current = current.next;
            }
            
            // if the element is found, remove it
            if (current.next != null && current.next.data == value) {
               current.next = current.next.next;
               size--;
            }
         }
      }
   }
   
   // Returns the number of elements in the queue.
   public int size() {
      return size;
   }
   
   // Returns a string representation of this queue, such as "[10, 20, 30]";
   // The elements are not guaranteed to be listed in sorted order.
   public String toString() {
      String result = "[";
      boolean first = true;
      if (!isEmpty()) {
         for (int i = 0; i < elementData.length; i++) {
            HashEntry current = elementData[i];
            while (current != null) {
               if (!first) {
                  result += ", ";
               }
               result += current.data;
               first = false;
               current = current.next;
            }
         }
      }
      return result + "]";
   }
   
   
   // Returns the preferred hash bucket index for the given value.
   private int hashFunction(int value) {
      return Math.abs(value) % elementData.length;
   }
   
   private double loadFactor() {
      return (double) size / elementData.length;
   }
   
   // Resizes the hash table to twice its former size.
   private void rehash() {
      // replace element data array with a larger empty version
      HashEntry[] oldElementData = elementData;
      elementData = new HashEntry[2 * oldElementData.length];
      size = 0;
   
      // re-add all of the old data into the new array
      for (int i = 0; i < oldElementData.length; i++) {
         HashEntry current = oldElementData[i];
         while (current != null) {
            add(current.data);
            current = current.next;
         }
      }
   }
   
   // Represents a single value in a chain stored in one hash bucket.
   class HashEntry {
      public int data;
      public HashEntry next;
   
      public HashEntry(int data) {
         this(data, null);
      }
   
      public HashEntry(int data, HashEntry next) {
         this.data = data;
         this.next = next;
      }
   }
}


