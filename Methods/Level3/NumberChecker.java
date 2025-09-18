import java.util.ArrayList;
import java.util.Arrays;

public class NumberChecker {

    public static int countDigits(int n){
        return String.valueOf(Math.abs(n)).length();
    }

    public static int[] digitsArray(int n){
        String s = String.valueOf(Math.abs(n));
        int[] out = new int[s.length()];
        for(int i=0;i<s.length();i++) out[i] = s.charAt(i) - '0';
        return out;
    }

    public static boolean isDuck(int n){
        String s = String.valueOf(n);
        // a duck number has at least one '0' (but usually not starting with 0; input integer won't start with 0)
        return s.contains("0");
    }

    public static boolean isArmstrong(int n){
        int[] d = digitsArray(n);
        int pow = d.length;
        int sum = 0;
        for(int v: d) sum += Math.pow(v, pow);
        return sum == n;
    }

    public static int[] largestTwo(int n){
        int[] d = digitsArray(n);
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        for(int v : d){
            if(v > max1){ max2 = max1; max1 = v; }
            else if(v > max2) max2 = v;
        }
        return new int[]{max1, max2};
    }

    public static int[] smallestTwo(int n){
        int[] d = digitsArray(n);
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for(int v : d){
            if(v < min1){ min2 = min1; min1 = v; }
            else if(v < min2) min2 = v;
        }
        return new int[]{min1, min2};
    }

    public static int sumDigits(int n){
        int s=0; for(int v: digitsArray(n)) s+=v; return s;
    }

    public static int sumSquaresDigits(int n){
        int s=0; for(int v: digitsArray(n)) s += v*v; return s;
    }

    public static boolean isHarshad(int n){
        int sd = sumDigits(n);
        if(sd == 0) return false;
        return n % sd == 0;
    }

    public static int[][] digitFrequency(int n){
        int[] freq = new int[10];
        for(int v: digitsArray(n)) freq[v]++;
        int[][] out = new int[10][2];
        for(int i=0;i<10;i++){ out[i][0] = i; out[i][1] = freq[i]; }
        return out;
    }

    public static int[] reverseDigits(int n){
        int[] d = digitsArray(n); int[] r = new int[d.length];
        for(int i=0;i<d.length;i++) r[i] = d[d.length-1-i];
        return r;
    }

    public static boolean arraysEqual(int[] a,int[] b){
        if(a.length != b.length) return false;
        for(int i=0;i<a.length;i++) if(a[i] != b[i]) return false;
        return true;
    }

    public static boolean isPalindrome(int n){
        return arraysEqual(digitsArray(n), reverseDigits(n));
    }

    public static boolean isPrime(int n){
        if(n <= 1) return false;
        for(int i=2; i <= Math.sqrt(n); i++) if(n % i == 0) return false;
        return true;
    }

    public static boolean isNeon(int n){
        int sq = n*n;
        int sum = 0;
        while(sq > 0){ sum += sq % 10; sq /= 10; }
        return sum == n;
    }

    public static boolean isSpy(int n){
        int sum = 0, prod = 1;
        for(int v: digitsArray(n)){ sum += v; prod *= v; }
        return sum == prod;
    }

    public static boolean isAutomorphic(int n){
        long sq = (long)n * (long)n;
        String s = String.valueOf(n);
        return String.valueOf(sq).endsWith(s);
    }

    public static boolean isBuzz(int n){
        return n % 7 == 0 || String.valueOf(n).endsWith("7");
    }

    public static boolean isPerfect(int n){
        if(n <= 1) return false;
        int sum = 1;
        for(int i=2;i<=n/2;i++) if(n % i == 0) sum += i;
        return sum == n;
    }

    public static String abundantDeficientOrPerfect(int n){
        if(n <= 0) return "N/A";
        int sum = 0;
        for(int i=1;i<=n/2;i++) if(n % i == 0) sum += i;
        if(sum == n) return "Perfect";
        if(sum > n) return "Abundant";
        return "Deficient";
    }

    public static boolean isStrong(int n){
        int s = 0;
        for(int v: digitsArray(n)) s += factorial(v);
        return s == n;
    }

    private static int factorial(int x){
        int f=1; for(int i=2;i<=x;i++) f *= i; return f;
    }

    // quick demo main
    public static void main(String[] args){
        int n = 153;
        System.out.println("Digits of " + n + " => " + Arrays.toString(digitsArray(n)));
        System.out.println("Is Armstrong? " + isArmstrong(n));
        System.out.println("Is Duck? " + isDuck(n));
        System.out.println("Sum digits: " + sumDigits(n) + ", sumSquares: " + sumSquaresDigits(n));
        System.out.println("Largest two digits: " + Arrays.toString(largestTwo(n)));
        System.out.println("Smallest two digits: " + Arrays.toString(smallestTwo(n)));
        System.out.println("Is Harshad? " + isHarshad(n));
        System.out.println("Is Palindrome? " + isPalindrome(n));
        System.out.println("Is Prime? " + isPrime(n));
        System.out.println("Is Perfect/Abundant/Deficient? " + abundantDeficientOrPerfect(n));
        System.out.println("Is Strong? " + isStrong(n));
    }
}
