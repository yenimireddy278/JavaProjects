import java.util.ArrayList;
import java.util.Scanner;

class Ticket {
    static int counter = 1001; // Ticket ID auto-generate avvadaniki
    int ticketId;
    String description;
    String status;

    // Constructor
    public Ticket(String description) {
        this.ticketId = counter++;
        this.description = description;
        this.status = "Open";
    }

    // Ticket ni resolve chese method
    public void resolve() {
        this.status = "Resolved";
    }

    // Ticket details chupinche method
    public void display() {
        System.out.println("Ticket ID: " + ticketId + " | Status: [" + status + "] | Issue: " + description);
    }
}

public class HelpDeskApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== IT HELP DESK SYSTEM =====");
            System.out.println("1. Raise a New Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Resolve a Ticket");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter issue description (e.g., Laptop not starting): ");
                    String desc = scanner.nextLine();
                    tickets.add(new Ticket(desc));
                    System.out.println("Ticket Raised Successfully! 🎉");
                    break;

                case 2:
                    System.out.println("\n--- All Support Tickets ---");
                    if (tickets.isEmpty()) {
                        System.out.println("No tickets found. You're all caught up!");
                    } else {
                        for (Ticket t : tickets) {
                            t.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Ticket ID to resolve: ");
                    int resolveId = scanner.nextInt();
                    boolean found = false;
                    
                    for (Ticket t : tickets) {
                        if (t.ticketId == resolveId) {
                            t.resolve();
                            System.out.println("Ticket ID " + resolveId + " marked as Resolved! ✅");
                            found = true;
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Ticket ID not found. Please check and try again.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Help Desk System. Have a great day!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}