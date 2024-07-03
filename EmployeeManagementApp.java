import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;

    // Constructor
    public Employee(int id, String name, int age, String department) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // toString method for printing employee details
    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Age: " + age + ", Department: " + department;
    }
}

public class EmployeeManagementApp {
    private static List<Employee> employeeList = new ArrayList<>();
    private static int nextId = 1;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nEmployee Management Application");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addEmployee(scanner);
                    break;
                case 2:
                    viewEmployees();
                    break;
                case 3:
                    updateEmployee(scanner);
                    break;
                case 4:
                    deleteEmployee(scanner);
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting Employee Management Application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        }

        scanner.close();
    }

    // Method to add a new employee
    private static void addEmployee(Scanner scanner) {
        System.out.print("Enter employee name: ");
        String name = scanner.nextLine();

        System.out.print("Enter employee age: ");
        int age = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        System.out.print("Enter employee department: ");
        String department = scanner.nextLine();

        Employee employee = new Employee(nextId++, name, age, department);
        employeeList.add(employee);

        System.out.println("Employee added successfully.");
    }

    // Method to view all employees
    private static void viewEmployees() {
        if (employeeList.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("List of Employees:");
            for (Employee emp : employeeList) {
                System.out.println(emp);
            }
        }
    }

    // Method to update an employee's information
    private static void updateEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean found = false;
        for (Employee emp : employeeList) {
            if (emp.getId() == id) {
                System.out.print("Enter new name: ");
                String newName = scanner.nextLine();
                emp.setName(newName);

                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                scanner.nextLine();  // Consume newline
                emp.setAge(newAge);

                System.out.print("Enter new department: ");
                String newDept = scanner.nextLine();
                emp.setDepartment(newDept);

                found = true;
                System.out.println("Employee details updated.");
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found with ID: " + id);
        }
    }

    // Method to delete an employee
    private static void deleteEmployee(Scanner scanner) {
        System.out.print("Enter employee ID to delete: ");
        int id = scanner.nextInt();
        scanner.nextLine();  // Consume newline

        boolean removed = employeeList.removeIf(emp -> emp.getId() == id);

        if (removed) {
            System.out.println("Employee deleted successfully.");
        } else {
            System.out.println("Employee not found with ID: " + id);
        }
    }
}
