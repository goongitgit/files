import java.util.*;

public class DDA {

    public static final String[] ACTIONS = {"⬆️", "➡️", "⬇️", "⬅️", "⏫"};
    public static final String[] RESPONSES = {"UP", "RIGHT", "DOWN", "LEFT", "JUMP"};
    public static final String STAR = "⭐";

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random  r = new Random();

        System.out.println("Welcome to Dance Dance Arrayvolution!\n");
        showActions();
        String[] moves = makeMoves(s,r);
        double score = playGame(s, moves);
        double maxScore = moves.length;
        endScreen(score, maxScore);
    }

    public static void showActions() {
        System.out.println("These are the possible actions and their correct responses:");
        for (int i=0; i<ACTIONS.length; i++) {
           System.out.print(ACTIONS[i] + ": ");
           System.out.println(RESPONSES[i]);
        }
        System.out.println();
    } // ShowActions ends

    public static String[] makeMoves(Scanner s, Random r) {
        System.out.print("How many moves would you like to play? ");
        int numMoves = s.nextInt();
        System.out.println();
        String[] moves = new String[numMoves];
        for (int i=0; i < numMoves; i++) {
            moves[i] = ACTIONS[r.nextInt(ACTIONS.length)];
            // System.out.println("number of moves: " + randomAction);
        }
        // for (int j = 0; j < moves.length; j++) System.out.println(moves[j]);
        return moves;
    }

    public static double playGame(Scanner s, String[] moves) {
        System.out.println("Let's Dance!");
        double score = 0.0;
        for (int i = 0; i < moves.length; i++) {
            System.out.print("(" + (i+1) + ") " + moves[i] + ": ");
            String answer = s.next();

            // get correct response off the move first:
            int responseIndex = 0;
            for (int j = 0; j < ACTIONS.length; j++) {
                // if the current action in the list == the current move we are on, set that as the response index
                if (ACTIONS[j].equals(moves[i])) responseIndex = j;
            }

            boolean fullPoints = false;
            answer = answer.toLowerCase();
            String correctResponse = RESPONSES[responseIndex].toLowerCase();
            if (answer.equals(correctResponse)) {
                score += 1;
                // System.out.println("Added 1");
                fullPoints = true;
            }
            if (answer.length() > correctResponse.length() && !fullPoints) {
                if (answer.contains(correctResponse)) {
                    score += 0.5;
                    // System.out.println("Added 0.5");
                }
            }
        }
        System.out.println();
        return score;
    }

    public static void endScreen(double score, double maxScore) {
        String stars = STAR;
        double increment = maxScore / 5;
        if (score >= 2 * increment) stars += STAR;
        if (score >= 3 * increment) stars += STAR;
        if (score >= 4 * increment) stars += STAR;
        if (score == maxScore) stars += STAR;


        System.out.println("Woah that was groovy!");
        System.out.println("You Scored: " + stars + " (" + score + "/" + maxScore + ")");
        System.out.println("Thanks for playing!");

    }
}






