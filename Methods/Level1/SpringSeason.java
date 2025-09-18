import java.util.Scanner;
public class SpringSeason {
    public static boolean isSpring(int month, int day) {
        if(month < 3 || month > 6) return false;
        if(month == 3) return day >= 20;
        if(month == 6) return day <= 20;
        return true;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter month (1-12): "); int m=sc.nextInt();
        System.out.print("Enter day: "); int d=sc.nextInt();
        System.out.println(isSpring(m,d) ? "It's a Spring Season" : "Not a Spring Season");
        sc.close();
    }
}