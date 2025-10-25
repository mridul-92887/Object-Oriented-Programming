import java.util.Scanner;

class Student {
    private int id;
    public String name;
    public String department;

    Student() {
        name = "";
        department = "";
        id = 0;
    }

    Student(String n, String d) {
        name = n;
        department = d;
    }

    void setId(int i) {
        id = i;
    }

    int getId() {
        return id;
    }

    void display() {
        System.out.println("\n=== Student Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
    }

    // Non-static inputDetails method
    void inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Department: ");
        department = sc.nextLine();
        System.out.print("Enter ID: ");
        id = sc.nextInt();
        sc.nextLine(); // clear buffer
    }
}

public class lab_20 {
    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        Student s3 = new Student();

        s1.inputDetails();
        s2.inputDetails();
        s3.inputDetails();

        s1.display();
        s2.display();
        s3.display();
    }
}
