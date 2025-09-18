public class FactorsTasks {

    public static int[] factors(int n){
        int count=0;
        for(int i=1;i<=n;i++) if(n % i == 0) count++;
        int[] arr = new int[count];
        int idx=0;
        for(int i=1;i<=n;i++) if(n % i == 0) arr[idx++] = i;
        return arr;
    }

    public static int greatestFactor(int n, int[] arr){
        // greatest proper factor (< n)
        int g = 1;
        for(int v: arr) if(v > g && v < n) g = v;
        return g;
    }

    public static int sum(int[] arr){ int s=0; for(int v: arr) s+=v; return s; }
    public static long product(int[] arr){ long p=1; for(int v:arr) p*=v; return p; }
    public static long productOfCubes(int[] arr){ long p=1; for(int v:arr) p *= (long)Math.pow(v,3); return p; }

    public static void main(String[] args){
        int n = 28;
        int[] f = factors(n);
        System.out.print("Factors: ");
        for(int v:f) System.out.print(v + " ");
        System.out.println();
        System.out.println("Greatest proper factor: " + greatestFactor(n,f));
        System.out.println("Sum: " + sum(f));
        System.out.println("Product: " + product(f));
        System.out.println("Product of cubes: " + productOfCubes(f));
    }
}
