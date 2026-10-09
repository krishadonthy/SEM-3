import java.util.*;

abstract class EmployeeBonus {
    protected String name;
    protected double monthlySalary;

    public EmployeeBonus(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();

    public String getName() {
        return name;
    }
}

class FullTimeEmployee extends EmployeeBonus {

    public FullTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends EmployeeBonus {

    public PartTimeEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class InternEmployee extends EmployeeBonus {

    public InternEmployee(String name, double monthlySalary) {
        super(name, monthlySalary);
    }

    @Override
    public double calculateBonus() {
        return 2000;
    }
}

public class FestivalBonusApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        double totalBonus = 0;

        for (int i = 0; i < n; i++) {

            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            EmployeeBonus employee;

            switch (type) {

                case "FULLTIME":
                    employee =
                        new FullTimeEmployee(name, salary);
                    break;

                case "PARTTIME":
                    employee =
                        new PartTimeEmployee(name, salary);
                    break;

                default:
                    employee =
                        new InternEmployee(name, salary);
                    break;
            }

            double bonus = employee.calculateBonus();

            System.out.printf(
                "%s: %.2f%n",
                employee.getName(),
                bonus
            );

            totalBonus += bonus;
        }

        System.out.printf(
            "Total Bonus: %.2f%n",
            totalBonus
        );

        sc.close();
    }
}