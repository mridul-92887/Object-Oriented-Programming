import java.util.Scanner;

class BankAccount {
    // Public variables (no encapsulation)
    int accountNumber;
    double balance;

    // Constructor
    public BankAccount(int accNo, double bal) {
        accountNumber = accNo;
        balance = bal;
    }

    // Deposit money
    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    // Withdraw money
    public void withdraw(double amount) {
        if(amount <= balance) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    // Show account info
    public void showInfo() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }
}

// Main class
public class lgy_10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Take account info from user
        System.out.print("Enter Account Number: ");
        int accNo = sc.nextInt();

        System.out.print("Enter Initial Balance: ");
        double bal = sc.nextDouble();

        BankAccount acc = new BankAccount(accNo, bal);

        acc.showInfo();

        // Deposit
        System.out.print("Enter Deposit Amount: ");
        double dep = sc.nextDouble();
        acc.deposit(dep);

        // Withdraw
        System.out.print("Enter Withdraw Amount: ");
        double wit = sc.nextDouble();
        acc.withdraw(wit);

        // Final info
        acc.showInfo();

        sc.close();
    }
}
