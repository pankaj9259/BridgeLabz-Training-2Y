import java.util.Scanner;

public class CharFrequency {

    public static String[][] charFrequency(String str) {
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int count = 0;
        for(int f : freq) if(f > 0) count++;

        String[][] result = new String[count][2];
        int index = 0;
        for(int i = 0; i < 256; i++) {
            if(freq[i] > 0) {
                result[index][0] = Character.toString((char)i);
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
        for(String[] r : result) {
            System.out.printf("%-10s %s\n", r[0], r[1]);
        }
    }
}