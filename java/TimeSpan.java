 /* Zohaib Javed - HW02
CS 211 Fall 2019
Prof: James Livingston 
9/28/19 */
 
 
 // Represents a time span of hours and minutes elapsed.
  // Class invariant: hours >= 0 && minutes >= 0 && minutes < 60
 
public class TimeSpan implements Comparable<TimeSpan> {
   private int hours;
   private int minutes;

    // Constructs a time span with the given interval.
    // pre: hours >= 0 && minutes >= 0
   public TimeSpan(int hours, int minutes) {
      this.hours = 0;
      this.minutes = 0;
      add(hours, minutes);
   }

   // Adds the given interval to this time span.
   // pre: hours >= 0 && minutes >= 0
   public void add(int hours, int minutes) {
      if (hours < 0 || minutes < 0) {
         throw new IllegalArgumentException();
      }
   
      this.hours += hours;
      this.minutes += minutes;
   
      // converts each 60 minutes into one hour
      this.hours += this.minutes / 60;
      this.minutes = this.minutes % 60;
   }

   // returns a String for this time span, such as "6h 15m"
   public String toString() {
      return hours + "h " + minutes + "m";
   }
   
   public int compareTo(TimeSpan ts){
   
   //Check if hours are not equal, then returns difference of hours between objects.
      if(hours != ts.hours){
         return hours - ts.hours;
      } else { // If hours are equal, returns difference of minutes between objects. 
              //If minutes difference is zero, both TimeSpans are equal
         return minutes - ts.minutes;
      }
   }
}


