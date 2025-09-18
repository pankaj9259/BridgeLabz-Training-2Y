import java.util.Scanner;
public class LeapYearCheck {
    public static boolean isLeap(int y){
        if(y<1582) return false;
        return (y%4==0 && y%100!=0) || (y%400==0);
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter year: "); int y=sc.nextInt();
        System.out.println(isLeap(y) ? "Leap Year" : "Not a Leap Year");
        sc.close();
    }
}
