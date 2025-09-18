import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static int generateGuess(int low, int high) {
        Random rand = new Random();
        return rand.nextInt(high - low + 1) + low;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int low = 1, high = 100;
        System.out.println("Think of a number between 1 and 100.");
        String feedback = "";
        int guess;
        while (true) {
            guess = generateGuess(low, high);
            System.out.println("Is your number " + guess + "? (high/low/correct)");
            feedback = sc.next();
            if (feedback.equalsIgnoreCase("correct")) {
                System.out.println("Yay! Computer guessed your number: " + guess);
                break;
            } else if (feedback.equalsIgnoreCase("high")) {
                high = guess - 1;
            } else if (feedback.equalsIgnoreCase("low")) {
                low = guess + 1;
            }
            if (low > high) {
                System.out.println("Invalid feedback. Exiting.");
                break;
            }
        }
        sc.close();
    }
}
