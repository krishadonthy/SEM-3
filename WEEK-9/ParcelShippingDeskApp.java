
import java.util.Scanner;

abstract class ParcelShippingBase {
    double weight;
    double declaredValue;

    ParcelShippingBase(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double calculateCharge();

    double calculateInsurance() {
        return 0.0;
    }
}

interface ParcelInsurable {
    double calculateInsurance();
}

class StandardShippingParcel extends ParcelShippingBase {
    StandardShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight;
    }
}

class ExpressShippingParcel extends ParcelShippingBase
        implements ParcelInsurable {

    ExpressShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 80 + 15 * weight;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

class FragileShippingParcel extends ParcelShippingBase
        implements ParcelInsurable {

    FragileShippingParcel(double weight, double value) {
        super(weight, value);
    }

    double calculateCharge() {
        return 40 + 10 * weight + 50;
    }

    public double calculateInsurance() {
        return declaredValue * 0.02;
    }
}

public class ParcelShippingDeskApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double grandTotal = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            ParcelShippingBase parcel;

            switch (type) {
                case "STANDARD":
                    parcel = new StandardShippingParcel(weight, value);
                    break;
                case "EXPRESS":
                    parcel = new ExpressShippingParcel(weight, value);
                    break;
                case "FRAGILE":
                    parcel = new FragileShippingParcel(weight, value);
                    break;
                default:
                    System.out.println("Invalid parcel type");
                    continue;
            }

            double charge = parcel.calculateCharge();
            double insurance = 0.0;

            if (parcel instanceof ParcelInsurable) {
                insurance =
                    ((ParcelInsurable) parcel).calculateInsurance();
            }

            double total = charge + insurance;
            grandTotal += total;

            System.out.printf(
                "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                type, charge, insurance, total
            );
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
        sc.close();
    }
}
