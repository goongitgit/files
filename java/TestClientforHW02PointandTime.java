/* Zohaib Javed - HW02
CS 211 Fall 2019
Prof: James Livingston 
9/28/19 */

import java.util.*; 

public class TestClientforHW02PointandTime{

   public static void main(String[] args){
   
      System.out.println("------------------ Testing for TimeSpan compareTo Begin -----------------");
      TimeSpan span1 = new TimeSpan(6, 54); //Create a timespan of 6 hours 54 minutes
      TimeSpan span2 = new TimeSpan(3, 9); //Creates a timespan of 3 hours 9 minutes
      TimeSpan span3 = new TimeSpan(3, 240); //Creates a timespan of 7 hours.
      TimeSpan span4 = new TimeSpan(1, 360); //Creates a timespan of 7 hours.
   
      System.out.println("Comparing span1(6hrs54min) to span2(3hrs9min) \n(If number is positive, span 1 is greater, lower if negative, and equal if 0): ");
      System.out.println(span1.compareTo(span2));
      System.out.println();
      System.out.println("Comparing span1(6hrs54min) to span3(7hrs): ");
      System.out.println(span1.compareTo(span3));
      System.out.println();
      System.out.println("Comparing span3(7hrs) to span1(6hrs54min): ");
      System.out.println(span3.compareTo(span1));
      System.out.println();
      System.out.println("Comparing span3(7hrs) to span4(7hrs): ");
      System.out.println(span3.compareTo(span4));
      System.out.println();
      System.out.println("------------------ Testing for TimeSpan compareTo Complete -----------------");
      
      System.out.println("------------------ Testing for Point compareTo Begin -----------------");
      
      Point p1 = new Point(3, 7);
      Point p2 = new Point(4, 7);
      Point p3 = new Point(10, 5);
      Point p4 = new Point(10, 5);
       
      System.out.println("Comparing p1(3, 7) to p2(4, 7) \n(If number is positive, p1 is greater, lower if negative, and equal if 0): ");
      System.out.println(p1.compareTo(p2));
      System.out.println();
      System.out.println("Comparing p2(4, 7) to p3(10, 5): ");
      System.out.println(p2.compareTo(p3));
      System.out.println();
      System.out.println("Comparing p1(3, 7) to p3(10, 5): ");
      System.out.println(p1.compareTo(p3));
      System.out.println();
      System.out.println("Comparing p3(10, 5) to p4(10, 5): ");
      System.out.println(p3.compareTo(p4));
      System.out.println();
       
          
      System.out.println("------------------ Testing for Point compareTo Complete -----------------");
      
   }

}