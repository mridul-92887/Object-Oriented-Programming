import java.util.ArrayList;

abstract class Payment {
    double amount;
    
    Payment(double amount) {
        this.amount = amount;
    }
    
    abstract void processPayment();
}

class CreditCardPayment extends Payment {
    String cardNumber;
    String cardHolderName;
    
    CreditCardPayment(double amount, String cardNumber, String cardHolderName) {
        super(amount);
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }
    
    @Override
    void processPayment() {
        double charge = amount * 0.02;
        System.out.println("Credit Card Payment");
        System.out.println("Name: " + cardHolderName);
        System.out.println("Card: XXXX-XXXX-XXXX-" + cardNumber.substring(12));
        System.out.println("Amount: Rs." + amount);
        System.out.println("Charge (2%): Rs." + charge);
        System.out.println("Total: Rs." + (amount + charge));
        System.out.println();
    }
}

class MobilePayment extends Payment {
    String mobileNumber;
    String provider;
    
    MobilePayment(double amount, String mobileNumber, String provider) {
        super(amount);
        this.mobileNumber = mobileNumber;
        this.provider = provider;
    }
    
    @Override
    void processPayment() {
        double charge = amount * 0.015;
        System.out.println("Mobile Payment");
        System.out.println("Mobile: " + mobileNumber);
        System.out.println("Provider: " + provider);
        System.out.println("Amount: Rs." + amount);
        System.out.println("Charge (1.5%): Rs." + charge);
        System.out.println("Total: Rs." + (amount + charge));
        System.out.println();
    }
}

public class lab_44 {
    public static void main(String[] args) {
        
        ArrayList<Payment> payments = new ArrayList<Payment>();
        
        payments.add(new CreditCardPayment(1000, "1234567812345678", "Amit Kumar"));
        payments.add(new MobilePayment(500, "9876543210", "Airtel"));
        payments.add(new CreditCardPayment(2500, "5555666677778888", "Neha Sharma"));
        payments.add(new MobilePayment(750, "8899776655", "Jio"));
        payments.add(new CreditCardPayment(1500, "9999888877776666", "Raj Patel"));
        
        System.out.println("PAYMENT PROCESSING STARTED\n");
        
        for(int i = 0; i < payments.size(); i++) {
            System.out.println("Payment #" + (i+1) + ":");
            payments.get(i).processPayment();
        }
        
        System.out.println("USING ENHANCED FOR LOOP\n");
        for(Payment p : payments) {
            p.processPayment();
        }
        
        System.out.println("ARRAYLIST INFORMATION");
        System.out.println("Total payments: " + payments.size());
        
        System.out.println("\nProcessing only 3rd payment:");
        payments.get(2).processPayment();
        
        payments.add(new MobilePayment(1200, "7766554433", "VI"));
        System.out.println("New payment added!");
        System.out.println("Now total payments: " + payments.size());
        
        System.out.println("\nProcessing last payment:");
        payments.get(payments.size() - 1).processPayment();
    }
}