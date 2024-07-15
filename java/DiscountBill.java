/* Zohaib Javed
CS211
Friday September 21 2019
Professor James Livingston
HW01 */

public class DiscountBill extends GroceryBill{

   //Another set of array fields for DiscountClass, just like the GroceryBill class. 
   private String[] itemNameListD = new String[20];
   private double[] itemPriceListD = new double[20];
   private double[] itemDiscountPriceByListD = new double[20];
   
    //Boolean so client can tell program if a customer will get discounts. 
   //If true, customer will get it, if false, they won't get discounts.
   private boolean isPreferredCustomer;
   
   double total; //total amount with no discounts applied
   double discountedAmount; //total dollar price discounts add up to
   int discountedCount; //keeps track of how many items were discounted
   double discountPercent; // stores discount percentage of what total would have been

   public DiscountBill(/*Employee dave,*/ boolean isPreferredCustomer){ //Refer to line 25-28 in test client
      /*super(dave);*/                                                 //Refer to line 25-28 in test client
      this.isPreferredCustomer = isPreferredCustomer;
   }
      
    //Works same as GroceryBill Class Method, with the exception that 
   //this method uses DicountBill's arrays for item info storage.  
   public void add(Item itemToAddToBill){
   
      for(int i = 0; i < 20; i++){
      
         if(itemNameListD[i] == null){
            itemNameListD[i] = itemToAddToBill.toString();
            itemPriceListD[i] = itemToAddToBill.getPrice();
            itemDiscountPriceByListD[i] = itemToAddToBill.getDiscount();
            break;
         }
      }
   }

    //Again, same as GroceryBill, with exception of this using DiscountBill's field arrays.
   //total is set to zero first, so if there are multiple calls, this guarantees the customer does not get billed twice.
   public double getTotal(){
      total = 0;
         
      for(int i = 0; i <20; i++){
         total += itemPriceListD[i];
      }
      return total;
   }

      //Uses for loop to go through itemName list and ItemDiscountList, by checking if a space in the name array 
     //is filled i.e. there is an object,and if the discount price of that object does not equal 0, meaning it has a discount. 
    //If an item has a discount, the field discountCount is updated by an increment of 1.
   //discountedCount is set to zero to guarantee there is no miscount.
   public int getDiscountCount(){
         
         discountedCount = 0;
   
      if(isPreferredCustomer = false){ 
         return 0;
      } else {
         for(int i = 0; i < 20; i++){
            if(itemNameListD[i] != null && itemDiscountPriceByListD[i] != 0){
               discountedCount += 1;
            }
         }
         
         return discountedCount;
         
      }
   }
   
    //This method works by doing the same check as the getDiscountCount in the for loop, except this method just takes the discount price 
   //from the array list for that information and adds it to the field discountedAmount.
   public double getDiscountAmount(){
      discountedAmount = 0;
      
      if(isPreferredCustomer = false){ 
         return 0.0;
      } else {
         for(int i = 0; i < 20; i++){
         
            if(itemNameListD[i] != null && itemDiscountPriceByListD[i] != 0){
               discountedAmount = itemDiscountPriceByListD[i] + discountedAmount;
            
            }
         }
         
         return discountedAmount;
         
      }
   }
   
    //getDiscountPercent works by making a variable called discountDifference, which is equal to the calculation "total" - "discountedAmount".
   //Then that is divided by the total and set to the discountPercent field. It is then multiplied by 100 before being returned.
   public double getDiscountPercent(){
      if(isPreferredCustomer = false){ 
         return 0.0;
      } else {
         double discountDifference = total - discountedAmount;
         discountPercent = discountDifference/total;
          
         return 100 - (discountPercent*100);
      }
   }
   
    //Works basically the same as GroceryBill's printReceipt, except with extra information that 
   //comes from the above features (methods) for the DiscountBillClass.
   public void printReceipt(){
   
      System.out.println("\nReceipt of Items: \n ------------------------------");
      
      for(int i = 0; i < 20; i++){
         if(itemNameListD[i] != null){
            System.out.print(itemNameListD[i]);
            System.out.println( " - Price: " + itemPriceListD[i] + "$");
         }             
      }
      System.out.println("\n------------------------------");
      
      System.out.println("Total before discount: " + getTotal() + "$");
      System.out.println("Total discount: " + getDiscountAmount() + "$");
      System.out.println("Total after discount: " + (getTotal() - getDiscountAmount()) + "$");
      System.out.println("Amount of items discounted: " +  getDiscountCount());
      System.out.printf("Percent discount of total: %.2f%%\n", getDiscountPercent());
      
      System.out.println("------------------------------ \n");
          
   }


}