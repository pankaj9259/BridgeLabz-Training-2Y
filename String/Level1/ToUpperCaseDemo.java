import java.util.Scanner;

public class ToUpperCaseDemo {
    public static String toUpperCaseCustom(String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                result += (char)(ch - 32);
            } else {
                result += ch;
            }
        }
        return result;
    }

    public static boolean compareByCharAt(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = sc.nextLine();

        String customUpper = toUpperCaseCustom(text);
        String builtInUpper = text.toUpperCase();

        System.out.println("Custom Upper: " + customUpper);
        System.out.println("Built-in Upper: " + builtInUpper);
        System.out.println("Same? " + compareByCharAt(customUpper, builtInUpper));
    }
}
