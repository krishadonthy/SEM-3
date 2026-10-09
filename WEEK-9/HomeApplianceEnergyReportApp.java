```java
import java.util.Scanner;

abstract class HomeApplianceBase {
    abstract double getPowerRating();

    double calculateUnits(double hours) {
        return getPowerRating() * hours / 1000.0;
    }

    double calculateCost(double units) {
        return units * 8.0;
    }
}

interface ApplianceSaverMode {
    double applySaverMode(double units);
}

class FridgeEnergyAppliance extends HomeApplianceBase {
    double getPowerRating() {
        return 150.0;
    }
}

class ACEnergyAppliance extends HomeApplianceBase
        implements ApplianceSaverMode {

    double getPowerRating() {
        return 1500.0;
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

class TVEnergyAppliance extends HomeApplianceBase {
    double getPowerRating() {
        return 100.0;
    }
}

class WasherEnergyAppliance extends HomeApplianceBase
        implements ApplianceSaverMode {

    double getPowerRating() {
        return 500.0;
    }

    public double applySaverMode(double units) {
        return units * 0.75;
    }
}

public class HomeApplianceEnergyReportApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                sc.skip("\\s*");
                String next = sc.hasNext()
                        ? sc.nextLine().trim()
                        : "";

                saver = next.equalsIgnoreCase("SAVER");
            }

            HomeApplianceBase appliance;

            switch (type) {
                case "FRIDGE":
                    appliance = new FridgeEnergyAppliance();
                    break;
                case "AC":
                    appliance = new ACEnergyAppliance();
                    break;
                case "TV":
                    appliance = new TVEnergyAppliance();
                    break;
                case "WASHER":
                    appliance = new WasherEnergyAppliance();
                    break;
                default:
                    System.out.println("Invalid appliance type");
                    continue;
            }

            if (saver && !(appliance instanceof ApplianceSaverMode)) {
                System.out.println(
                    type + ": saver mode not supported"
                );
                continue;
            }

            double units = appliance.calculateUnits(hours);

            if (saver) {
                units = ((ApplianceSaverMode) appliance)
                        .applySaverMode(units);
            }

            double cost = appliance.calculateCost(units);
            totalCost += cost;

            System.out.printf(
                "%s: Units=%.2f Cost=%.2f%n",
                type, units, cost
            );
        }

        System.out.printf("Total Cost: %.2f%n", totalCost);
        sc.close();
    }
}
```
