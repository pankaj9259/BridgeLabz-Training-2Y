import java.util.Random;
public class RandomArrayStats {
    public static int[] generate4DigitRandomArray(int size){
        java.util.Random r = new java.util.Random();
        int[] arr = new int[size];
        for(int i=0;i<size;i++) arr[i] = 1000 + r.nextInt(9000);
        return arr;
    }
    public static double[] findAverageMinMax(int[] numbers){
        int min = numbers[0], max = numbers[0];
        double sum = 0;
        for(int v:numbers){ sum+=v; if(v<min) min=v; if(v>max) max=v; }
        return new double[]{ sum / numbers.length, min, max };
    }
    public static void main(String[] args){
        int[] arr = generate4DigitRandomArray(5);
        for(int v:arr) System.out.println(v);
        double[] res = findAverageMinMax(arr);
        System.out.printf("Average=%.2f, Min=%.0f, Max=%.0f%n", res[0], res[1], res[2]);
    }
}
