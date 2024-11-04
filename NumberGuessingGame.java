import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Hello Player!");
        System.out.println("Welcome to the Number Guessing Game!");

        int userScore = 0;
        boolean playAgain = true;

        while (playAgain) {
            int targetNumber = random.nextInt(100) + 1;
            int maxAttempts = 3;
            boolean guessedCorrectly = false;

            System.out.println("I have selected a number between 1 and 100. Can you guess it?");
            for (int attempts = 1; attempts <= maxAttempts; attempts++) {
                System.out.print("Enter your guess: ");
                int userGuess = sc.nextInt();
                sc.nextLine();

                if (userGuess == targetNumber) {
                    System.out.println("Congratulations! You guessed the number " + targetNumber + " in " + attempts + " attempts.");
                    userScore++;
                    guessedCorrectly = true;
                    break;
                } else if (userGuess < targetNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've run out of attempts. The correct number was " + targetNumber + ".");
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = sc.nextLine();
            playAgain = playAgainInput.equalsIgnoreCase("yes");
        }

        System.out.println("Game over! Your score: " + userScore);

        sc.close();
    }
}
