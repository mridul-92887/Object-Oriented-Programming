// Passport class
class Passport {
    private String passportNumber;
    private String nationality;
    private Person person; // Back-reference (important for bi-directional)

    public Passport(String passportNumber, String nationality) {
        this.passportNumber = passportNumber;
        this.nationality = nationality;
    }

    // Set the person who owns this passport
    public void setPerson(Person person) {
        this.person = person;
    }

    public void showPassportDetails() {
        System.out.println("Passport Number: " + passportNumber);
        System.out.println("Nationality: " + nationality);

        // Show Person also (bi-directional)
        if (person != null) {
            System.out.println("Owned By: " + person.getName());
        }
    }
}

// Person class
class Person {
    private String name;
    private Passport passport;

    public Person(String name, Passport passport) {
        this.name = name;
        this.passport = passport;

        // Link Passport back to this Person
        passport.setPerson(this);
    }

    public String getName() {
        return name;
    }

    public void showPersonDetails() {
        System.out.println("Person Name: " + name);
        System.out.println("Passport Details:");
        passport.showPassportDetails();
    }
}

// Main class
public class lab_42{
    public static void main(String[] args) {
        // Create Passport
        Passport passport = new Passport("A12345678", "Bangladeshi");

        // Create Person and link the passport (bi-directional linking)
        Person person = new Person("Hasan", passport);

        // Show Person first
        System.out.println("Showing Person Details:");
        person.showPersonDetails();

        System.out.println();

        // Show Passport and confirm reverse-link
        System.out.println("Showing Passport Details:");
        passport.showPassportDetails();
    }
}
