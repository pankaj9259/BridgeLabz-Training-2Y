import java.util.Random;

public class EmployeeBonus {

    // returns array [n][2] where [i][0]=salary, [i][1]=years
    public static double[][] generate(int n){
        Random r = new Random();
        double[][] arr = new double[n][2];
        for(int i=0;i<n;i++){
            arr[i][0] = 10000 + r.nextInt(90000); // ~5-digit-ish
            arr[i][1] = r.nextInt(11); // 0-10 years
        }
        return arr;
    }

    public static double[][] computeNew(double[][] arr){
        double[][] out = new double[arr.length][2]; // [i][0] new salary, [i][1] bonus
        for(int i=0;i<arr.length;i++){
            double salary = arr[i][0];
            double years = arr[i][1];
            double rate = years > 5 ? 0.05 : 0.02;
            double bonus = salary * rate;
            out[i][0] = salary + bonus;
            out[i][1] = bonus;
        }
        return out;
    }

    public static void main(String[] args){
        double[][] emp = generate(10);
        double[][] comp = computeNew(emp);
        double sumOld=0, sumNew=0, sumBonus=0;
        System.out.println("OldSalary\tYears\tNewSalary\tBonus");
        for(int i=0;i<emp.length;i++){
            System.out.printf("%.0f\t\t%.0f\t%.0f\t\t%.0f%n", emp[i][0], emp[i][1], comp[i][0], comp[i][1]);
            sumOld += emp[i][0];
            sumNew += comp[i][0];
            sumBonus += comp[i][1];
        }
        System.out.printf("Sum Old=%.0f, Sum New=%.0f, Total Bonus=%.0f%n", sumOld, sumNew, sumBonus);
    }
}
