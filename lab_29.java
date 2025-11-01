import java.util.Scanner;

class Student {
    private int id;               // private variable
    private String department;    // private variable
    public String name;           // public variable


    void setId(int i) {
        id = i;
    }

    void setDepartment(String d) {
        department = d;
    }

    int getId() {
        return id;
    }

    String getDepartment() {
        return department;
    }

    // Display method
    void display() {
        System.out.println("\n=== Student Details ===");
        System.out.println("ID: " + getId());
        System.out.println("Name: " + name);
        System.out.println("Department: " + getDepartment());
    }
}

public class lab_29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student s1 = new Student();

        System.out.print("Enter Name: ");
        s1.name = sc.nextLine();          

        System.out.print("Enter Department: ");
        String dept = sc.nextLine();
        s1.setDepartment(dept);  

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        s1.setId(id);      
                        
        s1.display();                          
    }
}
