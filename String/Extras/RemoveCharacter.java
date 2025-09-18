import java.util.Scanner;

public class RemoveCharacter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        System.out.println("Enter character to remove:");
        char ch = sc.next().charAt(0);

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ch) result += str.charAt(i);
        }
        System.out.println("Modified String: " + result);
    }
}
