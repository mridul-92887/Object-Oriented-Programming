// Parent class
class Employee {
    String name;
    int id;

    void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

// Child class 1 (Single Inheritance)
class Manager extends Employee {
    String department;

    void displayManager() {
        displayEmployee();
        System.out.println("Department: " + department);
    }
}

// Child class 2 (Multilevel Inheritance)
class Director extends Manager {
    int teamSize;

    void displayDirector() {
        displayManager();
        System.out.println("Team Size: " + teamSize);
    }
}

// Child class 3 (Hierarchical Inheritance)
class Developer extends Employee {
    String programmingLanguage;

    void displayDeveloper() {
        displayEmployee();
        System.out.println("Programming Language: " + programmingLanguage);
    }
}


public class lab_27 {
    public static void main(String[] args) {
        // Single Inheritance
        Manager m1 = new Manager();
        m1.id = 101;
        m1.name = "Mridul";
        m1.department = "IT";

        // Multilevel Inheritance
        Director d1 = new Director();
        d1.id = 102;
        d1.name = "Rafi";
        d1.department = "Marketing";
        d1.teamSize = 12;

        // Hierarchical Inheritance
        Developer dev1 = new Developer();
        dev1.id = 103;
        dev1.name = "Sami";
        dev1.programmingLanguage = "Java";

        System.out.println("=== Manager (Single Inheritance) ===");
        m1.displayManager();

        System.out.println("\n=== Director (Multilevel Inheritance) ===");
        d1.displayDirector();

        System.out.println("\n=== Developer (Hierarchical Inheritance) ===");
        dev1.displayDeveloper();
    }
}
