import java.util.Scanner;

public class VowelConsonantType {
    public static String charType(char c) {
        if (!Character.isLetter(c)) return "Not a Letter";
        c = Character.toLowerCase(c);
        return "aeiou".indexOf(c) != -1 ? "Vowel" : "Consonant";
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text: ");
        String input = sc.nextLine();
        System.out.println("Char\tType");
        for (int i = 0; i < input.length(); i++) {
            System.out.println(input.charAt(i) + "\t" + charType(input.charAt(i)));
        }
        sc.close();
    }
}
