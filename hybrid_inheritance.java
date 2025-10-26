class Person {
    String name;
    int id;

    void displayPerson() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
    }
}

class Student extends Person {
    String department;

    void displayStudent() {
        displayPerson();
        System.out.println("Department: " + department);
    }
}

class SeniorStudent extends Student {
    int year;

    void displaySeniorStudent() {
        displayStudent();
        System.out.println("Year: " + year);
    }
}

class Teacher extends Person {
    String subject;

    void displayTeacher() {
        displayPerson();
        System.out.println("Subject: " + subject);
    }
}

public class hybrid_inheritance{
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.id = 101;
        s1.name = "Mridul";
        s1.department = "CSE";

        SeniorStudent s2 = new SeniorStudent();
        s2.id = 102;
        s2.name = "Rafi";
        s2.department = "EEE";
        s2.year = 4;

        Teacher t1 = new Teacher();
        t1.id = 201;
        t1.name = "Dr. Karim";
        t1.subject = "Mathematics";

        System.out.println("=== Student ===");
        s1.displayStudent();

        System.out.println("\n=== Senior Student ===");
        s2.displaySeniorStudent();

        System.out.println("\n=== Teacher ===");
        t1.displayTeacher();
    }
}
