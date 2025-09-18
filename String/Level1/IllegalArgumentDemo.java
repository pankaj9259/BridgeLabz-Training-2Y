import java.util.Scanner;

public class IllegalArgumentDemo {
    public static void generateException(String text) {
        System.out.println(text.substring(5, 2)); // invalid
    }

    public static void handleException(String text) {
        try {
            System.out.println(text.substring(5, 2));
        } catch (IllegalArgumentException e) {
            System.out.println("Handled IllegalArgumentException: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter string: ");
        String text = sc.next();

        // generateException(text);
        handleException(text);
    }
}
