import java.util.Random;
import java.util.Scanner;

public class SimpleLudo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int player1Pos = 0;
        int player2Pos = 0;
        boolean player1Started = false;
        boolean player2Started = false;

        System.out.println("🎲 Welcome to Simple Ludo (2 Players)!");
        System.out.println("First to reach 50 wins!\n");

        while (true) {
            // Player 1 Turn
            System.out.println("Player 1, press Enter to roll the dice...");
            scanner.nextLine();
            int roll1 = random.nextInt(6) + 1;
            System.out.println("Player 1 rolled: " + roll1);

            if (!player1Started) {
                if (roll1 == 6) {
                    player1Started = true;
                    System.out.println("Player 1 starts!");
                } else {
                    System.out.println("Need a 6 to start.");
                }
            } else {
                player1Pos += roll1;
                System.out.println("Player 1 moved to position " + player1Pos);
            }

            if (player1Pos >= 50) {
                System.out.println("\n🎉 Player 1 wins the game!");
                break;
            }

            // Player 2 Turn
            System.out.println("\nPlayer 2, press Enter to roll the dice...");
            scanner.nextLine();
            int roll2 = random.nextInt(6) + 1;
            System.out.println("Player 2 rolled: " + roll2);

            if (!player2Started) {
                if (roll2 == 6) {
                    player2Started = true;
                    System.out.println("Player 2 starts!");
                } else {
                    System.out.println("Need a 6 to start.");
                }
            } else {
                player2Pos += roll2;
                System.out.println("Player 2 moved to position " + player2Pos);
            }

            if (player2Pos >= 50) {
                System.out.println("\n🎉 Player 2 wins the game!");
                break;
            }

            System.out.println("\n----------------------------\n");
        }

        scanner.close();
    }
}
