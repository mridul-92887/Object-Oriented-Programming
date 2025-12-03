// Class representing Address
class Address {
    String city, country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    void displayAddress() {
        System.out.println(city + ", " + country);
    }
}

// Aggregation: Employee has an Address, but Address can exist independently
class Employee {
    String name;
    Address address; // Aggregation

    Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void displayInfo() {
        System.out.println("Employee: " + name);
        System.out.print("Address: ");
        address.displayAddress();
    }
}

public class lab_43 {
    public static void main(String[] args) {
        Address addr = new Address("Dhaka", "Bangladesh"); 
        Employee emp = new Employee("Hasnur", addr);

        emp.displayInfo();
    }
}
