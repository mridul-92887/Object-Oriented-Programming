public class return_val {
  static int myMethod(int x,int y) {
        int z = x*y;
    return z ;
  }
  static String myMethod1(String name,int age){
    return name+" "+age;
  }

  public static void main(String[] args) {
    System.out.println(myMethod(10,10));
    System.out.println(myMethod1("Mridul",22));
  }
}
