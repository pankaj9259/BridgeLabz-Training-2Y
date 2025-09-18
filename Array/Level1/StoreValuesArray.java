import java.util.Scanner;

public class StoreValuesArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] values = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double num = sc.nextDouble();
            if (num <= 0 || index == 10) break;
            values[index++] = num;
        }

        System.out.print("Values entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(values[i] + " ");
            total += values[i];
        }
        System.out.println("\nSum of values: " + total);
        sc.close();
    }
}