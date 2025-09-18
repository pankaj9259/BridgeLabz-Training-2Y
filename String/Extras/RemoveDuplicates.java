import java.util.Scanner;

public class RemoveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        String result = "";

        for (int i = 0; i < str.length(); i++) {
            if (!result.contains(str.charAt(i) + "")) {
                result += str.charAt(i);
            }
        }
        System.out.println("String without duplicates: " + result);
    }
}
