// This program draws 4 different sahpes:
// 1. Task 1 - 2 method calls for task 1: draw hexagon, and drawNgon shapeSize

// 2. Task 2 - Choice A: Option 1 (Random Regular Shapes)
//             Choice B: Option 2 (Random changes)

// 3. Task 3 - 1 method call to draw a rocket picture

import java.util.*;

public class Shapes {
    public static void main(String[] args) {
        Turtle t = new Turtle();

        t.forward(-50);
        drawHexagon(t,60); // calling drawHexagon with two parameters
        t.hide();

        t.forward(-150);
        t.down();

        drawNgon(t,9,40); // calling dawNgon with three parameters
        t.up();
        t.forward(-150);

        t.forward(-150);
        t.down();

        Random rand = new Random();
        randomRegularShapes(t, rand, 10, 200); // calling method with four parameters

        t.up();   
        t.forward(-300);
        t.down();
        int numSides = 6;
        randomChanges(t, rand, numSides, ((360/numSides)/2), (360/numSides), 100); // calling method        
                                                                // with multiple parameters
        
        t.up();
        t.setPosition(-800, 0);
        t.down();
        t.setDirection(0);

        drawRocket(t); // calling method to draw a picture of a rocket

    }

    // TODO: Implement your methods here:

    // Task 1 - drawHexagon method
            public static void drawHexagon(Turtle t, int sideLength) { 
            for (int i = 0; i <= 6 ; i++) {
                t.forward(sideLength);
             //   t.left(72);
                  t.left(360/6);
            }
        t.up();
        }

    // Task 1 - drawNgon method
        public static void drawNgon(Turtle t, int numSides, int sideLength) {
            for (int i = 0; i< numSides; i++) {
                t.forward(sideLength);
                t.left(360/numSides);
            }          
        }   

    // Task 2 - Choice A: Option 1 (Random Regular Shapes)
    public static void randomRegularShapes(Turtle t, Random rand, int numShapes, int maxSize) {
        int numSides = rand.nextInt(3, 10); //random shape from 3 to 6 sides
        for (int i = 0; i < numShapes; i++) { //iterate for each shape
            int edgeSize = rand.nextInt(1, maxSize+1); // random number for length of shape edge (1 to maxSize inclusive)
         //   System.out.println("numSides: " + numSides + "\tedgeSize: " + edgeSize);
            drawNgon(t, numSides, edgeSize); //draw the shape using random parameter values
            
        } 

    }

    // Task 2 - Choice B: Option 2 (Random Changes)
    public static void randomChanges(Turtle t, Random rand, int numEdges, double maxChange, int angle, int sideLength) {
        // System.out.println(maxChange + "\t" + angle);
        for (int i = 0; i< numEdges; i++) { //step through each turn
            double randomChange = maxChange * rand.nextDouble(); // angle change each move
            int addChange = rand.nextInt(0, 1 + 1); //random number from 0 to 1 inclusive

            t.forward(sideLength); //Move the length of the shape side
            if (addChange == 1) { //check for adding the change to the angle
                t.left(angle + randomChange); //add the change to the angle
            }
            else { //subtract the change to the angle
                t.left(angle - randomChange); 
            }
         //   System.out.println("addChange: " + addChange + "\trandomchange: " + randomChange);
        }

    }


    // Task 3 - Method which draws your picture
    // 1 method call to draw your picture for Task 3
    public static void drawRocket(Turtle t) { //draw a rocket using turtle
        drawCone(t); //call function to draw rocket cone
        drawBody(t); //call function to draw rocket body
        drawFins(t); //call function to draw both rocket fins
        drawBooster(t); //call function to draw rocket booster
    }

    public static void drawCone(Turtle t) { //draw cone using Ngon function
        drawNgon(t, 3, 100);
    }

    public static void drawBody(Turtle t) { //draw the rocket body
        t.setDirection(270);
        for (int i = 0; i < 2; i++) { //two iterations of drawing the long side then the short side of a rect
            t.forward(300);
            t.left(90);
            t.forward(100);
            t.left(90);
        }
        t.up();
        t.forward(300);
        t.down();
    }

    public static void drawFins(Turtle t) { //draw both fins
        //fin 1
        t.setDirection(180);
        t.forward(100);
        t.setDirection(45);
        t.forward(100 * Math.sqrt(2));

        //relocate
        t.up();
        t.setDirection(0);
        t.forward(100);
        t.down();

        //fin 2
        t.setDirection(315);
        t.forward(100 * Math.sqrt(2));
        t.setDirection(180);
        t.forward(100);

    }

    public static void drawBooster(Turtle t) { //draw rocket booster
        t.setDirection(250);
        t.forward(50);
        t.setDirection(180);
        t.forward(65);
        t.setDirection(110);
        t.forward(50);

    }
    
} // class
