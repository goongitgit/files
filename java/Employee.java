/* Zohaib Javed
CS211
Friday September 21 2019
Professor James Livingston
HW01 */

//Refer to line 25-28 in test client


public class Employee{
   //Field for name storage of employee
   private String name;
   
   //CONSTRUCTOR
   public Employee(String name){
      this.name = name;
   }
   
   //Allows for Employee item to be printed
   public String toString(){
      return name;
   }
}