class Student {
    int id;
    String name;
    double cgpa;

    void display() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("CGPA: " + cgpa);
    }
}

class GraduateStudent extends Student {
    String thesisTitle;

    void display() {
        super.display();
        System.out.println("Thesis Title: " + thesisTitle);
    }
}

public class run_time_polymorphism{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Mridul";
        s1.cgpa = 3.8;

        GraduateStudent gs1 = new GraduateStudent();
        gs1.id = 102;
        gs1.name = "Rafi";
        gs1.cgpa = 3.9;
        gs1.thesisTitle = "AI in Robotics";

        System.out.println("=== Student ===");
        s1.display();

        System.out.println("\n=== Graduate Student ===");
        gs1.display();  // calls overridden method
    }
}
