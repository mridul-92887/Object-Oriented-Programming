import java.util.Scanner;

// Base Class
class Person {
    private String name;
    private int age;

    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public void showPerson() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}

// Employee Class
class Employee extends Person {
    private int empId;
    private double salary;

    public Employee(String n, int a, int id, double s) {
        super(n, a);
        empId = id;
        salary = s;
    }

    public void giveBonus(double percent) {
        salary += (salary * percent) / 100;
        System.out.println("Bonus of " + percent + "% applied!");
    }

    public void showEmployee() {
        showPerson();
        System.out.println("Employee ID: " + empId + ", Salary: " + salary);
    }
}

// Manager Class
class Manager extends Employee {
    private String department;

    public Manager(String n, int a, int id, double s, String dept) {
        super(n, a, id, s);
        department = dept;
    }

    public void showManager() {
        showEmployee();
        System.out.println("Department: " + department);
    }
}

// Main Class
public class lab_6{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input Manager Info
        System.out.print("Enter Manager Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();

        System.out.print("Enter Employee ID: ");
        int id = sc.nextInt();

        System.out.print("Enter Salary: ");
        double salary = sc.nextDouble();
        sc.nextLine(); // consume newline

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        // Create Manager object
        Manager m1 = new Manager(name, age, id, salary, dept);

        // Show Manager info
        System.out.println("\n===== Manager Details =====");
        m1.showManager();

        // Give bonus
        System.out.print("\nEnter Bonus Percentage: ");
        double bonus = sc.nextDouble();
        m1.giveBonus(bonus);

        // Show updated info
        System.out.println("\n===== Updated Manager Details =====");
        m1.showManager();

        sc.close();
    }
}
