/* Zohaib Javed - HW02
CS 211 Fall 2019
Prof: James Livingston 
9/28/19 */  
  
  // A Point object represents a pair of (x, y) coordinates.
  // Fourth version: encapsulated.
 
public class Point implements Comparable<Point>{
   private int x;
   private int y;
 
      // constructs a new point at the origin, (0, 0)
   public Point() {
      this(0, 0); // calls Point(int, int) constructor
   }

     // constructs a new point with the given (x, y) location
   public Point(int x, int y) {
      setLocation(x, y);
   }

     // returns the distance between this Point and (0, 0)
   public double distanceFromOrigin() {
      return Math.sqrt(x * x + y * y);
   }

     // returns the x-coordinate of this point
   public int getX() {
      return x;
   }

     // returns the y-coordinate of this point
   public int getY() {
      return y;
   }

     // sets this point's (x, y) location to the given values
   public void setLocation(int x, int y) {
      this.x = x;
      this.y = y;
   }

     // returns a String representation of this point
   public String toString() {
      return "(" + x + ", " + y + ")";
   }

     // shifts this point's location by the given amount
   public void translate(int dx, int dy) {
      setLocation(x + dx, y + dy);
   }
   
   public int compareTo(Point other){
      if(y != other.y){//checks if y values are not equal, then returns difference betwwn y-values
         return y - other.y;
      } else { //If y values are equal, compares x size by determining difference in x between objects.
         return x - other.x;
      } 
   }
   
}