class Vehicle {
    private static double registrationFee = 1500;
    private final String registrationNumber;
    private String ownerName, vehicleType;

    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayVehicleDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Registration No: " + registrationNumber);
            System.out.println("Owner: " + ownerName);
            System.out.println("Type: " + vehicleType);
            System.out.println("Registration Fee: " + registrationFee);
        }
    }
}

public class VehicleSystem {
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("DL01AB1234", "Ravi", "Car");
        v1.displayVehicleDetails();

        Vehicle.updateRegistrationFee(2000);
        v1.displayVehicleDetails();
    }
}