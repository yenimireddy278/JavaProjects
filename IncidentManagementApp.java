import java.util.ArrayList;
import java.util.Scanner;

class Incident {
    static int incCounter = 10001; // ServiceNow style INC number prefix generation
    String incidentNumber;
    String shortDescription;
    String priority; // P1 - Critical, P2 - High, P3 - Moderate, P4 - Low
    String state;    // New, In Progress, Resolved, Closed

    public Incident(String shortDescription, String priority) {
        this.incidentNumber = "INC" + incCounter++;
        this.shortDescription = shortDescription;
        this.priority = priority;
        this.state = "New"; // Default ServiceNow incident state
    }

    public void updateState(String newState) {
        this.state = newState;
    }

    public void displayIncident() {
        System.out.println("Incident: " + incidentNumber + " | Priority: " + priority + " | State: [" + state + "] | Desc: " + shortDescription);
    }
}

public class IncidentManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Incident> incidentList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== SERVICENOW INCIDENT MANAGEMENT =====");
            System.out.println("1. Create Incident");
            System.out.println("2. View All Incidents");
            System.out.println("3. Update Incident State (In Progress / Resolved)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Short Description (e.g., VPN connection failure): ");
                    String desc = scanner.nextLine();
                    
                    System.out.print("Enter Priority (P1-Critical, P2-High, P3-Moderate, P4-Low): ");
                    String priority = scanner.nextLine();
                    
                    incidentList.add(new Incident(desc, priority));
                    System.out.println("Incident Created Successfully! Assigned state: New 🚨");
                    break;

                case 2:
                    System.out.println("\n--- Incident Queue ---");
                    if (incidentList.isEmpty()) {
                        System.out.println("No active incidents found in the queue.");
                    } else {
                        for (Incident inc : incidentList) {
                            inc.displayIncident();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Incident Number to update (e.g., INC10001): ");
                    String targetIncNum = scanner.nextLine();
                    
                    boolean found = false;
                    for (Incident inc : incidentList) {
                        if (inc.incidentNumber.equalsIgnoreCase(targetIncNum)) {
                            found = true;
                            System.out.println("Current State: " + inc.state);
                            System.out.print("Select new state to update -> 1. In Progress  2. Resolved: ");
                            int stateChoice = scanner.nextInt();
                            scanner.nextLine(); // Consume newline
                            
                            if (stateChoice == 1) {
                                inc.updateState("In Progress");
                                System.out.println("Incident " + inc.incidentNumber + " state updated to [In Progress] 🔄");
                            } else if (stateChoice == 2) {
                                inc.updateState("Resolved");
                                System.out.println("Incident " + inc.incidentNumber + " state updated to [Resolved] ✅");
                            } else {
                                System.out.println("Invalid state selection!");
                            }
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Incident Number not found in the system!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Incident Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}