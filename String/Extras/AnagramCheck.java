import java.util.Arrays;
import java.util.Scanner;

public class AnagramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String s1 = sc.nextLine().replaceAll("\\s","").toLowerCase();
        System.out.println("Enter second string:");
        String s2 = sc.nextLine().replaceAll("\\s","").toLowerCase();

        if (s1.length() != s2.length()) {
            System.out.println("Not anagrams");
            return;
        }

        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        if (Arrays.equals(arr1, arr2)) System.out.println("Anagrams");
        else System.out.println("Not anagrams");
    }
}
