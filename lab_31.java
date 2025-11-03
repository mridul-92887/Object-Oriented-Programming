import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String department;

    void setId(int i) {
        id = i;
    }

    void setName(String n) {
        name = n;
    }

    void setDepartment(String d) {
        department = d;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDepartment() {
        return department;
    }

    void display() {
        System.out.println("\n=== Student Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.println("Department: " + getDepartment());
    }
}
public class lab_31 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Student s1 = new Student();

        System.out.print("Enter ID: ");
        s1.setId(sc.nextInt());
        sc.nextLine();

        System.out.print("Enter Name: ");
        s1.setName(sc.nextLine());

        System.out.print("Enter Department: ");
        s1.setDepartment(sc.nextLine());

        s1.display();
    }
}
