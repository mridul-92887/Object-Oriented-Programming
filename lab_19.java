import java.util.Scanner;

class Student {
    private int id;
    public String name;
    public String department;

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

    static Student inputDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Name: ");
        String n = sc.nextLine();
        System.out.print("Enter Department: ");
        String d = sc.nextLine();
        Student s = new Student(n, d);
        System.out.print("Enter ID: ");
        int i = sc.nextInt();
        sc.nextLine();
        s.setId(i);
        return s;
    }
}

public class lab_19 {
    public static void main(String[] args) {
        Student s1 = Student.inputDetails();
        Student s2 = Student.inputDetails();
        Student s3 = Student.inputDetails();

        s1.display();
        s2.display();
        s3.display();
    }
}
