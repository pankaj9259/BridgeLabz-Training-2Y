import java.util.Scanner;

public class ShortestAndLongestWord {
    public static int findLength(String str) {
        int count = 0;
        try {
            while (true) {
                str.charAt(count);
                count++;
            }
        } catch (Exception e) {
            return count;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a sentence: ");
        String input = sc.nextLine();
        String[] words = input.split(" ");

        String shortest = words[0], longest = words[0];
        for (String word : words) {
            if (findLength(word) < findLength(shortest)) shortest = word;
            if (findLength(word) > findLength(longest)) longest = word;
        }
        System.out.println("Shortest: " + shortest);
        System.out.println("Longest: " + longest);
        sc.close();
    }
}

