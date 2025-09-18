import java.util.Scanner;
public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter an integer: ");
        int n = sc.nextInt();
        int temp = Math.abs(n);
        int sum = 0;
        while (temp > 0) {
            int d = temp % 10;
            sum += d * d * d; // sum of cubes (per problem statement)
            temp /= 10;
        }
        if (sum == Math.abs(n)) {
            System.out.println(n + " is an Armstrong Number.");
        } else {
            System.out.println(n + " is NOT an Armstrong Number.");
        }
    }
}