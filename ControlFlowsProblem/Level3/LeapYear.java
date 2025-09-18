import java.util.Scanner;
public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter year (>= 1582): ");
        int year = sc.nextInt();
        if (year < 1582) {
            System.out.println("Year must be >= 1582 (Gregorian calendar).");
            return;
        }
        boolean isLeap = (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
        System.out.println(year + (isLeap ? " is a Leap Year." : " is NOT a Leap Year."));
    }
}