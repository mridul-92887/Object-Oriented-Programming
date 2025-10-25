import java.util.Scanner;

class BankAccount {
    private int accountNumber;
    private double balance;

    // ✅ Constructor to set initial values
    public BankAccount(int num, double bal) {
        accountNumber = num;
        balance = bal;
    }
    // Deposit method
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Display account info
    public void showInfo() {
        System.out.println("\nAccount Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }
}

public class lgy_8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking account info from user
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        // ✅ Create object using constructor
        BankAccount acc = new BankAccount(accNo, balance);

        // Show initial info
        acc.showInfo();

        // Deposit operation
        System.out.print("\nEnter Deposit Amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        // Withdraw operation
        System.out.print("Enter Withdraw Amount: ");
        double wit = sc.nextDouble();
        acc.withdraw(wit);

        // Show final info
        acc.showInfo();

        sc.close();
    }
}
