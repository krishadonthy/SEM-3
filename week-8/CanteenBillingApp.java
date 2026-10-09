import java.util.*;

abstract class CustomerBill {
    protected double amount;

    public CustomerBill(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();

    public abstract String getType();
}

class StudentBill extends CustomerBill {

    public StudentBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.90;
    }

    @Override
    public String getType() {
        return "STUDENT";
    }
}

class StaffBill extends CustomerBill {

    public StaffBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount * 0.95;
    }

    @Override
    public String getType() {
        return "STAFF";
    }
}

class GuestBill extends CustomerBill {

    public GuestBill(double amount) {
        super(amount);
    }

    @Override
    public double calculateFinalAmount() {
        return amount + 10;
    }

    @Override
    public String getType() {
        return "GUEST";
    }
}

public class CanteenBillingApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double grandTotal = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            double amount = sc.nextDouble();

            CustomerBill bill;

            switch (type) {
                case "STUDENT":
                    bill = new StudentBill(amount);
                    break;

                case "STAFF":
                    bill = new StaffBill(amount);
                    break;

                default:
                    bill = new GuestBill(amount);
                    break;
            }

            double finalAmount = bill.calculateFinalAmount();

            System.out.printf(
                "%s: %.2f%n",
                bill.getType(),
                finalAmount
            );

            grandTotal += finalAmount;
        }

        System.out.printf("Total: %.2f%n", grandTotal);

        sc.close();
    }
}
