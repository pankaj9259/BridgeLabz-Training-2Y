class Product {
    private static double discount = 5.0; // %
    private final int productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayProductDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        }
    }
}

public class ShoppingCartSystem {
    public static void main(String[] args) {
        Product p1 = new Product(101, "Laptop", 60000, 1);
        p1.displayProductDetails();

        Product.updateDiscount(10.0);
        p1.displayProductDetails();
    }
}