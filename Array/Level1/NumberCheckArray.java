import java.util.Scanner;

public class NumberCheckArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        for (int number : numbers) {
            if (number > 0) {
                if (number % 2 == 0) {
                    System.out.println(number + " is Positive and Even");
                } else {
                    System.out.println(number + " is Positive and Odd");
                }
            } else if (number < 0) {
                System.out.println(number + " is Negative");
            } else {
                System.out.println(number + " is Zero");
            }
        }

        if (numbers[0] == numbers[numbers.length - 1]) {
            System.out.println("First and last numbers are Equal");
        } else if (numbers[0] > numbers[numbers.length - 1]) {
            System.out.println("First number is Greater than last number");
        } else {
            System.out.println("First number is Less than last number");
        }
        sc.close();
    }
}