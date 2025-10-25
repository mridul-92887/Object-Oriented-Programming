import java.util.Scanner;

class BankAccount {
    public int id;
    public String name;
    private double balance;

    BankAccount(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public void deposit(double amount) {
        if(amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid deposit amount");
        }
    }

    public void withdraw(double amount) {
        if(amount > 0 && amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Invalid withdraw or insufficient balance");
        }
    }

    public double getBalance() {
        return balance;
    }

    public void display() {
        System.out.println("\n=== Account Info ===");
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Balance: " + getBalance());
    }
}

public class lab_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account 1 ID: ");
        int id1 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account 1 Name: ");
        String name1 = sc.nextLine();
        BankAccount acc1 = new BankAccount(id1, name1);
        acc1.deposit(1000);
        acc1.withdraw(500);

        System.out.print("Enter Account 2 ID: ");
        int id2 = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Account 2 Name: ");
        String name2 = sc.nextLine();
        BankAccount acc2 = new BankAccount(id2, name2);
        acc2.deposit(2000);
        acc2.withdraw(800);

        acc1.display();
        acc2.display();

        sc.close();
    }
}
