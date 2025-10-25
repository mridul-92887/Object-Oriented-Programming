import java.util.Scanner;

class Student {
    int id;
    String name;
    String department;

    // 1️⃣ Default Constructor
    Student() {
        id = 0;
        name = "Unknown";
        department = "Not Assigned";
    }

    // 2️⃣ Parameterized Constructor
    Student(int i, String n, String d) {
        id = i;
        name = n;
        department = d;
    }

    // 3️⃣ Copy Constructor
    Student(Student s) {
        id = s.id;
        name = s.name;
        department = s.department;
    }

    void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Department: " + department);
    }
}

public class lab_16{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 🔹 Using Default Constructor
        System.out.println("=== Default Constructor ===");
        Student s1 = new Student();
        s1.display();

        // 🔹 Using Parameterized Constructor (User Input)
        System.out.println("\n=== Parameterized Constructor ===");
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline
        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        Student s2 = new Student(id, name, dept);
        s2.display();

        // 🔹 Using Copy Constructor
        System.out.println("\n=== Copy Constructor ===");
        Student s3 = new Student(s2);
        s3.display();

        sc.close();
    }
}
