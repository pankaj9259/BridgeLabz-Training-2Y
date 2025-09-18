import java.util.Scanner;

public class CalendarDisplay {

    public static String monthName(int m){
        String[] months = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        return months[m-1];
    }

    public static boolean isLeap(int y){
        if(y < 1582) return false;
        return (y%4==0 && y%100 != 0) || (y%400==0);
    }

    public static int daysInMonth(int m, int y){
        int[] d = {31,28,31,30,31,30,31,31,30,31,30,31};
        if(m == 2 && isLeap(y)) return 29;
        return d[m-1];
    }

    // Zeller's congruence -> returns 0=Sunday ... 6=Saturday
    public static int firstDayOfMonth(int month, int year){
        int m = month;
        int Y = year;
        int q = 1;
        if(m < 3){ m += 12; Y -= 1; }
        int K = Y % 100;
        int J = Y / 100;
        int h = (q + (13*(m+1))/5 + K + K/4 + J/4 + 5*J) % 7;
        int d = ((h + 6) % 7); // convert to 0=Sunday
        return d;
    }

    public static void printCalendar(int m, int y){
        System.out.println("     " + monthName(m) + " " + y);
        System.out.println("Su Mo Tu We Th Fr Sa");
        int first = firstDayOfMonth(m,y);
        int days = daysInMonth(m,y);
        for(int i=0;i<first;i++) System.out.print("   ");
        for(int d=1; d<=days; d++){
            System.out.printf("%2d ", d);
            if((first + d) % 7 == 0) System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter month (1-12): ");
        int m = sc.nextInt();
        System.out.print("Enter year: ");
        int y = sc.nextInt();
        printCalendar(m,y);
        sc.close();
    }
}
