import java.util.ArrayList;
import java.util.List;

// Course class
class Course {
    private String courseName;
    private List<Student> students;

    public Course(String courseName) {
        this.courseName = courseName;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
        student.enrollInCourse(this);   // maintain bidirectional mapping
    }

    public String getCourseName() {
        return courseName;
    }

    public void showCourseDetails() {
        System.out.println("Course: " + courseName);
        System.out.println("Enrolled Students:");
        for (Student s : students) {
            System.out.println("- " + s.getName());
        }
        System.out.println();
    }
}

// Student class
class Student {
    private String name;
    private List<Course> courses;

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    public void enrollInCourse(Course course) {
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    public String getName() {
        return name;
    }

    public void showStudentDetails() {
        System.out.println("Student: " + name);
        System.out.println("Enrolled Courses:");
        for (Course c : courses) {
            System.out.println("- " + c.getCourseName());
        }
        System.out.println();
    }
}

// Main class
public class lab_40 {
    public static void main(String[] args) {
        // Create Courses
        Course math = new Course("Math");
        Course science = new Course("Science");

        // Create Students
        Student alice = new Student("Alice");
        Student bob = new Student("Bob");

        // Associate students and courses
        math.addStudent(alice);
        math.addStudent(bob);
        science.addStudent(alice);

        // Show details
        alice.showStudentDetails();
        bob.showStudentDetails();
        math.showCourseDetails();
        science.showCourseDetails();
    }
}
