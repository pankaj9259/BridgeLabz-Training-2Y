import java.util.Scanner;

public class KmToMilesUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double km, miles;

        System.out.print("Enter distance in km: ");
        km = input.nextDouble();
        miles = km / 1.6;

        System.out.println("The total miles is " + miles + " mile for the given " + km + " km");
        input.close();
    }
}