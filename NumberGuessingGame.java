import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain;

        do {
            int score = 0; // To track the score based on rounds won
            int maxAttempts = 5; // Maximum number of attempts allowed
            int generatedNumber = random.nextInt(100) + 1; // Generate a number between 1 and 100
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("Welcome to the Number Guessing Game!");
            System.out.println("I have generated a number between 1 and 100. Can you guess it?");

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Enter your guess (attempt " + (attempts + 1) + " of " + maxAttempts + "): ");
                int userGuess = scanner.nextInt();
                attempts++;

                if (userGuess == generatedNumber) {
                    guessedCorrectly = true;
                    score = maxAttempts - attempts + 1; // Score based on remaining attempts
                    System.out.println("Congratulations! You guessed the correct number: " + generatedNumber);
                } else if (userGuess < generatedNumber) {
                    System.out.println("Too low! Try again.");
                } else {
                    System.out.println("Too high! Try again.");
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry! You've used all your attempts. The correct number was: " + generatedNumber);
            }

            System.out.println("Your score for this round: " + score);
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.next();
            playAgain = response.equalsIgnoreCase("yes");

        } while (playAgain);

        System.out.println("Thank you for playing! Goodbye!");
        scanner.close();
    }
}
