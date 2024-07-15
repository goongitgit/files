/*Zohaib Javed HW 08 Chapter 17 Binary Trees - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/6/19*/

public class IntTreeNode {
   public int data;
   public IntTreeNode left;
   public IntTreeNode right;
               
   // constructs a leaf node with given data
   public IntTreeNode(int data) {
      this(data, null, null);
   }
                       
   // constructs a branch node with given data, left subtree,
   // right subtree
   public IntTreeNode(int data, IntTreeNode left, 
                      IntTreeNode right) {
      this.data = data;
      this.left = left;
      this.right = right;
   }
}





