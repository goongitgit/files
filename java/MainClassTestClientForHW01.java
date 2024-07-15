/* Zohaib Javed
CS211
Friday September 21 2019
Professor James Livingston
HW01 */

public class MainClassTestClientForHW01{
   public static void main(String[] args){
      
      //-------------TEST CLIENT--------------
      
      System.out.println("---------------------TESTING OF FEATURES FOR ITEM CLASS START---------------------\n");
        //Creation of Item instances from Item class to be used by GroceryBill and DiscountBill classes
       //The parameters passed are the name, Price, and the price to reduce it by if a customer is preferred
      //Usage of Add method for grocery bill
      //After every item created, its name, price, and discountprice are outputted.
      Item redApple = new Item("Red Apple", 1.0, 0.75); 
      System.out.println("Item name: " + redApple + "\t Item Price: " + redApple.getPrice() + "$" + "\t Discount Price By: " + redApple.getDiscount() + "$");
      Item greenApple = new Item("Green Apple", 1.50, 0);
      System.out.println("Item name: " + greenApple + "\t Item Price: " + greenApple.getPrice() + "$" + "\t Discount Price By: " + greenApple.getDiscount() + "$");
      Item yellowApple = new Item("Yellow Apple", 3.0, 1.50);
      System.out.println("Item name: " + yellowApple + "\t Item Price: " + yellowApple.getPrice() + "$" + "\t Discount Price By: " + yellowApple.getDiscount() + "$");
      Item gum = new Item("Chewing Gum", 0.75, 0.25);
      System.out.println("Item name: " + gum + "\t Item Price: " + gum.getPrice() + "$" + "\t Discount Price By: " + gum.getDiscount() + "$");
      Item water = new Item("Bottled Water", 2.75, 1.15);
      System.out.println("Item name: " +  water + "\t Item Price: " + water.getPrice() + "$" + "\t Discount Price By: " + water.getDiscount() + "$");
      Item soda = new Item("Soda Can", 0.50, 0);
      System.out.println("Item name: " +  soda + "\t Item Price: " + soda.getPrice() + "$" + "\t Discount Price By: " + soda.getDiscount() + "$");
      Item chocCake = new Item("Chocolate Cake", 10.0, 2.0);
      System.out.println("Item name: " + chocCake + "\t Item Price: " + chocCake.getPrice() + "$" + "\t Discount Price By: " + chocCake.getDiscount() + "$");
      Item saladCeasar = new Item("Ceasar Salad", 3.0, 0.95);  
      System.out.println("Item name: " + saladCeasar + "\t Item Price: " + saladCeasar.getPrice() + "$" + "\t Discount Price By: " + saladCeasar.getDiscount() + "$");   
      System.out.println();
      
         //I tried to create an employee class and tried to create instances and passs them to GroceryBill and DiscountBill
        //but was met with "could not find symbol errors", and I wasn't sure why, because I created the Employee objects 
       //like I did the GroceryBill, as you can see.I commented out the Employee parameters on the other classes, if you 
      //just remove those comments and try to compile from the test client, the errors will be more clear.
      
      //Employee rachel = new Employee(RachelW);
      System.out.println("---------------------TESTING OF FEATURES FOR ITEM CLASS DONE---------------------\n");
      
      System.out.println("---------------------TESTING OF FEATURES FOR GROCERYBILL CLASS START---------------------");
      
      //Creates a Grocery Bill object so I can start adding items to the bill.
      GroceryBill bill1 = new GroceryBill(/*rachel*/);
      
      //Adding of items to "bill1"
      bill1.add(redApple); 
      bill1.add(greenApple);
      bill1.add(gum);
      bill1.add(saladCeasar);
      bill1.add(chocCake);
   
      //Usage of getTotalMethod for a grocery bill object, output is 16.25$
      bill1.getTotal();
      
      //Usage of Print Receipt method
      bill1.printReceipt();
      System.out.println("Total is: " + bill1.getTotal() + "$");
      
      //Indicates Testing for Grocery Class has completed
      System.out.println("---------------------TESTING OF FEATURES FOR GROCERYBILL CLASS DONE---------------------\n");
      System.out.println("---------------------TESTING OF FEATURES FOR DISCOUNTBILL CLASS START---------------------\n");
      
      //Refer to lines 25-28
      //Employee dave = new Employee(DaveI);
      
      //Creates DiscountBill Object named discountB1 for testing
      
      DiscountBill discountB1 = new DiscountBill(/*dave,*/ true);
      
       //Adding of items to discount bill "discountB1" (8 items total, 6 get discounts) 
      //Usage of Add() method for Discount bill
      discountB1.add(redApple);
      discountB1.add(greenApple);
      discountB1.add(gum);
      discountB1.add(saladCeasar);
      discountB1.add(chocCake);
      discountB1.add(water);
      discountB1.add(soda);
      discountB1.add(saladCeasar);
   
      //Usage and output of GetTotal(), GetDiscountAmount(), getDiscountCount(), getDiscountPercent(), and printReceipt() methods.
      System.out.println("Total without Discount: " + discountB1.getTotal() + "$");
      System.out.println("Amount of Items Discounted: " + discountB1.getDiscountCount());
      System.out.println("Amount of total discounts on Items: " + discountB1.getDiscountAmount() + "$");     
      System.out.printf("Discount percent of what total would have been: %.2f%%\n\n", discountB1.getDiscountPercent());  
      
      
      
      System.out.println("\n-----------BEGIN RECEIPT FOR DISCOUNT BILL-----------");
      discountB1.printReceipt();
      System.out.println("-----------END RECEIPT FOR DISCOUNT BILL-----------\n");
      System.out.println("---------------------TESTING OF FEATURES FOR DISCOUNTBILL CLASS DONE---------------------");
      
   }
}