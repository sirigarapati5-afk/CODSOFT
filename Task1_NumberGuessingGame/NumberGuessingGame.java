import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in); // Scanner to read user input
        Random rand = new Random(); // Random object to generate numbers

        int score = 0;
        char playAgain;

        do {
            int number = rand.nextInt(100) + 1; // Random number between 1-100
            int guess;
            int attempts = 0; // Number of attempts in this round
            int maxAttempts = 7; // Limit of attempts
            boolean win = false;

            System.out.println("\nNumber Guessing Game");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println("Correct! You guessed in " + attempts + " attempts");

                    score = score + (maxAttempts - attempts + 1);
                    win = true;
                    break;
                }
                else if (guess > number) {
                    System.out.println("Too high!");
                }
                else {
                    System.out.println("Too low!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!win) {
                System.out.println("You lost! The number was: " + number);
            }

            System.out.println("Your current score: " + score);

            System.out.print("Do you want to play again? (y/n): ");  // If you want to play again
            playAgain = sc.next().charAt(0);

        } while (playAgain == 'y' || playAgain == 'Y'); // if yes enter y (or) Y and if no enter n (or) N

        System.out.println("Final Score: " + score);
        System.out.println("Thanks for playing!");

        sc.close();
    }
}
