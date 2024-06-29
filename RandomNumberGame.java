import java.util.Random;
import java.util.Scanner;

public class RandomNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int minimum = 0;
        int maximum = 100;
        int maxAttempts = 7;
        int rounds = 0;
        int totalScore = 0;

        while (true) {
            int generatedNumber = random.nextInt(maximum - minimum + 1) + minimum;

            System.out.println("A Random number is generated between " + minimum + " and " + maximum + ". Guess the number?");

            int attempts = 0;
            boolean guessedCorrectly = false;

            while (attempts < maxAttempts && !guessedCorrectly) {
                System.out.print("Your guess: ");
                int userGuess = scanner.nextInt();

                if (userGuess == generatedNumber) {
                    System.out.println("You got the correct value, Congratulations!");
                    guessedCorrectly = true;
                    totalScore++;
                } else if (userGuess < generatedNumber) {
                    System.out.println("This guess is too low. Try again.");
                } else {
                    System.out.println("This guess is too high. Try again.");
                }

                attempts++;
            }

            if (!guessedCorrectly) {
                System.out.println("All the attempts are used. The number was " + generatedNumber + ".");
            }

            rounds++;
            System.out.println("Round " + rounds + " completed. Your total score is " + totalScore + ".");
            System.out.print("Do you want to play again? (y/n) ");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                break;
            }
        }

        System.out.println("Your final score is " + totalScore + " out of " + rounds + " rounds.");
    }
}