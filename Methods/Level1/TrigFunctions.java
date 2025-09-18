import java.util.Scanner;
public class TrigFunctions {
    public static double[] calculateTrigonometricFunctions(double angle) {
        double radians = Math.toRadians(angle);
        return new double[]{Math.sin(radians), Math.cos(radians), Math.tan(radians)};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter angle in degrees: "); double angle=sc.nextDouble();
        double[] res = calculateTrigonometricFunctions(angle);
        System.out.printf("sin: %.4f, cos: %.4f, tan: %.4f%n", res[0], res[1], res[2]);
        sc.close();
    }
}