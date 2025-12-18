class Passport {
    private String passportNumber;
    private String nationality;
    private Person person;  // Reference back to Person
    
    public Passport(String passportNumber, String nationality) {
        this.passportNumber = passportNumber;
        this.nationality = nationality;
    }
    
    public void setPerson(Person person) {
        this.person = person;
    }
    
    public void showPassportDetails() {
        System.out.println("Passport Number: " + passportNumber);
        System.out.println("Nationality: " + nationality);
        if (person != null) {
            System.out.println("Belongs to: " + person.getName());
        }
    }
}

class Person {
    private String name;
    private Passport passport;
    
    public Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;
        // Set the bidirectional link
        passport.setPerson(this);
    }
    
    public String getName() {
        return name;
    }
    
    public void showPersonDetails() {
        System.out.println("Person Name: " + name);
        System.out.println("Pass port Details:");
        passport.showPassportDetails();
    }
}

public class lab_52 {
    public static void main(String[] args) {
        Passport passport = new Passport("A12345678", "Bangladeshi");
        Person person = new Person("Hasan", passport);
        
        System.out.println("From Person side:");
        person.showPersonDetails();
        
        System.out.println("\nFrom Passport side:");
        passport.showPassportDetails();
    }
}