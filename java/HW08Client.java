/*Zohaib Javed HW 08 Chapter 17 Binary Trees - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/6/19*/

public class HW08Client{

   public static void main(String[] args){
   
      /*BELOW MARKS BEGINNING OF EXERCISE 01 COUNTLEFTNODES*/
   
      System.out.println("\n--------TESTING FOR CHAPT 17 HW08EX01 countLeftNodes() BEGIN------------\n");
      System.out.println("Reference Tree for test 1 (ref tree 1 from book): ");
      IntTree ex01t1 = new IntTree(createRefTree1());
      ex01t1.printSideways();
      ex01t1.printInorder();
      System.out.println("Test 1: Calling countLeftNodes using reference tree returns (3 expected (from book)): " + ex01t1.countLeftNodes());
        
      System.out.println("\nReference Tree for test 2 : ");
      IntTree ex01t2 = new IntTree(15);
      ex01t2.printSideways();
      ex01t2.printInorder();
      System.out.println("Test 2: Calling countLeftNodes using reference tree returns (7 expected): " + ex01t2.countLeftNodes());
        
      System.out.println("\nReference Tree for test 3: ");
      IntTree ex01t3 = new IntTree(7);
      ex01t3.printSideways();
      ex01t3.printInorder();
      System.out.println("Test 3: Calling countLeftNodes using reference tree returns (3 expected): " + ex01t3.countLeftNodes());
        
      System.out.println("\nReference Tree for test 4: ");
      IntTree ex01t4 = new IntTree(1);
      ex01t4.printSideways();
      ex01t4.printInorder();
      System.out.println("Test 4: Calling countLeftNodes using reference tree returns (0 expected): " + ex01t4.countLeftNodes());
        
      System.out.println("\nReference Tree for test 5: ");
      IntTree ex01t5 = new IntTree(3);
      ex01t5.printSideways();
      ex01t5.printInorder();
      System.out.println("Test 5: Calling countLeftNodes using reference tree returns (1 expected): " + ex01t5.countLeftNodes());
        
      System.out.println("\nEmpty Reference Tree for test 6: ");
      IntTree ex01t6 = new IntTree(10);
      ex01t6.clear();
      ex01t6.printSideways();
      ex01t6.printInorder();
      System.out.println("Test 6: Calling countLeftNodes using reference tree returns (0 expected): " + ex01t6.countLeftNodes());  
      System.out.println("\n--------TESTING FOR CHAPT 17 HW08EX01 countLeftNodes END------------\n\n");
      
      /*BELOW MARKS BEGINNING OF EXERCISE 05 PRINTLEVEL*/
      //I indented this block so the 3 separate exercise testing blocks are easier to see
        
         System.out.println("--------TESTING FOR CHAPT 17 HW08EX05 printLevel() BEGIN------------\n");
         System.out.println("Reference Tree for test 1 (refTree2 form book): ");
         IntTree ex05t1 = new IntTree(createRefTree2());
         ex05t1.printSideways();
         ex05t1.printInorder();
         System.out.println();
         System.out.println("Test 1: Calling printLevel(2) using reference tree produces (0 | 7 | 6 expected (from book)): ");
         ex05t1.printLevel(3);
               
         System.out.println("\nReference Tree for test 2 (refTree2 form book): ");
         ex05t1.printSideways();
         ex05t1.printInorder();
         System.out.println("Test 2: Calling printLevel(1) using reference tree produces (6 expected (from book)): ");
         ex05t1.printLevel(1);
               
         System.out.println("\nReference Tree for test 3 (refTree2 form book): ");
         ex05t1.printSideways();
         ex05t1.printInorder();
         System.out.println("Test 3: Calling printLevel(1) using reference tree produces (4 | 9 expected (from book)): ");
         ex05t1.printLevel(4);
               
         System.out.println("\nReference Tree for test 4: ");
         IntTree ex05t4 = new IntTree(15);
         ex05t4.printSideways();
         ex05t4.printInorder();
         System.out.println("Test 4: Calling printLevel(3) using reference tree produces (4 | 5 | 6 | 7 expected ): ");
         ex05t4.printLevel(3);
               
         System.out.println("\nEmpty Reference Tree for test 5: ");
         ex05t4.clear();
         ex05t4.printSideways();
         ex05t4.printInorder();
         System.out.println("Test 5: Calling printLevel(4) using reference tree produces (nothing expected ): ");
         ex05t4.printLevel(4);
         System.out.println("\n\n--------TESTING FOR CHAPT 17 HW08EX05 printLevel() END------------\n\n");
      
      /*BELOW MARKS BEGINNING OF EXERCISE 08 TOSTRING*/
            
      System.out.println("--------TESTING FOR CHAPT 17 HW08EX08 toString() BEGIN------------\n");
        
      System.out.println("\nReference Tree for test 1 (from book): ");
      IntTree ex08t1  = new IntTree(createRefTree2());
      ex08t1.printSideways();
      ex08t1.printInorder();
      System.out.println("Calling toString() using reference tree produces (\"(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))\" expected): \n" + ex08t1.toString());
    
      System.out.println("\nReference Tree for test 2: ");
      IntTree ex08t2  = new IntTree(7);
      ex08t2.printSideways();
      ex08t2.printInorder();
      System.out.println("Calling toString() using reference tree produces : \n" + ex08t2.toString());
        
      System.out.println("\nReference Tree for test 3: ");
      IntTree ex08t3  = new IntTree(15);
      ex08t3.printSideways();
      ex08t3.printInorder();
      System.out.println("Calling toString() using reference tree produces : \n" + ex08t3.toString());
        
      System.out.println("\nReference Tree for test 4: ");
      IntTree ex08t4  = new IntTree(1);
      ex08t4.printSideways();
      ex08t4.printInorder();
      System.out.println("Calling toString() using reference tree produces : \n" + ex08t4.toString());
        
      System.out.println("\nEmpty Reference Tree for test 5: ");
      IntTree ex08t5  = new IntTree(15);
      ex08t5.clear();
      ex08t5.printSideways();
      ex08t5.printInorder();
      System.out.println("Calling toString() using reference tree produces : \n" + ex08t5.toString());
        
      System.out.println("\nReference Tree for test 6: ");
      IntTree ex08t6  = new IntTree(3);
      ex08t6.printSideways();
      ex08t6.printInorder();
      System.out.println("Calling toString() using reference tree produces : \n" + ex08t6.toString());
    
      System.out.println("\n--------TESTING FOR CHAPT 17 HW08EX08 toString() END------------");
     
   }
   
   //Creates reference tree 1 as appears in BJP ed 4 Chapter 17 Exercises
   public static IntTreeNode createRefTree1(){
      IntTreeNode root = new IntTreeNode(3);
      root.left = new IntTreeNode(5);
      root.left.left = new IntTreeNode(1);
      root.right = new IntTreeNode(2);
      root.right.left = new IntTreeNode(4);
      root.right.right = new IntTreeNode(6);
      return root;
   }
    
   //Creates reference tree 2 as appears in BJP ed 4 Chapter 17 Exercises 
   public static IntTreeNode createRefTree2(){
      IntTreeNode root = new IntTreeNode(2);
      root.left = new IntTreeNode(8);
      root.left.left = new IntTreeNode(0);
      root.right = new IntTreeNode(1);
      root.right.left = new IntTreeNode(7);
      root.right.left.left = new IntTreeNode(4);
      root.right.right = new IntTreeNode(6);
      root.right.right.right = new IntTreeNode(9);
      return root;
   }

}