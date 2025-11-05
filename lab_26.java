class Employee {
    String name;
    int id;

    void displayEmployee() {
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Name: " + name);
    }
}

class Manager extends Employee {
    String department;

    void displayManager() {
        displayEmployee(); 
        System.out.println("Department: " + department);
    }
}

class Developer extends Employee {
    String programmingLanguage;

    void displayDeveloper() {
        displayEmployee();  
        System.out.println("Programming Language: " + programmingLanguage);
    }
}


public class lab_26 {
    public static void main(String[] args) {
        Manager m1 = new Manager();
        m1.id = 101;
        m1.name = "Mridul";
        m1.department = "IT";

        Developer d1 = new Developer();
        d1.id = 102;
        d1.name = "Rafi";
        d1.programmingLanguage = "Java";

        System.out.println("=== Manager ===");
        m1.displayManager();

        System.out.println("\n=== Developer ===");
        d1.displayDeveloper();
    }
}
