// Parent class
class Employee {
    String name;
    int id;

    void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// Child class
class Manager extends Employee {
    String department;

    void displayManager() {
        displayEmployee();  // parent method call
        System.out.println("Department: " + department);
    }
}

// Main class
public class single_inheritance {
    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.id = 101;
        m1.name = "Mridul";
        m1.department = "IT";

        Manager m2 = new Manager();
        m2.id = 102;
        m2.name = "Rafi";
        m2.department = "Marketing";

        m1.displayManager();
        m2.displayManager();
    }
}
