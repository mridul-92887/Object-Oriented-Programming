import java.util.ArrayList;

// Abstract class Payment
abstract class Payment {
    protected double amount;
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    public double getAmount() {
        return amount;
    }
    
    public void setAmount(double amount) {
        this.amount = amount;
    }
    
    // Abstract method to be implemented by subclasses
    public abstract void processPayment();
}

// CreditCardPayment class
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolderName;
    
    public CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    // Method to calculate credit card specific charge (2%)
    private double calculateCharge() {
        return amount * 0.02; // 2% charge for credit card
    }
    
    @Override
    public void processPayment() {
        double charge = calculateCharge();
        double total = amount + charge;
        
        System.out.println("Processing Credit Card Payment...");
        System.out.println("Card Holder: " + cardHolderName);
        System.out.println("Card Number: " + maskCardNumber(cardNumber));
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Credit Card Charge (2%): $" + String.format("%.2f", charge));
        System.out.println("Total Amount: $" + String.format("%.2f", total));
        System.out.println("Payment processed successfully!\n");
    }
    
    private String maskCardNumber(String cardNumber) {
        if (cardNumber.length() > 4) {
            return "****-****-****-" + cardNumber.substring(cardNumber.length() - 4);
        }
        return cardNumber;
    }
    
    // Getter methods for additional functionality
    public String getCardHolderName() {
        return cardHolderName;
    }
    
    public String getCardNumber() {
        return cardNumber;
    }
}

// MobilePayment class
class MobilePayment extends Payment {
    private String mobileNumber;
    private String provider;
    
    public MobilePayment(double amount, String mobileNumber, String provider) {
        super(amount);
        this.mobileNumber = mobileNumber;
        this.provider = provider;
    }
    
    // Method to calculate mobile payment specific charge (fixed $0.50 + 1%)
    private double calculateCharge() {
        return 0.50 + (amount * 0.01); // $0.50 fixed + 1% for mobile payment
    }
    
    @Override
    public void processPayment() {
        double charge = calculateCharge();
        double total = amount + charge;
        
        System.out.println("Processing Mobile Payment...");
        System.out.println("Mobile Number: " + mobileNumber);
        System.out.println("Provider: " + provider);
        System.out.println("Amount: $" + String.format("%.2f", amount));
        System.out.println("Mobile Payment Charge ($0.50 + 1%): $" + String.format("%.2f", charge));
        System.out.println("Total Amount: $" + String.format("%.2f", total));
        System.out.println("Payment processed successfully!\n");
    }
    
    // Getter methods for additional functionality
    public String getMobileNumber() {
        return mobileNumber;
    }
    
    public String getProvider() {
        return provider;
    }
}

// Main class to demonstrate polymorphism with ArrayList
public class lab_49{
    public static void main(String[] args) {
        // Create an ArrayList of Payment objects
        ArrayList<Payment> payments = new ArrayList<>();
        
        // Add different payment objects to the ArrayList
        payments.add(new CreditCardPayment(100.00, "1234567812345678", "John Doe"));
        payments.add(new MobilePayment(50.00, "9876543210", "PayPal"));
        payments.add(new CreditCardPayment(200.50, "8765432187654321", "Jane Smith"));
        payments.add(new MobilePayment(75.25, "9123456789", "Google Pay"));
        payments.add(new CreditCardPayment(150.75, "5555666677778888", "Bob Johnson"));
        
        // Display initial information
        System.out.println("=== PAYMENT SYSTEM INITIALIZED ===\n");
        System.out.println("Total payments in queue: " + payments.size());
        System.out.println("Payment types: " + getPaymentTypeCount(payments));
        
        // Process all payments using polymorphism
        System.out.println("\n=== PROCESSING ALL PAYMENTS ===\n");
        processAllPayments(payments);
        
        // Display payment summary with enhanced details
        displayPaymentSummary(payments);
        
        // Demonstrate additional ArrayList operations
        demonstrateArrayListOperations(payments);
    }
    
    // Method to process all payments in the ArrayList
    private static void processAllPayments(ArrayList<Payment> payments) {
        int paymentCount = 1;
        for (Payment payment : payments) {
            System.out.println("Payment #" + paymentCount + ":");
            payment.processPayment(); // Polymorphic call
            paymentCount++;
        }
    }
    
    // Method to display payment summary
    private static void displayPaymentSummary(ArrayList<Payment> payments) {
        System.out.println("=== PAYMENT SUMMARY ===");
        
        double totalAmount = 0;
        int creditCardCount = 0;
        int mobilePaymentCount = 0;
        
        for (Payment payment : payments) {
            totalAmount += payment.getAmount();
            
            // Using instanceof to count different payment types
            if (payment instanceof CreditCardPayment) {
                creditCardCount++;
            } else if (payment instanceof MobilePayment) {
                mobilePaymentCount++;
            }
        }
        
        System.out.println("Total Number of Payments: " + payments.size());
        System.out.println("Credit Card Payments: " + creditCardCount);
        System.out.println("Mobile Payments: " + mobilePaymentCount);
        System.out.println("Total Amount (before charges): $" + String.format("%.2f", totalAmount));
        System.out.println("Average Payment Amount: $" + String.format("%.2f", totalAmount / payments.size()));
    }
    
    // Method to get count of payment types
    private static String getPaymentTypeCount(ArrayList<Payment> payments) {
        int creditCardCount = 0;
        int mobilePaymentCount = 0;
        
        for (Payment payment : payments) {
            if (payment instanceof CreditCardPayment) {
                creditCardCount++;
            } else if (payment instanceof MobilePayment) {
                mobilePaymentCount++;
            }
        }
        
        return creditCardCount + " Credit Card, " + mobilePaymentCount + " Mobile";
    }
    
    // Method to demonstrate additional ArrayList operations
    private static void demonstrateArrayListOperations(ArrayList<Payment> payments) {
        System.out.println("\n=== ADDITIONAL ARRAYLIST OPERATIONS ===\n");
        
        // 1. Access specific element
        System.out.println("1. First payment in list:");
        if (!payments.isEmpty()) {
            payments.get(0).processPayment();
        }
        
        // 2. Remove a payment
        System.out.println("2. Removing second payment from list...");
        if (payments.size() > 1) {
            Payment removed = payments.remove(1);
            System.out.println("Removed payment of amount: $" + removed.getAmount());
        }
        
        // 3. Add a new payment
        System.out.println("3. Adding a new mobile payment...");
        payments.add(new MobilePayment(99.99, "8887776666", "Apple Pay"));
        
        // 4. Check if list contains specific payment type
        System.out.println("4. List contains MobilePayment: " + containsMobilePayment(payments));
        
        // 5. Process remaining payments
        System.out.println("\n5. Processing remaining " + payments.size() + " payments:");
        for (int i = 0; i < payments.size(); i++) {
            System.out.println("Payment index " + i + ":");
            payments.get(i).processPayment();
        }
    }
    
    // Helper method to check if list contains any MobilePayment
    private static boolean containsMobilePayment(ArrayList<Payment> payments) {
        for (Payment payment : payments) {
            if (payment instanceof MobilePayment) {
                return true;
            }
        }
        return false;
    }
    
    // Additional method to demonstrate filtering payments
    public static void displayCreditCardPayments(ArrayList<Payment> payments) {
        System.out.println("\n=== CREDIT CARD PAYMENTS ONLY ===");
        for (Payment payment : payments) {
            if (payment instanceof CreditCardPayment) {
                // Cast to access CreditCardPayment specific methods
                CreditCardPayment ccp = (CreditCardPayment) payment;
                System.out.println("Card Holder: " + ccp.getCardHolderName() + 
                                 ", Amount: $" + String.format("%.2f", ccp.getAmount()));
            }
        }
    }
}