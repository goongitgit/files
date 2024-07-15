/*Zohaib Javed HW 08 Chapter 17 Binary Trees - TEST CLIENT
James Livingston - CS 211 - Fall 2019
11/6/19*/

public class IntTree {
   private IntTreeNode overallRoot;

   // pre : max > 0
   // post: constructs a sequential tree with given number of
   //       nodes
   public IntTree(int max) {
      if (max <= 0) {
         throw new IllegalArgumentException("max: " + max);
      }
      overallRoot = buildTree(1, max);
   }

   // post: returns a sequential tree with n as its root unless
   //       n is greater than max, in which case it returns an
   //       empty tree
   private IntTreeNode buildTree(int n, int max) {
      if (n > max) {
         return null;
      } else {
         return new IntTreeNode(n, buildTree(2 * n, max),
                               buildTree(2 * n + 1, max));
      }
   }
   
   //**************************************************//
   //I added a clear method added for testing in client
   public void clear(){
      overallRoot = null;
   }
   
   //I created this contsructor to be able to pass in a handcrafted tree,
   //and use the methods of this class.
   public IntTree(IntTreeNode node){
      overallRoot = node;
   }
   //**************************************************//
   
   //**************************EX01 BEGIN************************//    
   //Chapter 17 - HW08 EX01 - countLeftNodes
     //Write a method called countLeftNodes that returns the number of left children in the tree. 
    //A left child is a node that appears as the root of the left-hand subtree of another node. 
   //For example, reference tree #1 has 3 left children (the nodes storing the values 5, 1, and 4).
   
   //Helper method
   public int countLeftNodes(){
      return countLeftNodes(overallRoot);
   }
   
   private int countLeftNodes(IntTreeNode root){
      //check if both root and root's left child is NOT null
      if(root != null && root.left != null){
          //enters, meaning the root has a left child.
         //returns 1(counter) and recurses rest of tree
         return 1 + countLeftNodes(root.left) + countLeftNodes(root.right);
      }
      
       //root does not have a left child, do not increment counter
      //by returning 0
      return 0;
   }
   //**********************EX01 END****************************//
   
   //************************EX05 BEGIN**************************//    
   //Chapter 17 - HW08 EX05 - printLevel
        // Write a method called printLevel that accepts an integer parameter n and prints the values at level 
       // n from left to right, one per line. We will use the convention that the overall root is at level 1, its 
      // children are at level 2, and so on. If there are no values at the level, your method should produce no output. 
     // Your method should throw an IllegalArgumentException if it is passed a value for a level that is less than 1. 
    // For example, if a variable t refers to reference tree #2, then the call of t.printLevel(3); would produce the 
   // following output:
           // 0
           // 7
           // 6
   
   //helper method
   public void printLevel(int endLevel){
      if(endLevel<1){
         throw new IllegalArgumentException("level cannot be less than 1: " + endLevel);
      }
      //passes a current level and an endLevel 
      printLevel(overallRoot, 1, endLevel);
   }

   //takes an end level and a current level of the node passed to keep track of which level the input node is on
   private void printLevel(IntTreeNode root, int currentLevel, int endLevel){
       //checks if root passed is empty, and that the root is on the level 
      //the client wanted to be printed
      if(root != null && currentLevel == endLevel){
         //if at the desired level, print the roots data
         System.out.println(root.data);
      } else if (root != null && currentLevel < endLevel){
          //else we are not at the desired level, go down right and left paths, traversing left 
         //side of tree first by adding 1 to the currentLevel
         printLevel(root.left, currentLevel + 1, endLevel);
         printLevel(root.right, currentLevel + 1, endLevel);
      }
   }
   //************************EX05 END**************************//
   
   //***********************EX08 BEGIN***************************//
   //Chapter 17 - HW08 EX08 - toString()
       // Write a toString method for a binary tree of integers. The method should return "empty" for an empty tree. 
      // For a leaf node, it should return the data in the node as a string. For a branch node, it should return a 
     // parenthesized String that has three elements separated by commas: the data at the root, a string representation 
    // of the left subtree, and then a string representation of the right subtree. For example, if a variable t refers 
   // to reference tree #2, then the call t.toString() should return the following String (without the surrounding quotes):

   // "(2, (8, 0, empty), (1, (7, 4, empty), (6, empty, 9)))"
   
   //Helper method
   public String toString(){
      return toString(overallRoot);
   }
   
   public String toString(IntTreeNode root){
      //if node is part of branch and is empty, return empty
      if(root == null){
         return "empty";
      //leaf case, returns data in root
      }else if (root.left == null && root.right == null){
         return "" + root.data;
      }else {
      //else, node is part of branch, recurses rest of tree and adds it to overall returned string
         return "(" + root.data + ", " + toString(root.left) + ", " + toString(root.right) + ")" ;
      }
   }
   //***********************EX08 END***************************//
   
   // post: prints the tree contents using a preorder traversal
   public void printPreorder() {
      System.out.print("preorder:");
      printPreorder(overallRoot);
      System.out.println();
   }

   // post: prints the tree contents using a preorder traversal
   // post: prints in preorder the tree with given root
   private void printPreorder(IntTreeNode root) {
      if (root != null) {
         System.out.print(" " + root.data);
         printPreorder(root.left);
         printPreorder(root.right);
      }
   }

   // post: prints the tree contents using a inorder traversal
   public void printInorder() {
      System.out.print("inorder:");
      printInorder(overallRoot);
      System.out.println();
   }

   // post: prints in inorder the tree with given root
   private void printInorder(IntTreeNode root) {
      if (root != null) {
         printInorder(root.left);
         System.out.print(" " + root.data);
         printInorder(root.right);
      }
   }

   // post: prints the tree contents using a postorder traversal
   public void printPostorder() {
      System.out.print("postorder:");
      printPostorder(overallRoot);
      System.out.println();
   }

   // post: prints in postorder the tree with given root
   private void printPostorder(IntTreeNode root) {
      if (root != null) {
         printPostorder(root.left);
         printPostorder(root.right);
         System.out.print(" " + root.data);
      }
   }

   // post: prints the tree contents, one per line, following an
   //       inorder traversal and using indentation to indicate
   //       node depth; prints right to left so that it looks
   //       correct when the output is rotated.
   public void printSideways() {
      printSideways(overallRoot, 0);
   }

   // post: prints in reversed preorder the tree with given
   //       root, indenting each line to the given level
   private void printSideways(IntTreeNode root, int level) {
      if (root != null) {
         printSideways(root.right, level + 1);
         for (int i = 0; i < level; i++) {
            System.out.print("    ");
         }
         System.out.println(root.data);
         printSideways(root.left, level + 1);
      }
   }
}







