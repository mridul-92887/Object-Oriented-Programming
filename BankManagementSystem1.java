import java.util.*;

// === BankAccount Class ===
class BankAccount {
    // Attributes (private for encapsulation)
    private String accountHolder;
    private int accountNumber;
    private double balance;
    private List<String> transactions;  // to store transaction history

    // Constructor
    public BankAccount(String holder, int accNo, double initialBalance) {
        this.accountHolder = holder;
        this.accountNumber = accNo;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        transactions.add("Account Created with Balance: " + initialBalance);
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add("Deposited: " + amount + " | Balance: " + balance);
            System.out.println("Deposited " + amount + " successfully!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Withdraw method
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add("Withdrew: " + amount + " | Balance: " + balance);
            System.out.println("Withdrew " + amount + " successfully!");
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    // Transfer method
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

    // Check Balance
    public void checkBalance() {
        System.out.println("\nAccount Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: $" + balance);
    }

    // Transaction History
    public void showTransactions() {
        System.out.println("\nTransaction History of " + accountHolder + ":");
        for (String t : transactions) {
            System.out.println(" - " + t);
        }
    }

    // Getter for Account Number
    public int getAccountNumber() {
        return accountNumber;
    }
}

// === Bank Class ===
class Bank {
    private Map<Integer, BankAccount> accounts;
    private int accountCounter;

    public Bank() {
        accounts = new HashMap<>();
        accountCounter = 100000; // starting account number
    }

    // Create new account
    public BankAccount createAccount(String holder, double initialBalance) {
        int accNo = ++accountCounter;
        BankAccount acc = new BankAccount(holder, accNo, initialBalance);
        accounts.put(accNo, acc);
        System.out.println("Account Created! Account Number: " + accNo);
        return acc;
    }

    // Find account by account number
    public BankAccount getAccount(int accNo) {
        return accounts.get(accNo);
    }

    // Display all accounts
    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts available.");
            return;
        }
        System.out.println("\n--- All Accounts ---");
        for (BankAccount acc : accounts.values()) {
            acc.checkBalance();
        }
    }

    // Total accounts
    public void totalAccounts() {
        System.out.println("Total Accounts: " + accounts.size());
    }
}

// === Main Class ===
public class BankManagementSystem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank(); // Create Bank object

        int choice;
        do {
            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Money Transfer");
            System.out.println("6. Transaction History");
            System.out.println("7. Display All Accounts");
            System.out.println("8. Total Accounts");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Account Holder Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    sc.nextLine();
                    bank.createAccount(name, balance);
                }
                case 2 -> {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Deposit Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();
                        acc.deposit(amt);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                }
                case 3 -> {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount acc = bank.getAccount(accNo);
                    if (acc != null) {
                        System.out.print("Enter Withdraw Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();
                        acc.withdraw(amt);
                    } else {
                        System.out.println("Account Not Found!");
                    }
                }
                case 4 -> {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount acc = bank.getAccount(accNo);
                    if (acc != null) {
                        acc.checkBalance();
                    } else {
                        System.out.println("Account Not Found!");
                    }
                }
                case 5 -> {
                    System.out.print("Enter Your Account Number: ");
                    int sAccNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount sender = bank.getAccount(sAccNo);

                    System.out.print("Enter Receiver Account Number: ");
                    int rAccNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount receiver = bank.getAccount(rAccNo);

                    if (sender != null && receiver != null) {
                        System.out.print("Enter Transfer Amount: ");
                        double amt = sc.nextDouble();
                        sc.nextLine();
                        sender.transfer(receiver, amt);
                    } else {
                        System.out.println("One or both accounts not found!");
                    }
                }
                case 6 -> {
                    System.out.print("Enter Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();
                    BankAccount acc = bank.getAccount(accNo);
                    if (acc != null) {
                        acc.showTransactions();
                    } else {
                        System.out.println("Account Not Found!");
                    }
                }
                case 7 -> bank.displayAllAccounts();
                case 8 -> bank.totalAccounts();
                case 0 -> System.out.println("Exiting... Thank you!");
                default -> System.out.println("Invalid Choice!");
            }
        } while (choice != 0);

        sc.close();
    }
}
