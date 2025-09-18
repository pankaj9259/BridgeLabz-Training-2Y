import java.util.Scanner;

public class MaximumOfThree {
    public static int findMax(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter three numbers: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int max = findMax(a, b, c);
        System.out.println("Maximum is: " + max);
        sc.close();
    }
}
