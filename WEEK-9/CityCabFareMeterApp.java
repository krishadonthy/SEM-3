
import java.util.Scanner;

abstract class MovieTicketBase {
    static final double CONVENIENCE_FEE = 20.0;

    abstract double getTicketPrice();

    double calculateAmount(int count) {
        return (getTicketPrice() + CONVENIENCE_FEE) * count;
    }
}

class RegularMovieTicket extends MovieTicketBase {
    double getTicketPrice() {
        return 150.0;
    }
}

class PremiumMovieTicket extends MovieTicketBase {
    double getTicketPrice() {
        return 250.0;
    }
}

class ReclinerMovieTicket extends MovieTicketBase {
    double getTicketPrice() {
        return 400.0;
    }
}

public class MovieTicketCounterApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next().toUpperCase();
            int count = sc.nextInt();

            MovieTicketBase ticket;

            switch (seat) {
                case "REGULAR":
                    ticket = new RegularMovieTicket();
                    break;
                case "PREMIUM":
                    ticket = new PremiumMovieTicket();
                    break;
                case "RECLINER":
                    ticket = new ReclinerMovieTicket();
                    break;
                default:
                    System.out.println("Invalid seat type");
                    continue;
            }

            double amount = ticket.calculateAmount(count);
            System.out.printf("%s: %.2f%n", seat, amount);
            total += amount;
        }

        System.out.printf("Total: %.2f%n", total);
        sc.close();
    }
}

