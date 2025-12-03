import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String name;
    private int accountNumber;
    private double balance;

    Account(String name, int accountNumber, double balance){
        this.name = name;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.println("Deposited: " + amount);
    }

    public void withdraw(double amount){
        if(amount > balance){
            System.out.println("Insufficient balance!");
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        }
    }

    public void display(){
        System.out.println("Name: " + name + ", Account No: " + accountNumber + ", Balance: " + balance);
    }
}

class SavingsAccount extends Account {
    private double interestRate;

    SavingsAccount(String name, int accountNumber, double balance, double interestRate){
        super(name, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void addInterest(){
        double interest = getBalance() * interestRate / 100;
        deposit(interest);
        System.out.println("Interest added: " + interest);
    }

    public void display(){
        super.display();
        System.out.println("Account Type: Savings, Interest Rate: " + interestRate + "%");
    }
}

class CurrentAccount extends Account {
    private double overdraftLimit;

    CurrentAccount(String name, int accountNumber, double balance, double overdraftLimit){
        super(name, accountNumber, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount){
        if(amount > getBalance() + overdraftLimit){
            System.out.println("Exceeded overdraft limit!");
        } else {
            super.withdraw(amount);
        }
    }

    public void display(){
        super.display();
        System.out.println("Account Type: Current, Overdraft Limit: " + overdraftLimit);
    }
}

public class lab_35 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Account> accounts = new ArrayList<>();

        while(true){
            System.out.println("\n--- Bank Management System ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. Create Current Account");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Add Interest (Savings Only)");
            System.out.println("6. Display All Accounts");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if(choice == 1){
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();
                System.out.print("Enter Interest Rate: ");
                double rate = sc.nextDouble();
                accounts.add(new SavingsAccount(name, accNo, balance, rate));
                System.out.println("Savings Account created successfully!");
            } else if(choice == 2){
                System.out.print("Enter Name: ");
                String name = sc.next();
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                System.out.print("Enter Initial Balance: ");
                double balance = sc.nextDouble();
                System.out.print("Enter Overdraft Limit: ");
                double limit = sc.nextDouble();
                accounts.add(new CurrentAccount(name, accNo, balance, limit));
                System.out.println("Current Account created successfully!");
            } else if(choice == 3){
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                Account acc = findAccount(accounts, accNo);
                if(acc != null){
                    System.out.print("Enter Amount to Deposit: ");
                    double amt = sc.nextDouble();
                    acc.deposit(amt);
                } else {
                    System.out.println("Account not found!");
                }
            } else if(choice == 4){
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                Account acc = findAccount(accounts, accNo);
                if(acc != null){
                    System.out.print("Enter Amount to Withdraw: ");
                    double amt = sc.nextDouble();
                    acc.withdraw(amt);
                } else {
                    System.out.println("Account not found!");
                }
            } else if(choice == 5){
                System.out.print("Enter Account Number: ");
                int accNo = sc.nextInt();
                Account acc = findAccount(accounts, accNo);
                if(acc != null && acc instanceof SavingsAccount){
                    ((SavingsAccount)acc).addInterest();
                } else {
                    System.out.println("Savings account not found!");
                }
            } else if(choice == 6){
                for(Account acc : accounts){
                    acc.display();
                    System.out.println("-------------------");
                }
            } else if(choice == 7){
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
    }

    public static Account findAccount(ArrayList<Account> accounts, int accNo){
        for(Account acc : accounts){
            if(acc.getAccountNumber() == accNo){
                return acc;
            }
        }
        return null;
    }
}
