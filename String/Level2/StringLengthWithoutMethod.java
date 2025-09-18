import java.util.Scanner;

public class StringLengthWithoutMethod {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String input = sc.next();
        System.out.println("Length (user-defined): " + findLength(input));
        System.out.println("Length (built-in): " + input.length());
        sc.close();
    }
}
