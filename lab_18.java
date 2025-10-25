import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private String department;

    // 🔹 Setter methods
    void setId(int i) {
        id = i;
    }

    void setName(String n) {
        name = n;
    }

    void setDepartment(String d) {
        department = d;
    }

    // 🔹 Getter methods
    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getDepartment() {
        return department;
    }
}

public class lab_18 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s = new Student();

        // 🔹 User input using Scanner
        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // buffer clear

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();

        // 🔹 Set private variables using setter
        s.setId(id);
        s.setName(name);
        s.setDepartment(dept);

        // 🔹 Access private variables using getter
        System.out.println("\n=== Student Details ===");
        System.out.println("ID: " + s.getId());
        System.out.println("Name: " + s.getName());
        System.out.println("Department: " + s.getDepartment());

        sc.close();
    }
}
