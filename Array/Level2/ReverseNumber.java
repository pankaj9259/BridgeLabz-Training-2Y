import java.util.Scanner;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        String numStr = String.valueOf(number);
        char[] digits = numStr.toCharArray();

        System.out.print("Reversed Number: ");
        for (int i = digits.length - 1; i >= 0; i--) {
            System.out.print(digits[i]);
        }

        sc.close();
    }
}
