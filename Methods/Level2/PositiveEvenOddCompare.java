import java.util.Scanner;
public class PositiveEvenOddCompare {
    public static boolean isPositive(int n) { return n>0; }
    public static boolean isEven(int n) { return n%2==0; }
    public static int compare(int a,int b){ if(a>b) return 1; if(a==b) return 0; return -1; }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr = new int[5];
        for(int i=0;i<5;i++){ System.out.print("Enter number "+(i+1)+": "); arr[i]=sc.nextInt(); }
        for(int v:arr){
            if(v<0) System.out.println(v+" is Negative");
            else {
                System.out.print(v+" is Positive and ");
                System.out.println(isEven(v) ? "Even" : "Odd");
            }
        }
        int cmp = compare(arr[0], arr[4]);
        System.out.println("Compare first and last: " + (cmp==1? "first>last" : (cmp==0? "equal":"first<last")));
        sc.close();
    }
}
