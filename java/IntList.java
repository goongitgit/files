/*Zohaib Javed HW 07 Chapter 16 LinkedIntList - TEST CLIENT
James Livingston - CS 211 - Fall 2019
10/24/19*/

public interface IntList {
   public int size();
   public int get(int index);
   public String toString();
   public int indexOf(int value);
   public void add(int value);
   public void add(int index, int value);
   public void remove(int index);
   public void switchPairs();
   public void split();
   public void clear();// I added for testing in client
}