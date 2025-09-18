import java.util.Scanner;
public class DigitCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int temp = Math.abs(n);
        int count = (temp == 0) ? 1 : 0;
        while (temp > 0) {
            count++;
            temp /= 10;
        }
        System.out.println("Number of digits: " + count);
    }
}