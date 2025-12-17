import java.util.ArrayList;

// Abstract class for all payments
abstract class Payment {
    protected double amount;  // protected so subclasses can access it
    
    public Payment(double amount) {
        this.amount = amount;
    }
    
    // Public method that all payments must implement
    public abstract void processPayment();
}

// Credit Card Payment
class CreditCardPayment extends Payment {
    private String cardNumber;
    private String cardHolder;
    
    public CreditCardPayment(double amount, String cardNumber, String cardHolder) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }
    
    @Override
    public void processPayment() {
        double charge = amount * 0.02;  // 2% charge
        double total = amount + charge;
        System.out.println("Credit Card Payment: " + cardHolder);
        System.out.println("Amount: $" + amount);
        System.out.println("Charge (2%): $" + charge);
        System.out.println("Total: $" + total);
        System.out.println();
    }
}

// Mobile Payment
class MobilePayment extends Payment {
    private String mobileNumber;
    private String provider;
    
    public MobilePayment(double amount, String mobileNumber, String provider) {
        super(amount);
        this.mobileNumber = mobileNumber;
        this.provider = provider;
    }
    
    @Override
    public void processPayment() {
        double charge = 0.50 + (amount * 0.01);  // $0.50 + 1%
        double total = amount + charge;
        System.out.println("Mobile Payment: " + mobileNumber);
        System.out.println("Provider: " + provider);
        System.out.println("Amount: $" + amount);
        System.out.println("Charge: $" + charge);
        System.out.println("Total: $" + total);
        System.out.println();
    }
}

// Main class
public class lab_50 {
    public static void main(String[] args) {
        
        // Create ArrayList to hold payments
        ArrayList<Payment> payments = new ArrayList<>();
        
        // Add different types of payments
        payments.add(new CreditCardPayment(100.0, "12345678", "John"));
        payments.add(new MobilePayment(50.0, "987654321", "PayPal"));
        payments.add(new CreditCardPayment(200.0, "87654321", "Alice"));
        payments.add(new MobilePayment(75.0, "912345678", "GPay"));
        
        // Process all payments using polymorphism
        System.out.println("Processing all payments:");
        System.out.println("========================");
        
        for(Payment p : payments) {
            p.processPayment();  // This calls the correct method for each payment type
        }
        
        // Show total number of payments
        System.out.println("Total payments: " + payments.size());
    }
}