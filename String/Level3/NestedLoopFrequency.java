import java.util.Scanner;

public class NestedLoopFrequency {

    public static String[][] charFrequency(String str) {
        char[] chars = str.toCharArray();
        int len = chars.length;
        int[] freq = new int[len];

        for (int i = 0; i < len; i++) {
            freq[i] = 1;
            for (int j = i + 1; j < len; j++) {
                if (chars[i] == chars[j]) {
                    freq[i]++;
                    chars[j] = '0';
                }
            }
        }

        int count = 0;
        for (int i = 0; i < len; i++) if (chars[i] != '0') count++;

        String[][] result = new String[count][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (chars[i] != '0') {
                result[index][0] = Character.toString(chars[i]);
                result[index][1] = Integer.toString(freq[i]);
                index++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String text = sc.nextLine();

        String[][] result = charFrequency(text);
        System.out.println("Character  Frequency");
        for (String[] r : result) {
            System.out.printf("%-10s %s\n", r[0], r[1]);
        }
    }
}