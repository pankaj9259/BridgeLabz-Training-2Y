import java.util.Scanner;
public class GradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Physics marks: ");
        double phy = sc.nextDouble();
        System.out.print("Chemistry marks: ");
        double chem = sc.nextDouble();
        System.out.print("Maths marks: ");
        double math = sc.nextDouble();
        double avg = (phy + chem + math) / 3.0;
        System.out.printf("Average = %.2f%n", avg);
        char grade;
        if (avg >= 80) grade = 'A';
        else if (avg >= 70) grade = 'B';
        else if (avg >= 60) grade = 'C';
        else if (avg >= 50) grade = 'D';
        else if (avg >= 40) grade = 'E';
        else grade = 'R';
        System.out.println("Grade = " + grade);
    }
}