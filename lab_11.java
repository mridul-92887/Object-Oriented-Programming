import java.util.*;
class Account{
    public int id;
    private String pass;
    Account(int id){
        this.id=id;
    }
    public void setPass(String p){
        this.pass=p;
    }
    public String getPass(){
        return this.pass;
    }

}
public class lab_11 {
    public static void main(String []args){
        Scanner input=new Scanner(System.in);

        int id=input.nextInt();
        input.nextLine();
        String pass=input.nextLine();

        Account ac1=new Account(id);
        ac1.setPass(pass);
        
        System.out.println(ac1.id);
        System.out.println(ac1.getPass());

    }
}

