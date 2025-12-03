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
    List<Student>students=new ArrayList<>();
    Department(String name){
        this.name=name;
        this.students= new ArrayList<>();
    }
    void showdisplay(){
        System.out.println("Department "+ name);
        System.out.println("Students_____");
        for(Student v : students){
            v.display();
        }
    }
}
class lab_38{
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);
        
        Student s1= new Student(365 ,"Mridul");
        Student s2 = new Student(828, "Evan");
        
        Department d=new Department("X");
        
        d.students.add(s1);
        d.students.add(s2);  
        d.showdisplay();

    }
}
