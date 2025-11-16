import java.util.Scanner;

// Parent Class for Vehicles
class Vehicle {
    protected String type;
    protected boolean isRunning;
    protected int speed;

    Vehicle(String type) {
        this.type = type;
    }

    public boolean isEmergency() {
        return false;  // Default: normal vehicle
    }
}

// Child class for Emergency Vehicles
class EmergencyVehicle extends Vehicle {
    EmergencyVehicle(String type) {
        super(type);
    }

    @Override
    public boolean isEmergency() {
        return true;
    }
}

// Traffic Signal Class
class TrafficSignal {
    private String color;

    TrafficSignal(String color) {
        this.color = color.toLowerCase();
    }

    public String getColor() {
        return color;
    }

    public void showMessage() {
        switch (color) {
            case "red":
                System.out.println("Signal: RED → Stop immediately!");
                break;
            case "yellow":
                System.out.println("Signal: YELLOW → Be ready to stop or move soon.");
                break;
            case "green":
                System.out.println("Signal: GREEN → You can go.");
                break;
            default:
                System.out.println("Invalid Signal Color!");
        }
    }
}

public class TrafficSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Take traffic signal input
        System.out.print("Enter Traffic Light (Red/Yellow/Green): ");
        String color = sc.nextLine();
        TrafficSignal signal = new TrafficSignal(color);
        signal.showMessage();

        // Vehicle selection
        System.out.println("\nSelect Vehicle Type:");
        System.out.println("1. Car");
        System.out.println("2. Bike");
        System.out.println("3. Truck");
        System.out.println("4. Ambulance (Emergency Vehicle)");
        int choice = sc.nextInt();

        Vehicle v;
        switch (choice) {
            case 4:
                v = new EmergencyVehicle("Ambulance");
                break;
            case 1:
                v = new Vehicle("Car");
                break;
            case 2:
                v = new Vehicle("Bike");
                break;
            case 3:
                v = new Vehicle("Truck");
                break;
            default:
                System.out.println("Invalid Choice! Default Vehicle Set = Car");
                v = new Vehicle("Car");
        }

        // Running status
        System.out.print("Is vehicle running? (yes/no): ");
        sc.nextLine(); 
        String run = sc.nextLine();
        v.isRunning = run.equalsIgnoreCase("yes");

        // Speed input if vehicle is moving
        int speedLimit = 40;
        if (v.isRunning) {
            System.out.print("Enter speed limit: ");
            speedLimit = sc.nextInt();

            System.out.print("Enter vehicle speed: ");
            v.speed = sc.nextInt();
        }

        System.out.println("\n===== RESULT =====");

        // Emergency vehicle logic
        if (v.isEmergency()) {
            System.out.println("Vehicle: " + v.type + " (Emergency)");
            System.out.println("No fine applicable for emergency vehicles.");
            return;
        }

        // Normal vehicle rules
        int fine = 0;

        if (signal.getColor().equals("red") && v.isRunning) {
            fine += 50;
            System.out.println("Fine: Running on RED -> Rs 50");
        }

        if (signal.getColor().equals("yellow") && v.isRunning) {
            fine += 50;
            System.out.println("Fine: Running on YELLOW -> Rs 50");
        }

        if (signal.getColor().equals("green") && !v.isRunning) {
            System.out.println("Signal is GREEN -> You can move now.");
        }

        if (v.isRunning && v.speed > speedLimit) {
            int over = v.speed - speedLimit;
            fine += over;
            System.out.println("Speed Limit Exceeded by " + over + " km/h -> Fine Rs " + over);
        }

        if (fine == 0) {
            System.out.println("No Fine. You are following all rules!");
            if(signal.getColor().equals("yellow")){
                System.out.println("Signal: YELLOW -> Be ready to stop or move soon.");
            }
        } else {
            System.out.println("Total Fine: Rs " + fine);
        }

        System.out.println("===================");
    }
}
