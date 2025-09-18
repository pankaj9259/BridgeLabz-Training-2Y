import java.util.*;

interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        setPrice(price);
        setQuantity(quantity);
    }

    public String getItemName() { return itemName; }
    public double getPrice() { return price; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) { if (price >= 0) this.price = price; else throw new IllegalArgumentException("Price negative"); }
    public void setQuantity(int q) { if (q >= 0) this.quantity = q; else throw new IllegalArgumentException("Quantity negative"); }

    public abstract double calculateTotalPrice();

    public String getItemDetails() {
        return "Item: " + itemName + ", Price: " + price + ", Qty: " + quantity;
    }
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount() {
        // 10% discount
        return calculateTotalPrice() * 0.10;
    }

    @Override
    public String getDiscountDetails() { return "Veg discount 10%"; }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String name, double price, int qty) { super(name, price, qty); }

    @Override
    public double calculateTotalPrice() {
        // extra non-veg charge of 5% on total
        return getPrice() * getQuantity() * 1.05;
    }

    @Override
    public double applyDiscount() {
        // smaller discount 5%
        return calculateTotalPrice() * 0.05;
    }

    @Override
    public String getDiscountDetails() { return "Non-Veg discount 5%"; }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        List<FoodItem> order = Arrays.asList(
            new VegItem("Paneer Butter Masala", 250, 2),
            new NonVegItem("Chicken Biryani", 300, 1)
        );

        double grandTotal = 0;
        System.out.println("---- Order Details ----");
        for (FoodItem f : order) {
            System.out.println(f.getItemDetails());
            double total = f.calculateTotalPrice();
            double discount = (f instanceof Discountable) ? ((Discountable)f).applyDiscount() : 0;
            System.out.println("Total: " + total + ", Discount: " + discount + ", Payable: " + (total - discount));
            grandTotal += (total - discount);
            System.out.println();
        }
        System.out.println("Grand Total Payable: " + grandTotal);
    }
}
