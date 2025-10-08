import java.util.Scanner;

// Base Class
class Person {
    private String name;
    private int age;

    public Person(String n, int a) {
        name = n;
        age = a;
    }

    public void showInfo() { // Polymorphic method
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

    @Override
    public void showInfo() { // Overriding method
        super.showInfo();
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

    @Override
    public void showInfo() { // Overriding method (polymorphism)
        super.showInfo();
        System.out.println("Department: " + department);
    }
}

// Main Class
public class lab_9{
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

        // Polymorphism: Parent reference pointing to child object
        Employee m1 = new Manager(name, age, id, salary, dept);

        // Show Manager info using polymorphism
        System.out.println("\n===== Manager Details =====");
        m1.showInfo(); // Calls Manager's overridden method

        // Give bonus
        System.out.print("\nEnter Bonus Percentage: ");
        double bonus = sc.nextDouble();
        m1.giveBonus(bonus); // Works because method is in Employee

        // Show updated info
        System.out.println("\n===== Updated Manager Details =====");
        m1.showInfo(); // Again calls Manager's overridden method

        sc.close();
    }
}
