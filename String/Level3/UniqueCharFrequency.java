import java.util.Scanner;

public class UniqueCharFrequency {

    public static char[] uniqueCharacters(String str) {
        char[] unique = new char[str.length()];
        int index = 0;

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (str.charAt(j) == c) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) unique[index++] = c;
        }

        char[] result = new char[index];
        System.arraycopy(unique, 0, result, 0, index);
        return result;
    }

    public static String[][] charFrequency(String str, char[] unique) {
        String[][] result = new String[unique.length][2];
        for(int i = 0; i < unique.length; i++) {
            int count = 0;
            for(int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == unique[i]) count++;
            }
            result[i][0] = Character.toString(unique[i]);
            result[i][1] = Integer.toString(count);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        char[] unique = uniqueCharacters(text);
        String[][] result = charFrequency(text, unique);

        System.out.println("Character  Frequency");
        for(String[] r : result) {
            System.out.printf("%-10s %s\n", r[0], r[1]);
        }
    }
}