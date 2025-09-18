import java.util.Scanner;
public class SumNaturalRecursive {
    public static int sumRecursive(int n){ if(n<=1) return n; return n + sumRecursive(n-1); }
    public static long sumFormula(int n){ return (long)n*(n+1)/2; }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter n (natural): "); int n=sc.nextInt();
        if(n<1){ System.out.println("Enter natural number >=1"); sc.close(); return; }
        System.out.println("Sum recursive: "+sumRecursive(n));
        System.out.println("Sum formula:   "+sumFormula(n));
        sc.close();
    }
}
