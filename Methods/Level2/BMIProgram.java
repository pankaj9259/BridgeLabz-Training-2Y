import java.util.Scanner;
public class BMIProgram {
    public static double calculateBMI(double weightKg, double heightCm){
        double h = heightCm / 100.0;
        return weightKg / (h*h);
    }
    public static String bmiStatus(double bmi){
        if(bmi < 18.5) return "Underweight";
        if(bmi < 25) return "Normal";
        if(bmi < 30) return "Overweight";
        return "Obese";
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double[][] arr = new double[10][3];
        for(int i=0;i<10;i++){
            System.out.print("Enter weight(kg) for person "+(i+1)+": "); arr[i][0]=sc.nextDouble();
            System.out.print("Enter height(cm) for person "+(i+1)+": "); arr[i][1]=sc.nextDouble();
            arr[i][2] = calculateBMI(arr[i][0], arr[i][1]);
        }
        for(int i=0;i<10;i++){
            System.out.printf("Person %d: weight=%.2fkg height=%.1fcm BMI=%.2f status=%s%n", i+1, arr[i][0], arr[i][1], arr[i][2], bmiStatus(arr[i][2]));
        }
        sc.close();
    }
}
