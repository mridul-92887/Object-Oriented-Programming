class Student {
    int id;
    String name;
    double cgpa;

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }

    void display(String department) {
        display();
        System.out.println("Department: " + department);
    }

    void display(String department, int year) {
        display(department);
        System.out.println("Year: " + year);
    }
}

public class compile_time_polymorphism {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Mridul";
        s1.cgpa = 3.8;

        s1.display();
        System.out.println();
        s1.display("CSE");
        System.out.println();
        s1.display("EEE", 4);
    }
}
