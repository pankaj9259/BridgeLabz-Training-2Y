import java.util.Scanner;
public class NumberSignCheck {
    public static int sign(int n) {
        if (n>0) return 1;
        if (n<0) return -1;
        return 0;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter integer: "); int n=sc.nextInt();
        int res=sign(n);
        if(res>0) System.out.println("Positive");
        else if(res<0) System.out.println("Negative");
        else System.out.println("Zero");
        sc.close();
    }
}