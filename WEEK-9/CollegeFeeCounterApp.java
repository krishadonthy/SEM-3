
import java.util.Scanner;

abstract class CollegeStudentBase {
    static final double TRANSPORT_FEE = 12000.0;

    String name;

    CollegeStudentBase(String name) {
        this.name = name;
    }

    abstract double calculateTuition();

    boolean usesBus() {
        return false;
    }

    double calculateTotalFee() {
        double total = calculateTuition();

        if (usesBus()) {
            total += TRANSPORT_FEE;
        }

        return total;
    }
}

class DayScholarStudent extends CollegeStudentBase {
    DayScholarStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0;
    }

    boolean usesBus() {
        return true;
    }
}

class HostellerStudent extends CollegeStudentBase {
    HostellerStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 40000.0 + 60000.0;
    }
}

class ScholarshipStudent extends CollegeStudentBase {
    ScholarshipStudent(String name) {
        super(name);
    }

    double calculateTuition() {
        return 20000.0;
    }

    boolean usesBus() {
        return true;
    }
}

public class CollegeFeeCounterApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double totalCollected = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next().toUpperCase();
            String name = sc.next();

            CollegeStudentBase student;

            switch (type) {
                case "DAY_SCHOLAR":
                    student = new DayScholarStudent(name);
                    break;
                case "HOSTELLER":
                    student = new HostellerStudent(name);
                    break;
                case "SCHOLAR":
                    student = new ScholarshipStudent(name);
                    break;
                default:
                    System.out.println("Invalid student type");
                    continue;
            }

            double fee = student.calculateTotalFee();

            System.out.printf("%s: %.2f%n", name, fee);
            totalCollected += fee;
        }

        System.out.printf(
            "Total Collected: %.2f%n", totalCollected
        );

        sc.close();
    }
}

