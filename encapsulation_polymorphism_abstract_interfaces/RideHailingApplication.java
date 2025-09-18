import java.util.*;

interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

abstract class RideVehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation = "Unknown";

    public RideVehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() { return vehicleId; }
    public String getDriverName() { return driverName; }
    public double getRatePerKm() { return ratePerKm; }

    public abstract double calculateFare(double distance);

    public String getVehicleDetails() {
        return "VehicleId: " + vehicleId + ", Driver: " + driverName + ", Rate/km: " + ratePerKm;
    }
}

class CarRide extends RideVehicle implements GPS {
    private String location = "Garage";

    public CarRide(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) { return getRatePerKm() * distance; }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { this.location = newLocation; }
}

class BikeRide extends RideVehicle implements GPS {
    private String location = "Stand";

    public BikeRide(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) { return getRatePerKm() * distance * 0.8; } // cheaper

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { this.location = newLocation; }
}

class AutoRide extends RideVehicle implements GPS {
    private String location = "Auto Hub";

    public AutoRide(String id, String driver, double rate) { super(id, driver, rate); }

    @Override
    public double calculateFare(double distance) { return getRatePerKm() * distance * 0.9; }

    @Override
    public String getCurrentLocation() { return location; }

    @Override
    public void updateLocation(String newLocation) { this.location = newLocation; }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        List<RideVehicle> options = Arrays.asList(
            new CarRide("RV101", "Sahil", 20),
            new BikeRide("RV202", "Maya", 10),
            new AutoRide("RV303", "Rajan", 12)
        );

        double distance = 10; // km
        System.out.println("---- Fare Options for " + distance + " km ----");
        for (RideVehicle rv : options) {
            System.out.println(rv.getVehicleDetails());
            System.out.println("Fare: " + rv.calculateFare(distance));
            if (rv instanceof GPS) {
                GPS gps = (GPS)rv;
                System.out.println("Location: " + gps.getCurrentLocation());
                gps.updateLocation("Downtown");
                System.out.println("Updated Location: " + gps.getCurrentLocation());
            }
            System.out.println();
        }
    }
}
