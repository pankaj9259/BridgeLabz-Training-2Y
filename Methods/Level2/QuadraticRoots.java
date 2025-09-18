import java.util.Scanner;
public class QuadraticRoots {
    public static double[] findRoots(double a,double b,double c){
        double delta = b*b - 4*a*c;
        if(delta < 0) return new double[]{};
        if(delta == 0) return new double[]{ -b/(2*a) };
        double sqrt = Math.sqrt(delta);
        return new double[]{ (-b+sqrt)/(2*a), (-b - sqrt)/(2*a) };
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter a b c: ");
        double a=sc.nextDouble(), b=sc.nextDouble(), c=sc.nextDouble();
        double[] r = findRoots(a,b,c);
        if(r.length==0) System.out.println("No real roots");
        else if(r.length==1) System.out.println("One root: "+r[0]);
        else System.out.println("Roots: "+r[0]+" , "+r[1]);
        sc.close();
    }
}
