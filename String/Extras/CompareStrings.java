import java.util.Scanner;

public class CompareStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first string:");
        String s1 = sc.nextLine();
        System.out.println("Enter second string:");
        String s2 = sc.nextLine();

        int len = Math.min(s1.length(), s2.length());
        for (int i = 0; i < len; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (s1.charAt(i) < s2.charAt(i)) System.out.println(s1 + " comes before " + s2);
                else System.out.println(s2 + " comes before " + s1);
                return;
            }
        }
        if (s1.length() == s2.length()) System.out.println("Strings are equal");
        else if (s1.length() < s2.length()) System.out.println(s1 + " comes before " + s2);
        else System.out.println(s2 + " comes before " + s1);
    }
}
