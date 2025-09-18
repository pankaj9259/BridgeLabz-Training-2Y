import java.util.Scanner;

public class DiscountFeeUserInput {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double fee, discountPercent, discount, finalFee;

        System.out.print("Enter the student fee: ");
        fee = input.nextDouble();

        System.out.print("Enter the discount percentage: ");
        discountPercent = input.nextDouble();

        discount = (discountPercent / 100) * fee;
        finalFee = fee - discount;

        System.out.println("The discount amount is INR " + discount +
                " and final discounted fee is INR " + finalFee);
        input.close();
    }
}