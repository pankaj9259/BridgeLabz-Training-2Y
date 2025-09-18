import java.util.Scanner;

public class LargestSecondLargestWithResize {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input number
        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int maxDigit = 10; // initial size
        int[] digits = new int[maxDigit];
        int index = 0;

        // Extract digits and store in array
        while (number != 0) {
            int digit = number % 10;
            number /= 10;

            // if array is full → increase size by +10
            if (index == maxDigit) {
                maxDigit += 10; // increase by 10
                int[] temp = new int[maxDigit];
                for (int i = 0; i < digits.length; i++) {
                    temp[i] = digits[i];
                }
                digits = temp; // reassign
            }

            digits[index] = digit;
            index++;
        }

        // Find largest & second largest
        int largest = -1, secondLargest = -1;
        for (int i = 0; i < index; i++) {
            if (digits[i] > largest) {
                secondLargest = largest;
                largest = digits[i];
            } else if (digits[i] > secondLargest && digits[i] != largest) {
                secondLargest = digits[i];
            }
        }

        // Display results
        System.out.println("Largest digit: " + largest);
        if (secondLargest != -1) {
            System.out.println("Second largest digit: " + secondLargest);
        } else {
            System.out.println("No second largest digit found.");
        }

        sc.close();
    }
}
