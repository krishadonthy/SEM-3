import java.util.*;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();

    public abstract String getType();
}

class Bike extends Vehicle {

    public Bike(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {
        return hours * 10;
    }

    @Override
    public String getType() {
        return "BIKE";
    }
}

class Car extends Vehicle {

    public Car(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {

        if (hours == 1) {
            return 30;
        }

        return 30 + (hours - 1) * 20;
    }

    @Override
    public String getType() {
        return "CAR";
    }
}

class Truck extends Vehicle {

    public Truck(int hours) {
        super(hours);
    }

    @Override
    public double calculateCharge() {

        double charge = hours * 50;

        if (charge < 100) {
            charge = 100;
        }

        return charge;
    }

    @Override
    public String getType() {
        return "TRUCK";
    }
}

public class CampusParkingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle vehicle;

            switch (type) {

                case "BIKE":
                    vehicle = new Bike(hours);
                    break;

                case "CAR":
                    vehicle = new Car(hours);
                    break;

                default:
                    vehicle = new Truck(hours);
                    break;
            }

            double charge = vehicle.calculateCharge();

            System.out.printf(
                "%s: %.2f%n",
                vehicle.getType(),
                charge
            );

            grandTotal += charge;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}