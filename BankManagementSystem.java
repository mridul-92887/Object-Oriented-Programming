import java.util.*;

// === BankAccount Class ===
class BankAccount {
    // Attributes (private for encapsulation)
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private List<String> transactions;  // to store history

    // Constructor
    public BankAccount(String holder, int accNo, double initialBalance) {
        this.accountHolder = holder;
        this.accountNumber = accNo;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account Created with Balance: " + initialBalance);
    }

    // Method: Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Deposited " + amount + " successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method: Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Withdrew " + amount + " successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Method: Transfer
    public void transfer(BankAccount receiver, double amount) {
        if (amount > 0 && amount <= balance) {
            this.balance -= amount;
            receiver.balance += amount;
            this.transactions.add("Transferred " + amount + " to " + receiver.accountHolder);
            receiver.transactions.add("Received " + amount + " from " + this.accountHolder);
            System.out.println("Transfer Successful!");
        } else {
            System.out.println("Transfer Failed!");
        }
    }

    // Method: Check Balance
    public void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: " + balance);
    }

    // Method: Transaction History
    public void showTransactions() {
        System.out.println("Transaction History of " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println(" - " + t);
        }
    }

    // Getter (Encapsulation এর জন্য)
    public int getAccountNumber() {
        return accountNumber;
    }
}

// === Main Class (Bank Management System) ===
public class BankManagementSystem {
    private static Scanner sc = new Scanner(System.in); // static so সব জায়গায় ব্যবহার হবে
    private static Map<Integer, BankAccount> accounts = new HashMap<>();
    private static int accountCounter = 100000; // Auto account number

    // Method: Create Account
    public static void createAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = sc.next();
        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();
        int accNo = ++accountCounter;
        BankAccount acc = new BankAccount(name, accNo, balance);
        accounts.put(accNo, acc);
        System.out.println("Account Created! Account Number: " + accNo);
    }

    // Method: Get Account by Number
    public static BankAccount getAccount(int accNo) {
        return accounts.get(accNo);
    }

    // === Main Menu ===
    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Money Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    System.out.print("Enter Account Number: ");
                    int dAcc = sc.nextInt();
                    BankAccount dAccObj = getAccount(dAcc);
                    if (dAccObj != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double damt = sc.nextDouble();
                        dAccObj.deposit(damt);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account Number: ");
                    int wAcc = sc.nextInt();
                    BankAccount wAccObj = getAccount(wAcc);
                    if (wAccObj != null) {
                        System.out.print("Enter Withdraw Amount: ");
                        double wamt = sc.nextDouble();
                        wAccObj.withdraw(wamt);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account Number: ");
                    int cAcc = sc.nextInt();
                    BankAccount cAccObj = getAccount(cAcc);
                    if (cAccObj != null) {
                        cAccObj.checkBalance();
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 5:
                    System.out.print("Enter Your Account Number: ");
                    int sAcc = sc.nextInt();
                    BankAccount sAccObj = getAccount(sAcc);
                    System.out.print("Enter Receiver Account Number: ");
                    int rAcc = sc.nextInt();
                    BankAccount rAccObj = getAccount(rAcc);
                    if (sAccObj != null && rAccObj != null) {
                        System.out.print("Enter Transfer Amount: ");
                        double tamt = sc.nextDouble();
                        sAccObj.transfer(rAccObj, tamt);
                    } else {
                        System.out.println("One or Both Accounts Not Found!");
                    }
                    break;
                case 6:
                    System.out.print("Enter Account Number: ");
                    int tAcc = sc.nextInt();
                    BankAccount tAccObj = getAccount(tAcc);
                    if (tAccObj != null) {
                        tAccObj.showTransactions();
                    } else {
                        System.out.println("Account Not Found!");
                    }
                    break;
                case 7:
                    System.out.println("Thank you for using Bank Management System!");
                    System.exit(0);
                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
