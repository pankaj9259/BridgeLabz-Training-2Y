class CartItem {
    String itemName;
    double price;
    int quantity;

    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    void addItem(int qty) {
        quantity += qty;
        System.out.println(qty + " " + itemName + " added to cart.");
    }

    void removeItem(int qty) {
        if (qty <= quantity) {
            quantity -= qty;
            System.out.println(qty + " " + itemName + " removed from cart.");
        } else {
            System.out.println("Not enough items to remove.");
        }
    }

    double getTotalCost() {
        return price * quantity;
    }

    void displayCart() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: " + getTotalCost());
    }

    public static void main(String[] args) {
        CartItem cart = new CartItem("Shoes", 1200, 2);
        cart.displayCart();
        cart.addItem(1);
        cart.removeItem(2);
        cart.displayCart();
    }
}