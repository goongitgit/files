/*Zohaib Javed HW 07 Chapter 16 LinkedIntList - TEST CLIENT
James Livingston - CS 211 - Fall 2019
10/24/19*/

public class ListClient {
   public static void main(String[] args) {
          //I forgot to ask you if we had to use this client to test methods
         //but since you specified for us to use ListClient, I just used this helper 
        //method in this ListClient to test methods.
      LinkedIntList testlist = new LinkedIntList();
      processList(testlist);
   }

   public static void processList(IntList list) {
      System.out.println("--------TESTING FOR CHPT16LinkedIntList HW07EX08 switchPairs() BEGIN---------\n");
      list.add(18);
      list.add(-27);
      list.add(93);
      list.add(-98);
      list.add(-100);
      list.add(0);
      System.out.println("initial list: " + list);
      list.switchPairs();
      System.out.println("list after calling switchPairs (since list has even numbers of elements, all pairs will be switched): \n" + list );
      
      list.remove(list.size()-1);
      System.out.println("\nAfter removing last value from list, list becomes: " + list);
      System.out.println("list now has odd number of elements, a call to switchPairs should switch all pairs except 0");
      list.switchPairs();
      System.out.println("list after calling switchPairs again (odd number elements, 0 will be unaltered): " + list);
      list.clear();
      System.out.println("\ncleared list: " + list);
      list.switchPairs();
      System.out.println("Passing the empty list through switchPairs (nothing will be altered): " + list);
      list.add(4);
      list.add(3);
      System.out.println("\nlist after adding 2 elements: " + list);
      list.switchPairs();
      System.out.println("after calling switchPairs(): " + list);
      list.remove(1);
      System.out.println("\nlist after removing second value: " + list);
      list.switchPairs();
      System.out.println("list after calling switchPairs(): " + list);
      list.clear();
      System.out.println("\n--------TESTING FOR CHPT16LinkedIntList HW07EX08 switchPairs() END---------\n\n");  
      
      System.out.println("--------TESTING FOR CHPT16LinkedIntList HW07EX12 split() BEGIN---------\n"); 
      list.add(-3);
      list.add(-4);
      list.add(-9);
      list.add(98);
      list.add(4);
      list.add(0);
      list.add(-1);
      list.add(10);
      System.out.println("Initial list: " + list);
      list.split();
      System.out.println("list after calling split(): " + list);
      list.clear();
      list.add(-3);
      list.add(-4);
      list.add(-5);
      list.add(-6);
      list.add(-7);
      list.add(-8);
      list.add(-9);
      list.add(-10);
      System.out.println("\ncleared list, added all negative values. current list: " + list);
      list.split();
      System.out.println("list after calling split() (values will appear in reverse order, list is still intact): " + list);
      list.clear();
      list.add(-3);
      list.add(4);
      list.add(-5);
      list.add(6);
      list.add(-7);
      list.add(8);
      list.add(-9);
      list.add(10);
      System.out.println("\nlist cleared. negative and positive values added in alternating order. current list: " + list);
      list.split();
      System.out.println("list after calling split(): " + list);
      
      list.clear();
      list.add(2);
      list.add(-2);
      System.out.println("\nlist cleared. current list: " + list);
      list.split();
      System.out.println("list after calling split(): " + list);
      
      list.clear();
      list.add(-1);
      list.add(-2);
      System.out.println("\nlist cleared. current list: " + list);
      list.split();
      System.out.println("list after calling split(): " + list);
      
      list.clear();
      list.add(2);
      list.add(2);
      System.out.println("\nlist cleared. current list: " + list);
      list.split();
      System.out.println("list after calling split(): " + list);
      
      list.clear();
      System.out.println("\nlist cleared. current list: " + list);
      list.split();
      System.out.println("list after calling split() with empty list: " + list);
      
      
      System.out.println("\n--------TESTING FOR CHPT16LinkedIntList HW07EX12 split() END---------\n"); 
   }
}