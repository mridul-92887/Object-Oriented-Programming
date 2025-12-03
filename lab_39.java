import java.util.*;
class Student{
    int id;
    String name;
    Student(int id,String name){
        this.id=id;
        this.name=name;
    }
    void display(){
    System.out.println(id+ " "+name);
}
}
class Department{
    String name;
    private List<Student>students=new ArrayList<>();
    Department(String name){
        this.name=name;
        this.students= new ArrayList<>();
    }
    public void setStudent(Student s){
        students.add(s);

    }
    void showdisplay(){
        System.out.println("Department "+ name);
        System.out.println("Students_____");
        for(Student v : students){
            v.display();
        }
    }
}
class lab_39{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        Student s1= new Student(365 ,"Mridul");
        Student s2 = new Student(828, "Evan");
        Student s3= new Student(467 ,"Alma");
        Student s4 = new Student(488, "Tasnim");
        
        Department d1=new Department("X");
        d1.setStudent(s1);
        d1.setStudent(s2);
        d1.showdisplay();

        Department d2=new Department("Y");
        d2.setStudent(s3);
        d2.setStudent(s4);
        d2.showdisplay();

    }
}
