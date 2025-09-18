import java.util.Scanner;
public class SumNaturalNumbersWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n >= 0) {
            int formulaSum = n * (n + 1) / 2;
            int sum = 0, i = 1;
            while (i <= n) {
                sum += i;
                i++;
            }
            System.out.println("Formula sum: " + formulaSum + ", While loop sum: " + sum);
        } else {
            System.out.println("Not a natural number");
        }
    }
}