import java.util.Scanner;
public class QuotientRemainder {
    public static int[] findRemainderAndQuotient(int number,int divisor){
        int q = number / divisor;
        int r = number % divisor;
        return new int[]{r,q};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: "); int n=sc.nextInt();
        System.out.print("Enter divisor: "); int d=sc.nextInt();
        int[] res=findRemainderAndQuotient(n,d);
        System.out.println("Quotient: "+res[1]+", Remainder: "+res[0]);
        sc.close();
    }
}