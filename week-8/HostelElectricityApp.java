import java.util.*;

abstract class HostelRoom {
    protected int units;

    public HostelRoom(int units) {
        this.units = units;
    }

    public abstract double calculateBill();

    public abstract String getType();
}

class SingleRoom extends HostelRoom {

    public SingleRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return units * 8;
    }

    @Override
    public String getType() {
        return "SINGLE";
    }
}

class SharedRoom extends HostelRoom {

    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (units * 6) / occupants;
    }

    @Override
    public String getType() {
        return "SHARED";
    }
}

class AcRoom extends HostelRoom {

    public AcRoom(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 10) + 200;
    }

    @Override
    public String getType() {
        return "AC";
    }
}

public class HostelElectricityApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();

            HostelRoom room;

            switch (type) {

                case "SINGLE":
                    int singleUnits = sc.nextInt();
                    room = new SingleRoom(singleUnits);
                    break;

                case "SHARED":
                    int sharedUnits = sc.nextInt();
                    int occupants = sc.nextInt();
                    room = new SharedRoom(sharedUnits, occupants);
                    break;

                default:
                    int acUnits = sc.nextInt();
                    room = new AcRoom(acUnits);
                    break;
            }

            double bill = room.calculateBill();

            System.out.printf(
                "%s: %.2f%n",
                room.getType(),
                bill
            );

            grandTotal += bill;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}