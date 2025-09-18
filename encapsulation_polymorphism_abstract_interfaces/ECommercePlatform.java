import java.util.*;

interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

abstract class Product {
    private String productId;
    private String name;
    private double price; // base price

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        setPrice(price);
    }

    public String getProductId() { return productId; }
    public String getName() { return name; }
    public double getPrice() { return price; }

    public void setPrice(double price) {
        if (price >= 0) this.price = price;
        else throw new IllegalArgumentException("Price cannot be negative");
    }

    public abstract double calculateDiscount(); // returns discount amount

    public String getDetails() {
        return "ProductId: " + productId + ", Name: " + name + ", Price: " + price;
    }
}

class Electronics extends Product implements Taxable {
    public Electronics(String id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() {
        // flat 10% discount
        return getPrice() * 0.10;
    }

    @Override
    public double calculateTax() {
        // electronics tax 18%
        return getPrice() * 0.18;
    }

    @Override
    public String getTaxDetails() { return "Electronics tax @18%"; }
}

class Clothing extends Product implements Taxable {
    public Clothing(String id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() {
        // seasonal 15% discount
        return getPrice() * 0.15;
    }

    @Override
    public double calculateTax() {
        // clothing tax 12%
        return getPrice() * 0.12;
    }

    @Override
    public String getTaxDetails() { return "Clothing tax @12%"; }
}

class Groceries extends Product {
    public Groceries(String id, String name, double price) { super(id, name, price); }

    @Override
    public double calculateDiscount() {
        // minimal discount for groceries
        return getPrice() * 0.05;
    }
}

public class ECommercePlatform {
    public static void printFinalPrice(Product p) {
        double price = p.getPrice();
        double tax = (p instanceof Taxable) ? ((Taxable)p).calculateTax() : 0;
        double discount = p.calculateDiscount();
        double finalPrice = price + tax - discount;
        System.out.println(p.getDetails());
        if (p instanceof Taxable) System.out.println(((Taxable)p).getTaxDetails());
        System.out.println("Tax: " + tax + ", Discount: " + discount + ", Final Price: " + finalPrice);
        System.out.println();
    }

    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Electronics("E100", "Smartphone", 20000),
            new Clothing("C200", "Jeans", 2000),
            new Groceries("G300", "Rice 5kg", 500)
        );

        System.out.println("---- Product Final Prices ----");
        for (Product p : products) {
            printFinalPrice(p);
        }
    }
}
