import java.util.Scanner;

public class FirstNonRepeating {

    public static char firstNonRepeatingChar(String str) {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 1) return str.charAt(i);
        }

        return '\0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        char result = firstNonRepeatingChar(text);
        if(result != '\0') System.out.println("First non-repeating character: " + result);
        else System.out.println("No non-repeating character found.");
    }
}