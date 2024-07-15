/* Zohaib Javed
CS211
Friday September 21 2019
Professor James Livingston
HW01 */

public class GroceryBill{

   /*String cashier;*/ //Refer to line 25-28 in test client
    
    //Fields for variable storage, I used a String and two double arrays to store Item names, 
   //Item Prices, and Item Discounts, respectively.
   double total;
   private String[] itemNameList = new String[20];
   private double[] itemPriceList = new double[20];
   private double[] itemDiscountPriceByList = new double[20];
   
   //CONSTRUCTOR
   public GroceryBill(/*Employee empName*/){ //Refer to line 25-28 in test client
      /*cashier = empName.toString();*/      //Refer to line 25-28 in test client    
   }
   
      //Adds Item to bill, takes one of the Item Objects as a parameter (gum, water, or an Item client creates him/her self)
     //Achieves this by going through the Item Name array using a for loop and checks if there is an empty space,when it finds one, it adds 
    //the item name to name array, the price to the price array, and discount to the discount array, at the same indices, so the data for one 
   //item would stay in one row. It gets the values by calling the item's toString, getPrice, and getDiscount methods using the parameter inputted.
   public void add(Item itemToAddToBill){
   
      for(int i = 0; i < 20; i++){
      
         if(itemNameList[i] == null){
            itemNameList[i] = itemToAddToBill.toString();
            itemPriceList[i] = itemToAddToBill.getPrice();
            itemDiscountPriceByList[i] = itemToAddToBill.getDiscount();
            break;
         }
      }
   }
   
     //This GetTotal works by having a for loop go through the itemPrice Array, and checking if 
    //a space in the array is 0, meaning the there is no item. If there isn't a 0, it says go to 
   //the "total" field and add the price of the item at that index i is at to the total.
   public double getTotal(){
      total = 0;
      for(int i = 0; i <20; i++){
         if(itemPriceList[i] != 0){
            total += itemPriceList[i];
         }
      }
      return total;
   }
   
     //Print receipt wokrs also with a for loop, which goes throught the ItemNameListArray,
    //If a space in the array isn't null, it will print the Item name, as well as the price, 
   //by using the same indice in the itemPrice array. Also uses concatenation
   public void printReceipt(){
      System.out.println("Receipt: \n");
      for(int i = 0; i < 20; i++){
         if(itemNameList[i] != null){
            System.out.print(itemNameList[i]);
            System.out.println( " - Price: " + itemPriceList[i] + "$");
         }             
      }
          
      System.out.println();
   }
}