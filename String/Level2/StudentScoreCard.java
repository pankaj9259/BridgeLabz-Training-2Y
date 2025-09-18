import java.util.Scanner;

public class StudentScoreCard {

    // a. Generate random 2-digit scores (10 to 99) for PCM
    public static int[][] generateScores(int numStudents) {
        int[][] scores = new int[numStudents][3];
        for (int i = 0; i < numStudents; i++) {
            for (int j = 0; j < 3; j++) {
                scores[i][j] = (int) (Math.random() * 90 + 10); // 10 to 99
            }
        }
        return scores;
    }

    // b. Calculate total, average, percentage
    public static double[][] calculateStats(int[][] scores) {
        int numStudents = scores.length;
        double[][] stats = new double[numStudents][3]; // [total, average, percentage]

        for (int i = 0; i < numStudents; i++) {
            int total = scores[i][0] + scores[i][1] + scores[i][2];
            double average = total / 3.0;
            double percentage = (total / 300.0) * 100;

            stats[i][0] = total;
            stats[i][1] = Math.round(average * 100.0) / 100.0;
            stats[i][2] = Math.round(percentage * 100.0) / 100.0;
        }
        return stats;
    }

    // c. Calculate grade
    public static char[] calculateGrades(double[][] stats) {
        char[] grades = new char[stats.length];
        for (int i = 0; i < stats.length; i++) {
            double percent = stats[i][2];
            if (percent >= 80) grades[i] = 'A';
            else if (percent >= 70) grades[i] = 'B';
            else if (percent >= 60) grades[i] = 'C';
            else if (percent >= 50) grades[i] = 'D';
            else if (percent >= 40) grades[i] = 'E';
            else grades[i] = 'R'; // Remedial
        }
        return grades;
    }

    // d. Display scorecard
    public static void displayScoreCard(int[][] scores, double[][] stats, char[] grades) {
        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s %-15s %-10s\n", 
                          "Student", "Physics", "Chemistry", "Maths", "Total", "Average", "Percentage", "Grade");
        System.out.println("------------------------------------------------------------------------------------------------");

        for (int i = 0; i < scores.length; i++) {
            System.out.printf("%-10s %-10d %-10d %-10d %-10.0f %-10.2f %-15.2f %-10c\n", 
                              "S" + (i + 1),
                              scores[i][0], scores[i][1], scores[i][2],
                              stats[i][0], stats[i][1], stats[i][2],
                              grades[i]);
        }
    }

    // Main Method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();

        int[][] scores = generateScores(numStudents);
        double[][] stats = calculateStats(scores);
        char[] grades = calculateGrades(stats);

        displayScoreCard(scores, stats, grades);

        sc.close();
    }
}
