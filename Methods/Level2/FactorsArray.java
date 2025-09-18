import java.util.Scanner;
public class FactorsArray {
    public static int[] factors(int n){
        int count=0;
        for(int i=1;i<=n;i++) if(n%i==0) count++;
        int[] arr=new int[count];
        int idx=0;
        for(int i=1;i<=n;i++) if(n%i==0) arr[idx++]=i;
        return arr;
    }
    public static int sum(int[] arr){ int s=0; for(int v:arr) s+=v; return s; }
    public static long product(int[] arr){ long p=1; for(int v:arr) p*=v; return p; }
    public static long sumOfSquares(int[] arr){ long s=0; for(int v:arr) s+=(long)v*v; return s; }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter number: "); int n=sc.nextInt();
        int[] f = factors(n);
        System.out.print("Factors: ");
        for(int v:f) System.out.print(v+" ");
        System.out.println();
        System.out.println("Sum: "+sum(f));
        System.out.println("Product: "+product(f));
        System.out.println("Sum of squares: "+sumOfSquares(f));
        sc.close();
    }
}
