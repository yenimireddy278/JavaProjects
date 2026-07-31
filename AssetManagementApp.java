import java.util.ArrayList;
import java.util.Scanner;

class Asset {
    static int tagCounter = 3001; // Asset Tag prefix style
    String assetTag;
    String assetName;
    String assignedTo;
    String status; // In Stock, Assigned, Under Maintenance

    public Asset(String assetName) {
        this.assetTag = "AST" + tagCounter++;
        this.assetName = assetName;
        this.assignedTo = "None";
        this.status = "In Stock";
    }

    public void assignAsset(String employeeName) {
        this.assignedTo = employeeName;
        this.status = "Assigned";
    }

    public void displayAsset() {
        System.out.println("Asset Tag: " + assetTag + " | Name: " + assetName + " | Status: [" + status + "] | Assigned To: " + assignedTo);
    }
}

public class AssetManagementApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Asset> assetList = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== IT ASSET MANAGEMENT (CMDB Style) =====");
            System.out.println("1. Register New Asset (Laptop/Monitor)");
            System.out.println("2. View All Assets Inventory");
            System.out.println("3. Assign Asset to Employee");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Asset Name (e.g., Dell Latitude 5420): ");
                    String name = scanner.nextLine();
                    
                    assetList.add(new Asset(name));
                    System.out.println("Asset Registered Successfully into Inventory! 💻");
                    break;

                case 2:
                    System.out.println("\n--- Asset Inventory List ---");
                    if (assetList.isEmpty()) {
                        System.out.println("No assets registered in the system.");
                    } else {
                        for (Asset a : assetList) {
                            a.displayAsset();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Asset Tag to assign (e.g., AST3001): ");
                    String tag = scanner.nextLine();
                    
                    boolean found = false;
                    for (Asset a : assetList) {
                        if (a.assetTag.equalsIgnoreCase(tag)) {
                            found = true;
                            if (a.status.equals("Assigned")) {
                                System.out.println("Warning: This asset is already assigned to " + a.assignedTo);
                            } else {
                                System.out.print("Enter Employee Name to assign this asset: ");
                                String empName = scanner.nextLine();
                                a.assignAsset(empName);
                                System.out.println("Asset " + a.assetTag + " successfully assigned to " + empName + "! ✅");
                            }
                            break;
                        }
                    }
                    
                    if (!found) {
                        System.out.println("Asset Tag not found in inventory!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Asset Management System. All the best for placements!");
                    break;

                default:
                    System.out.println("Invalid choice! Please select between 1-4.");
            }
        } while (choice != 4);

        scanner.close();
    }
}