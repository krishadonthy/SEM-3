import java.util.*;
import java.time.LocalDate;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(
        String name,
        LocalDate startDate
    ) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract LocalDate getRenewalDate();

    public String getName() {
        return name;
    }
}

class BasicPlan extends SubscriptionPlan {

    public BasicPlan(
        String name,
        LocalDate startDate
    ) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(30);
    }
}

class StandardPlan extends SubscriptionPlan {

    public StandardPlan(
        String name,
        LocalDate startDate
    ) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(90);
    }
}

class PremiumPlan extends SubscriptionPlan {

    public PremiumPlan(
        String name,
        LocalDate startDate
    ) {
        super(name, startDate);
    }

    @Override
    public LocalDate getRenewalDate() {
        return startDate.plusDays(365);
    }
}

public class StreamingRenewalApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            String date = sc.next();

            LocalDate startDate =
                LocalDate.parse(date);

            SubscriptionPlan plan;

            switch (type) {

                case "BASIC":
                    plan =
                        new BasicPlan(name, startDate);
                    break;

                case "STANDARD":
                    plan =
                        new StandardPlan(name, startDate);
                    break;

                default:
                    plan =
                        new PremiumPlan(name, startDate);
                    break;
            }

            LocalDate renewalDate =
                plan.getRenewalDate();

            System.out.println(
                plan.getName() + ": " + renewalDate
            );
        }

        sc.close();
    }
}