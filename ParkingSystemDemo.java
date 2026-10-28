import java.util.Scanner;

interface ParkingCharge {
    double calculateCharge();
    void displayParkingDetails();
}

class VehicleParking {
    protected String vehicleNumber;
    protected String vehicleType;
    protected double parkingHours;

    public VehicleParking(String vehicleNumber, String vehicleType, double parkingHours) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.parkingHours = parkingHours;
    }
}

class TwoWheeler extends VehicleParking implements ParkingCharge {
    
    public TwoWheeler(String vehicleNumber, double parkingHours) {
        super(vehicleNumber, "Two-Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        if (parkingHours <= 2) {
            return parkingHours * 20;
        } else {
            return (2 * 20) + ((parkingHours - 2) * 10);
        }
    }

    @Override
    public void displayParkingDetails() {
        System.out.println("\n--- Parking Receipt ---");
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Duration       : " + parkingHours + " hours");
        System.out.println("Total Amount   : Rs. " + calculateCharge());
        System.out.println("-----------------------");
    }
}

class FourWheeler extends VehicleParking implements ParkingCharge {

    public FourWheeler(String vehicleNumber, double parkingHours) {
        super(vehicleNumber, "Four-Wheeler", parkingHours);
    }

    @Override
    public double calculateCharge() {
        if (parkingHours <= 2) {
            return parkingHours * 50;
        } else {
            return (2 * 50) + ((parkingHours - 2) * 30);
        }
    }

    @Override
    public void displayParkingDetails() {
        System.out.println("\n--- Parking Receipt ---");
        System.out.println("Vehicle Type   : " + vehicleType);
        System.out.println("Vehicle Number : " + vehicleNumber);
        System.out.println("Duration       : " + parkingHours + " hours");
        System.out.println("Total Amount   : Rs. " + calculateCharge());
        System.out.println("-----------------------");
    }
}

public class ParkingSystemDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ParkingCharge activeTicket = null;

        System.out.println("=== Parking Management System ===");
        
        System.out.print("Enter Vehicle Number: ");
        String registrationNumber = scanner.nextLine().trim();

        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Two-Wheeler");
        System.out.println("2. Four-Wheeler");
        System.out.print("Enter your choice (1 or 2): ");
        int typeSelection = scanner.nextInt();

        System.out.print("Enter total parking hours: ");
        double duration = scanner.nextDouble();

        if (typeSelection == 1) {
            activeTicket = new TwoWheeler(registrationNumber, duration);
        } else if (typeSelection == 2) {
            activeTicket = new FourWheeler(registrationNumber, duration);
        } else {
            System.out.println("\nError: Invalid vehicle type selected.");
            scanner.close();
            return;
        }

        activeTicket.displayParkingDetails();
        scanner.close();
    }
}
