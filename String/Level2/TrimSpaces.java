import java.util.Scanner;

public class TrimSpaces {
    public static String trimSpaces(String str) {
        int start = 0, end = str.length() - 1;
        while (start <= end && str.charAt(start) == ' ') start++;
        while (end >= start && str.charAt(end) == ' ') end--;
        return str.substring(start, end + 1);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text with spaces: ");
        String input = sc.nextLine();
        String trimmed = trimSpaces(input);
        System.out.println("Custom Trim: '" + trimmed + "'");
        System.out.println("Built-in Trim: '" + input.trim() + "'");
        sc.close();
    }
}
