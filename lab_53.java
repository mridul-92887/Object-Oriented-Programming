import java.util.ArrayList;
import java.util.List;

class Employee {
    private int id;
    private String name;
    
    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public void display() {
        System.out.println("Employee ID: " + id + ", Name: " + name);
    }
}

class Department {
    private String name;
    private List<Employee> employees;
    
    public Department(String name) {
        this.name = name;
        this.employees = new ArrayList<>();
    }
    
    public void addEmployee(Employee emp) {
        employees.add(emp);
    }
    
    public void showDepartmentDetails() {
        System.out.println("Department: " + name);
        System.out.println("Employees:");
        for (Employee emp : employees) {
            emp.display();
        }
    }
}

public class lab_53 {
    public static void main(String[] args) {
        Employee emp1 = new Employee(101, "Alice");
        Employee emp2 = new Employee(102, "Bob");
        
        Department dept = new Department("IT");
        
        dept.addEmployee(emp1);
        dept.addEmployee(emp2);
        
        dept.showDepartmentDetails();
    }
}