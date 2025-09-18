import java.util.Scanner;
public class PrimeNumberChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        if (n <= 1) {
            System.out.println(n + " is NOT Prime.");
            return;
        }
        boolean isPrime = true;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        System.out.println(n + (isPrime ? " is Prime." : " is NOT Prime."));
    }
}