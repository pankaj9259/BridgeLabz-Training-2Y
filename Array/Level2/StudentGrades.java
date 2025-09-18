import java.util.Scanner;

public class StudentGrades {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] physics = new int[n];
        int[] chemistry = new int[n];
        int[] maths = new int[n];
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter Physics marks for Student " + (i + 1) + ": ");
            physics[i] = sc.nextInt();
            System.out.print("Enter Chemistry marks for Student " + (i + 1) + ": ");
            chemistry[i] = sc.nextInt();
            System.out.print("Enter Maths marks for Student " + (i + 1) + ": ");
            maths[i] = sc.nextInt();

            int total = physics[i] + chemistry[i] + maths[i];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 80) grade[i] = 'A';
            else if (percentage[i] >= 70) grade[i] = 'B';
            else if (percentage[i] >= 60) grade[i] = 'C';
            else if (percentage[i] >= 50) grade[i] = 'D';
            else if (percentage[i] >= 40) grade[i] = 'E';
            else grade[i] = 'F';
        }

        System.out.println("\nMarks and Grades:");
        for (int i = 0; i < n; i++) {
            System.out.println("Student " + (i + 1) + " -> Physics: " + physics[i] + ", Chemistry: " + chemistry[i] + ", Maths: " + maths[i] + ", %: " + percentage[i] + ", Grade: " + grade[i]);
        }

        sc.close();
    }
}
