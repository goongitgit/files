// This program generates an election simulator, and the final results
// of who win or who loose.

import java.util.*;


public class ElectionSimulator {

    public static final String PURPLE = "🟪";
    public static final String YELLOW = "🟡";


    public static final int NUM_DISTS = 10;
    public static final int NUM_SIMS = 5;

    public static final double PURPLE_POLL_AVG = 0.52;
    public static final double YELLOW_POLL_AVG = 1.0 - PURPLE_POLL_AVG;

    public static final double PURPLE_POLL_ERR = 0.05;
    public static final double YELLOW_POLL_ERR = -1.0 * PURPLE_POLL_ERR;

    public static void main(String[] args) {
        Random r = new Random(); //Set random var
        System.out.println("Welcome to the Election Simulator!");
        System.out.println("Running " + NUM_SIMS + " simulations of " + NUM_DISTS + " districts.");
        System.out.println("\nThe Purple Party is polling at " + (PURPLE_POLL_AVG * 100) + "%");
        System.out.println("The Yellow Party is polling at " + (YELLOW_POLL_AVG * 100) + "%\n");


        double totPurplePercentage = 0;
        double totYellowPercentage = 0;
        for (int sim = 1; sim <= NUM_SIMS; sim++) {
            System.out.println("Running Simulation " + sim + ":");
            
            //Save statistical data from each district
            int totalTurnout = 0;
            int purplePartyTotalVotes = 0;
            int yellowPartyTotalVotes = 0;

            //Run through 5 districts:
            for (int i = 1; i <= NUM_DISTS; i++) {
                int DTurnout = r.nextInt(1, 1000+1); //Get rand district 1 turnout
                
                //Calculate vote percentage:
                double districtError = r.nextGaussian() * 0.5; // error for D1
                double percentVotePurple = districtError * PURPLE_POLL_ERR + PURPLE_POLL_AVG; //%vote for purple party
                double percentVoteYellow = districtError * YELLOW_POLL_ERR + YELLOW_POLL_AVG; //%vote for yellow party

                //Calculate # votes
                double votesPurple =  DTurnout * percentVotePurple;
                double votesYellow =  DTurnout * percentVoteYellow;

                //Round results
                int roundedResultPurple = (int)Math.round(votesPurple);
                int roundedResultYellow = (int)Math.round(votesYellow);

                //Print results:
                System.out.println("  District #" + i + " - 🟪 " + (roundedResultPurple) + "  🟡 " + (roundedResultYellow));
                //Add current district turnout
                totalTurnout += DTurnout;
                //Add current respective party votes
                purplePartyTotalVotes += roundedResultPurple;
                yellowPartyTotalVotes += roundedResultYellow;
            }

            //Get each party percent vote
            double purplePartyPercentVotes = 100.0 * purplePartyTotalVotes / totalTurnout;
            double yellowPartyPercentVotes = 100.0 * yellowPartyTotalVotes / totalTurnout;


            System.out.println("\n  Purple Party's votes: " + purplePartyTotalVotes + " (" + ((double) Math.round(purplePartyPercentVotes * 100) / 100) +"%)");
            System.out.println("  Yellow Party's votes: " + yellowPartyTotalVotes + " (" + ((double) Math.round(yellowPartyPercentVotes * 100) / 100) +"%)");

            System.out.print("  Visualization: ");
            for (int squares = 0; squares < (int)(purplePartyTotalVotes / 100); squares++) {
                System.out.print("🟪");
            }
            System.out.print("\n                 ");
            for (int circles = 0; circles < (int)(yellowPartyTotalVotes / 100); circles++) {
                System.out.print("🟡");
            }
            System.out.println("\n\n");
            totPurplePercentage += purplePartyPercentVotes;
            totYellowPercentage += yellowPartyPercentVotes;  
        }
        System.out.println("Election Simulator Results:");
        //Calculate simulations % for each party
        double avgVotePercentagePurple = (totPurplePercentage / NUM_SIMS);
        double avgVotePercentageYellow = (totYellowPercentage / NUM_SIMS);
        boolean purpleWin = false;
        boolean yellowWin = false;

        if (avgVotePercentagePurple >= 50.0) purpleWin = true;
        if (avgVotePercentageYellow >= 50.0) yellowWin = true;

        System.out.println("🟪 Win = " + purpleWin + " (" + ((double) Math.round(avgVotePercentagePurple * 100) / 100) + "%)");
        System.out.println("🟡 Win = " + yellowWin + " (" + ((double) Math.round(avgVotePercentageYellow * 100) / 100) + "%)");

    }
}

