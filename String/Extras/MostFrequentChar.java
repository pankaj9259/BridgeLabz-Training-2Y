import java.util.Scanner;

public class MostFrequentChar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string:");
        String str = sc.nextLine();
        int[] freq = new int[256];

        for (int i = 0; i < str.length(); i++) {
            freq[str.charAt(i)]++;
        }

        int max = 0;
        char mostFreq = ' ';
        for (int i = 0; i < 256; i++) {
            if (freq[i] > max) {
                max = freq[i];
                mostFreq = (char) i;
            }
        }
        System.out.println("Most Frequent Character: '" + mostFreq + "'");
    }
}
