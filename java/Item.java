/* Zohaib Javed
CS211
Friday September 21 2019
Professor James Livingston
HW01*/

public class Item{
   
   //Fields to Store an individual item's information
   private String itemName;
   private double itemPrice;
   private double discountPriceBy;

   //CONSTRUCTOR
   public Item(String name, double price, double discountedPrice){
      itemName = name;
      itemPrice = price;
      discountPriceBy = discountedPrice;
   }
   
   //Gets price 
   public double getPrice(){
      return itemPrice;
   }
   
   //Gets amount to reduce normal price by (discount)
   public double getDiscount(){
      return discountPriceBy;   
   }
   
   //Allows for Item objects to be printed
   public String toString(){
      return itemName;
   }
   
   
   
}