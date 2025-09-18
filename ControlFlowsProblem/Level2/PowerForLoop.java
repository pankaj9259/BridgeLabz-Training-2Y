import java.util.Scanner;
public class PowerForLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number: ");
        int number = sc.nextInt();
        System.out.print("Enter power: ");
        int power = sc.nextInt();
        long result = 1;
        for (int i = 1; i <= power; i++) {
            result *= number;
        }
        System.out.println(number + "^" + power + " = " + result);
    }
}