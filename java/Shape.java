// Create either a shape, or multiple shapes
import java.util.Random;

public class Shape { // previously class was defined as Shapes
   public static void main(String[] args) {
   
      // Task 1: Draw a regular shape
      Turtle t = new Turtle();
      t.penColor("white");
      t.forward(-100);
      t.left(150);
      
      t.penColor("blue");
      for (int j = 0; j < 5; j++) {
         t.forward(70);
         t.right(72);
      }
      t.up();
      t.hide();

   
      // Task 2: Draw a regular shape many times

      Turtle f = new Turtle();
      f.down();
      f.forward(-80);
      for (int i=1; i< 4; i++) {
         for (int j = 0; j < 5; j++) {
            f.forward(70);
            f.right(72);
         }
         f.up();
         f.forward(60 * i * 2);
         f.down();
      }   



        // Application A:
   //   Turtle t = new Turtle();
         for (int i = 1; i < 100; i++) {  
       t.penColor("blue");
      {

         t.forward(70);
         t.right(72);
         
      } t.forward(i);
         }
      t.up();
      t.hide();
         
 
         // Application B:
      


      Random rand = new Random();
   //   Turtle t = new Turtle();
      t.forward(-100);
      t.right(20);
      
      for (int i=1; i< 10; i++) {
         for (int j = 0; j < 5; j++) {;
           int b=(rand.nextInt(15) * j );
            t.forward(b);
            t.right(72);
         }

      }
      t.up();
     t.hide();


   }
}
      
