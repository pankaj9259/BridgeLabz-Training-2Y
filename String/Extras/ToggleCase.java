import java.util.Scanner;

public class ToggleCase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        String toggled = "";

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) toggled += Character.toLowerCase(ch);
            else if (Character.isLowerCase(ch)) toggled += Character.toUpperCase(ch);
            else toggled += ch;
        }
        System.out.println("Toggled string: " + toggled);
    }
}
