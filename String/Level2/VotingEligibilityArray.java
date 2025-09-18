import java.util.Scanner;

public class VotingEligibilityArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Enter age of student " + (i+1) + ": ");
            ages[i] = sc.nextInt();
        }
        System.out.println("Age\tEligibleToVote");
        for (int age : ages) {
            boolean eligible = age >= 18;
            System.out.println(age + "\t" + eligible);
        }
        sc.close();
    }
}
