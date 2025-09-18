import java.util.Scanner;

public class BonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double[] salary = new double[10];
        int[] years = new int[10];
        double totalBonus = 0, totalOldSalary = 0, totalNewSalary = 0;

        // Input
        for (int i = 0; i < 10; i++) {
            System.out.println("Enter details for Employee " + (i + 1));

            System.out.print("Enter salary: ");
            double s = sc.nextDouble();
            System.out.print("Enter years of service: ");
            int y = sc.nextInt();

            if (s <= 0 || y < 0) {
                System.out.println("Invalid input! Try again.");
                i--; // decrement index
                continue;
            }

            salary[i] = s;
            years[i] = y;
        }

        // Bonus Calculation
        for (int i = 0; i < 10; i++) {
            double bonus = 0;
            if (years[i] > 5) {
                bonus = salary[i] * 0.05;
            }
            totalBonus += bonus;
            totalOldSalary += salary[i];
            totalNewSalary += (salary[i] + bonus);
        }

        System.out.println("\nTotal Old Salary: " + totalOldSalary);
        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total New Salary: " + totalNewSalary);

        sc.close();
    }
}
