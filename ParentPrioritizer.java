// This class is a budgeter. It takes in monthly or daily expenses and income. It then draws
// conclusions about your spending habits.

import java.util.*;

public class PatientPrioritizer {

    public static int baseScore = 100;
    public static String patientName;
    public static final int HOSPITAL_ZIP = 12345;

    public static void main(String[] args) {
         Scanner s = new Scanner(System.in);
         int maxScore = 0;
         int numPatients = 0;

        displayIntro();
        while (true) {
            System.out.println("Please enter the next patient's name or \"quit\" to end the program.");
            patientName = getPatientName(s); // call to get the name
            if (patientName.equals("quit")) break;
            int currScore = getPatientInfo(s);
            if (currScore > maxScore) maxScore = currScore;
            displayInfo();
            numPatients++;
            baseScore = 100;
        } //end of for loop
        printOverallStats(numPatients, maxScore);
    }
    // Behavior: 
    //   - This method calculates net profit or loss based on monthly income and daily spending.
    // Parameters:
    //   - income: the user’s income this month
    //   - spending: the amount the user spent each day this month
    // Returns:
    //   - int: the net profit or loss. Positive if profit, negative if loss.
    // method to print the program's introduction message
    public static void displayIntro() {
        System.out.println("Hello! We value you and your time, so we will help\nyou prioritize which patients to see next!");
        System.out.println("Please answer the following questions about the next patient so\nwe can help you do your best work :)");
        System.out.println("");

    }
        // method to print the program's introduction message
        public static void displayInfo() {
            System.out.println("We have found patient " + patientName + " to have a priority score of: " + baseScore);
            printPatientPriority(patientName, baseScore);
            System.out.println("");
            System.out.println("Thank you for using our system!");
            System.out.println("We hope we have helped you do your best!");
            System.out.println("");
        }

    // method to get name through users
    public static String getPatientName(Scanner s) {
        System.out.print("Patient\'s name: ");
        String name = s.next();
        return name;
    }

    // method to get name through users
    public static int getPatientInfo(Scanner s) {
        System.out.print("Patient age: ");
        int age = s.nextInt();

        System.out.print("Patient zip code: ");
        int zipCode = s.nextInt();
        while (!fiveDigits(zipCode))  {
            System.out.print("Invalid zip code, enter valid zip code: ");
            zipCode = s.nextInt();
        }

        System.out.print("Is our hospital \"in network\" for the patient\'s insurance? ");
        String hospitalNetwork = s.next();
        System.out.print("Patient pain level (1-10): ");
        int painLevel = s.nextInt();
        while (painLevel < 1 || painLevel > 10) {
            System.out.print("Invalid pain level, enter valid pain level (1-10): ");
            painLevel = s.nextInt();
        }
        System.out.print("Patient temperature (in degrees Fahrenheit): ");
        Double temp = s.nextDouble();
        System.out.println();

        baseScore = calculatePriorityScore(age, zipCode, hospitalNetwork, painLevel, temp);
        return baseScore;
    }

    // method
    public static int calculatePriorityScore(int age, int zipCode, String hospitalNetwork, int painLevel, double temp) {


        if ((age < 12) || (age >= 75))
            baseScore += 50;

        // System.out.println(zipCode/10000);
        if ((zipCode/10000) == (HOSPITAL_ZIP /10000)) {
            baseScore += 25;
            if ((zipCode/1000) % 10 == (HOSPITAL_ZIP /1000) % 10)
                baseScore += 15;
        }
        // System.out.println(hospitalNetwork);
        if (hospitalNetwork.equals("yes") || hospitalNetwork.equals("y")) {
            baseScore += 50;
        }

        if (painLevel < 7)
        baseScore += painLevel + 10;
        else
        baseScore += painLevel + 70;

        if (temp > 99.5)  baseScore += 8;
        return baseScore;
    }


    // method to get name through users
    public static void printPatientPriority(String name, int score) {
        if (score >= 277) {
            System.out.println("We have determined this patient is high priority,\nand it is advised to call an appropriate medical provider ASAP.");
        }
        if (score >= 162 && score < 277) {
            System.out.println("We have determined this patient is medium priority.\nPlease assign an appropriate medical provider to their case\nand check back in with the patient's condition in a little while.");
        }
        if (score < 162) {
            System.out.println("We have determined this patient is low priority.\nPlease put them on the waitlist for when a medical provider becomes available.");
        }
    }

    // method
    public static void printOverallStats(int numPatients, int maxScore) {
        System.out.println("Statistics for the day:");
        System.out.println("..." + numPatients + " patients were helped");
        System.out.println("...the highest priority patient we saw had a score of " + maxScore);
        System.out.println("Good job today!");

    }

    // Determines if the given integer has five digits.
    // Parameters:
    //   - val: the integer whose digits will be counted
    // Returns:
    //   - boolean: true if the given integer has 5 digits, and false otherwise.
    public static boolean fiveDigits(int val) {

        val = val / 10000; // get first digit

        if (val == 0) { // has less than 5 digits
            // System.out.println(val);
            return false;
        } else if (val / 10 == 0) { // has 5 digits
            return true;
        } else { // has more than 5 digits
            return false;
        }
        // NOTE: the above can be written with improved "boolean zen" as follows:
        // return val != 0 && val / 10 == 0;
    }

}



