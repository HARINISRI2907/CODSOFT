import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 5;
        int score = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("I'm thinking of a number between " + MIN + " and " + MAX + ".");
            System.out.println("You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attempts < MAX_ATTEMPTS) {
                System.out.print("Enter your guess: ");

                if (!scanner.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    scanner.next(); // skip invalid input
                    continue;
                }

                int guess = scanner.nextInt();
                attempts++;

                if (guess == numberToGuess) {
                    System.out.println("That's correct! You guessed the number in " + attempts + " attempt(s).");
                    score++;
                    guessedCorrectly = true;
                    break;
                } else if (guess < numberToGuess) {
                    System.out.println("Too low....");
                } else {
                    System.out.println("Too high....");
                }

                System.out.println("Attempts left: " + (MAX_ATTEMPTS - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println("You ran out of attempts. The number was: " + numberToGuess);
            }

            scanner.nextLine(); // consume leftover newline
            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes");

        } while (playAgain);

        System.out.println("Game over. Your total score: " + score);
        System.out.println("Thank you for playing!!!!");
        scanner.close();
    }
}
