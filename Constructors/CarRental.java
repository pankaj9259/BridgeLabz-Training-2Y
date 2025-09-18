class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate = 1000.0;

    CarRental(String customerName, String carModel, int rentalDays) {
        this.customerName = customerName;
        this.carModel = carModel;
        this.rentalDays = rentalDays;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void display() {
        System.out.println("Customer: " + customerName + ", Car: " + carModel +
                           ", Days: " + rentalDays + ", Total Cost: " + calculateTotalCost());
    }

    public static void main(String[] args) {
        CarRental cr = new CarRental("Amit", "Swift", 5);
        cr.display();
    }
}