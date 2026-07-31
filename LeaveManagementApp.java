import java.util.ArrayList;
import java.util.Scanner;

class LeaveRequest {
    static int idCounter = 5001; // Unique Ticket / Leave ID
    int leaveId;
    String employeeName;
    String leaveType; // e.g., Sick Leave, Casual Leave
    String status;    // Pending, Approved, Rejected

    public LeaveRequest(String employeeName, String leaveType) {
        this.leaveId = idCounter++;
        this.employeeName = employeeName;
        this.leaveType = leaveType;
        this.status = "Pending"; // ServiceNow default state style
    }

    public void approve() {
        this.status = "Approved";
    }

    public void reject() {
        this.status = "Rejected";
    }

    public void display() {
        System.out.println("Leave ID: " + leaveId + " | Name: " + employeeName + " | Type: " + leaveType + " | Status: [" + status + "]");
    }
}

public class LeaveManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<LeaveRequest> leaveList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== LEAVE MANAGEMENT SYSTEM (ServiceNow Style) =====");
            System.out.println("1. Submit Leave Request (Employee)");
            System.out.println("2. View All Leave Requests");
            System.out.println("3. Approve or Reject Leave (Manager)");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Leave Type (e.g., Sick Leave / Casual Leave): ");
                    String type = scanner.nextLine();
                    
                    leaveList.add(new LeaveRequest(name, type));
                    System.out.println("Leave Request Submitted Successfully! Ticket is in 'Pending' state. 🎫");
                    break;

                case 2:
                    System.out.println("\n--- All Leave Requests ---");
                    if (leaveList.isEmpty()) {
                        System.out.println("No leave requests found.");
                    } else {
                        for (LeaveRequest lr : leaveList) {
                            lr.display();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Leave ID to review: ");
                    int targetId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    
                    boolean found = false;
                    for (LeaveRequest lr : leaveList) {
                        if (lr.leaveId == targetId) {
                            found = true;
                            System.out.println("Current Status: " + lr.status);
                            System.out.print("Do you want to (1) Approve or (2) Reject? Enter choice: ");
                            int action = scanner.nextInt();
                            
                            if (action == 1) {
                                lr.approve();
                                systemLog(lr.leaveId, "Approved");
                            } else if (action == 2) {
                                lr.reject();
                                systemLog(lr.leaveId, "Rejected");
                            } else {
                                System.out.println("Invalid action choice!");
                            }
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Leave ID not found. Please verify from the list.");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Leave Management System. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice! Please choose between 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // ServiceNow workflow notification simulation method
    public static void systemLog(int id, String status) {
        System.out.println("Workflow Notification: Leave Request ID " + id + " has been marked as " + status + "! ✅");
    }
}