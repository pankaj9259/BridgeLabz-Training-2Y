import java.util.*;

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate; // per day

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        setRentalRate(rentalRate);
    }

    public String getVehicleNumber() { return vehicleNumber; }
    public String getType() { return type; }
    public double getRentalRate() { return rentalRate; }

    public void setRentalRate(double rentalRate) {
        if (rentalRate >= 0) this.rentalRate = rentalRate;
        else throw new IllegalArgumentException("Rental rate cannot be negative");
    }

    public abstract double calculateRentalCost(int days);

    public String getDetails() {
        return "VehicleNo: " + vehicleNumber + ", Type: " + type + ", Rate/day: " + rentalRate;
    }
}

class Car extends Vehicle implements Insurable {
    public Car(String number, double rate) { super(number, "Car", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        // flat insurance example
        return 500;
    }

    @Override
    public String getInsuranceDetails() { return "Car insurance fixed: 500"; }
}

class Bike extends Vehicle implements Insurable {
    public Bike(String number, double rate) { super(number, "Bike", rate); }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 150;
    }

    @Override
    public String getInsuranceDetails() { return "Bike insurance fixed: 150"; }
}

class Truck extends Vehicle {
    public Truck(String number, double rate) { super(number, "Truck", rate); }

    @Override
    public double calculateRentalCost(int days) {
        // trucks have extra surcharge
        return getRentalRate() * days + 1000;
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> fleet = Arrays.asList(
            new Car("MH12AB1234", 3000),
            new Bike("MH12XY9876", 500),
            new Truck("MH12TR0001", 8000)
        );

        int days = 3;
        System.out.println("---- Rental & Insurance Details for " + days + " days ----");
        for (Vehicle v : fleet) {
            System.out.println(v.getDetails());
            System.out.println("Rental Cost: " + v.calculateRentalCost(days));
            if (v instanceof Insurable) {
                Insurable ins = (Insurable)v;
                System.out.println(ins.getInsuranceDetails() + ", Insurance Cost: " + ins.calculateInsurance());
            } else {
                System.out.println("Not insurable via this interface");
            }
            System.out.println();
        }
    }
}
