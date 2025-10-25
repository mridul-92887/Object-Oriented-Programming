class BankAccount {
    private double balance;

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
}

public class lab_21{
    public static void main(String[] args) {
        BankAccount acc = new BankAccount();
        acc.deposit(1000);
        acc.withdraw(500);
        System.out.println("Current Balance: " + acc.getBalance());
    }
}
