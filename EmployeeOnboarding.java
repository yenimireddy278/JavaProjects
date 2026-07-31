import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    String id;
    String name;
    String department;
    double salary;

    public Employee(String id, String name, String department, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public void displayEmployee() {
        System.out.println("ID: " + id + " | Name: " + name + " | Dept: " + department + " | Salary: " + salary);
    }
}

public class EmployeeOnboarding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();
        int choice;

        do {
            System.out.println("\n===== EMPLOYEE ONBOARDING SYSTEM =====");
            System.out.println("1. Add New Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Employee ID: ");
                    String id = scanner.nextLine();
                    
                    System.out.print("Enter Employee Name: ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    
                    employees.add(new Employee(id, name, department, salary));
                    System.out.println("Employee Onboarded Successfully! 🎉");
                    break;

                case 2:
                    System.out.println("\n--- Onboarded Employees List ---");
                    if (employees.isEmpty()) {
                        System.out.println("No employees found.");
                    } else {
                        for (Employee emp : employees) {
                            emp.displayEmployee();
                        }
                    }
                    break;

                case 3:
                    System.out.println("Exiting system. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 3);

        scanner.close();
    }
}