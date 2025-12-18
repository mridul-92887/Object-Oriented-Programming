// Class representing Address
class Address {
    private String city;
    private String country;

    Address(String city, String country) {
        this.city = city;
        this.country = country;
    }

    void displayAddress() {
        System.out.println(city + ", " + country);
    }
}

// Aggregation: Employee HAS an Address
class Employee {
    private String name;
    private Address address;   // Aggregation (HAS-A)

    Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    void displayInfo() {
        System.out.println("Employee Name: " + name);
        System.out.print("Address: ");
        address.displayAddress();
    }
}

// Main class
public class AggregationExample {
    public static void main(String[] args) {

        // Address object exists independently
        Address addr = new Address("Dhaka", "Bangladesh");

        // Employee has an Address
        Employee emp = new Employee("Hasnur", addr);

        emp.displayInfo();
    }
}
