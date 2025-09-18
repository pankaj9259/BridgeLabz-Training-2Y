import java.util.HashSet;
import java.util.Random;

public class GenerateOTP {
    public static int generate6DigitOTP(Random r){
        return 100000 + r.nextInt(900000);
    }

    public static boolean uniqueOTPs(int[] arr){
        HashSet<Integer> s = new HashSet<>();
        for(int v: arr) s.add(v);
        return s.size() == arr.length;
    }

    public static void main(String[] args){
        Random r = new Random();
        int[] otps = new int[10];
        for(int i=0;i<10;i++){
            otps[i] = generate6DigitOTP(r);
            System.out.println("OTP[" + i + "] = " + otps[i]);
        }
        System.out.println("All unique? " + uniqueOTPs(otps));
    }
}
