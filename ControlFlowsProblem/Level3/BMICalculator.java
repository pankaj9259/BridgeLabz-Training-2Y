import java.util.Scanner;
public class BMICalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter weight in kg: ");
        double weight = sc.nextDouble();
        System.out.print("Enter height in cm: ");
        double heightCm = sc.nextDouble();
        double heightM = heightCm / 100.0;
        double bmi = weight / (heightM * heightM);
        System.out.printf("BMI = %.2f%n", bmi);
        if (bmi < 18.5) System.out.println("Underweight");
        else if (bmi < 25.0) System.out.println("Normal");
        else if (bmi < 40.0) System.out.println("Overweight");
        else System.out.println("Obese");
    }
}