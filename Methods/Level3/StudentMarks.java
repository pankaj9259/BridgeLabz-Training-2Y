import java.util.Random;

public class StudentMarks {
    public static int[][] generateScores(int students){
        Random r = new Random();
        int[][] arr = new int[students][3];
        for(int i=0;i<students;i++){
            arr[i][0] = 40 + r.nextInt(61); // 40..100
            arr[i][1] = 40 + r.nextInt(61);
            arr[i][2] = 40 + r.nextInt(61);
        }
        return arr;
    }

    public static double[][] totalsAvgPercent(int[][] scores){
        int n = scores.length;
        double[][] out = new double[n][3];
        for(int i=0;i<n;i++){
            int sum = scores[i][0] + scores[i][1] + scores[i][2];
            double avg = sum / 3.0;
            double percent = (sum / 300.0) * 100.0;
            out[i][0] = sum;
            out[i][1] = Math.round(avg * 100.0) / 100.0;
            out[i][2] = Math.round(percent * 100.0) / 100.0;
        }
        return out;
    }

    public static void main(String[] args){
        int[][] scores = generateScores(5);
        double[][] res = totalsAvgPercent(scores);
        System.out.println("S\tPhy\tChem\tMath\tTotal\tAvg\tPercent");
        for(int i=0;i<scores.length;i++){
            System.out.printf("%d\t%d\t%d\t%d\t%.0f\t%.2f\t%.2f%n", i+1, scores[i][0], scores[i][1], scores[i][2], res[i][0], res[i][1], res[i][2]);
        }
    }
}
