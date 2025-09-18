import java.util.Scanner;

public class BMI2DArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = sc.nextInt();

        double[][] personData = new double[n][3]; // weight, height, BMI
        String[] weightStatus = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter weight (kg) for person " + (i + 1) + ": ");
            double w = sc.nextDouble();
            System.out.print("Enter height (m) for person " + (i + 1) + ": ");
            double h = sc.nextDouble();

            double bmi = w / (h * h);
            personData[i][0] = w;
            personData[i][1] = h;
            personData[i][2] = bmi;

            if (bmi < 18.5) weightStatus[i] = "Underweight";
            else if (bmi < 25) weightStatus[i] = "Normal";
            else if (bmi < 30) weightStatus[i] = "Overweight";
            else weightStatus[i] = "Obese";
        }

        System.out.println("\nWeight | Height | BMI | Status");
        for (int i = 0; i < n; i++) {
            System.out.println(personData[i][0] + " | " + personData[i][1] + " | " + personData[i][2] + " | " + weightStatus[i]);
        }

        sc.close();
    }
}
