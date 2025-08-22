/*Rock-Paper-Scissors is a game played between a minimum of two players. Each player can
choose either rock, paper, or scissors. Here the game is played between a user and a
computer. Based on the rules, either a player or a computer will win. Show the stats of
player and computer win in a tabular format across multiple games. Also, show the winning
percentage between the player and the computer.
Hint =>
a. The rule is: rock-scissors: rock will win (rock crushes scissors); rock-paper: paper wins
(paper covers rock); scissors-paper: scissors win (scissors cuts paper)
b. Create a Method to find the Computer Choice using the Math.random
c. Create a Method to find the winner between the user and the computer
d. Create a Method to find the average and percentage of wins for the user and the
computer and return a String 2D array
e. Create a Method to display the results of every game and also display the average and
percentage wins
f. In the main take user input for the number of games and call methods to display results */

import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {

    // Function to choose on behalf of the computer
    public static String computerChoice() {
        Random random = new Random();
        int c = 1 + random.nextInt(3); // random number (1–3)
        if (c == 1) return "rock";
        else if (c == 2) return "paper";
        else return "scissors";
    }

    // Function to find out the Winner between User and Computer
    public static String winner(String cChoice, String uChoice) {
        if (cChoice.equals(uChoice)) {
            return "Tie";
        }
        if ((cChoice.equals("rock") && uChoice.equals("scissors")) ||
            (cChoice.equals("scissors") && uChoice.equals("paper")) ||
            (cChoice.equals("paper") && uChoice.equals("rock"))) {
            return "Computer";
        } else {
            return "User";
        }
    }

    // Function to calculate average and win percentage
    public static String[][] statistics(int userWins, int compWins, int games) {
        String[][] stats = new String[2][3];

        double userPercent = ((double) userWins / games) * 100;
        double compPercent = ((double) compWins / games) * 100;

        stats[0][0] = "User";
        stats[0][1] = String.valueOf(userWins);
        stats[0][2] = String.format("%.2f", userPercent);

        stats[1][0] = "Computer";
        stats[1][1] = String.valueOf(compWins);
        stats[1][2] = String.format("%.2f", compPercent);

        return stats;
    }

    // Function to display results 
public static void displayResults(String[][] stats) {
    System.out.println("\n----------------- Final Statistics -----------------");
    System.out.println("Player\t\tWins\t\tWin %");

    for (int i = 0; i < stats.length; i++) {
        System.out.println(stats[i][0] + "\t\t" + stats[i][1] + "\t\t" + stats[i][2]);
    }
}


    // Main() Function
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of games to play: ");
        int n = input.nextInt();

        int userWins = 0, compWins = 0, ties = 0;

        for (int i = 1; i <= n; i++) {
            System.out.print("\nGame " + i + " - Enter your choice (rock(0)/paper(1)/scissors(any other number)): ");
            String uChoice = input.next().toLowerCase();
            String cChoice = computerChoice();

            System.out.println("Computer chose: " + cChoice);

            String result = winner(cChoice, uChoice);

            if (result.equals("User")) userWins++;
            else if (result.equals("Computer")) compWins++;
            else ties++;

            System.out.println("Winner: " + result);
        }

        String[][] stats = statistics(userWins, compWins, n);
        displayResults(stats);

        System.out.println("\nTies: " + ties);

        input.close();
    }
}
