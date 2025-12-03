import java.util.ArrayList;
import java.util.List;

// Employee class
class Employee {
    private int id;
    private String name;

    // Constructor
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Display employee info
    public void display() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }
}

// Department class (One Department has many Employees)
class Department {
    private String name;
    private List<Employee> employees;

    // Constructor
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }

    // Add an employee
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    // Display department info
    public void showDepartmentDetails() {
        System.out.println("Department: " + name);
        System.out.println("Employees:");
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

// Main class
public class lab_37 {
    public static void main(String[] args) {

        // Create Employees
        Employee emp1 = new Employee(101, "Alice");
        Employee emp2 = new Employee(102, "Bob");

        // Create Department
        Department dept = new Department("IT");

        // Associate employees to the department
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);

        // Display details
        dept.showDepartmentDetails();
    }
}
