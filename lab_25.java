// Parent class
class Employee {
    String name;
    int id;

    void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// Child class 1
class Manager extends Employee {
    String department;

    void displayManager() {
        displayEmployee();  // call parent method
        System.out.println("Department: " + department);
    }
}

// Child class 2 (inherits Manager)
class Director extends Manager {
    int teamSize;

    void displayDirector() {
        displayManager();   // call Manager method
        System.out.println("Team Size: " + teamSize);
    }
}

public class lab_25{
    public static void main(String[] args) {
        Director d1 = new Director();
        d1.id = 101;
        d1.name = "Mridul";
        d1.department = "IT";
        d1.teamSize = 10;

        d1.displayDirector();
    }
}
