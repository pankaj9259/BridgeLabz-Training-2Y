import java.util.Scanner;
public class ChocolateDivision {
    public static int[] findRemainderAndQuotient(int number,int divisor){
        int q = number / divisor;
        int r = number % divisor;
        return new int[]{r,q};
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Number of chocolates: "); int n=sc.nextInt();
        System.out.print("Number of children: "); int m=sc.nextInt();
        int[] res = findRemainderAndQuotient(n,m);
        System.out.println("Each child gets: "+res[1]+" chocolates, Remaining: "+res[0]);
        sc.close();
    }
}