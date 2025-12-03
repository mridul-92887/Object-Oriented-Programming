import java.util.ArrayList;

class Vehicle {
    String brand;
    int price;
    Vehicle(String brand, int price){
        this.brand = brand;
        this.price = price;
    }

    void display(){
        System.out.println("Brand: " + brand + ", Price: " + price);
    }
}

class Car extends Vehicle {
    int seats;

    Car(String brand, int price, int seats){
        super(brand, price);
        this.seats = seats;
    }

    void display(){
        System.out.println("Car Brand: " + brand + ", Price: " + price + ", Seats: " + seats);
    }
}

class Bike extends Vehicle {
    boolean hasCarrier;

    Bike(String brand, int price, boolean hasCarrier){
        super(brand, price);
        this.hasCarrier = hasCarrier;
    }

    void display(){
        System.out.println("Bike Brand: " + brand + ", Price: " + price + ", Has Carrier: " + hasCarrier);
    }
}

public class lab_36 {
    public static void main(String[] args) {
        ArrayList<Vehicle> vehicles = new ArrayList<>();

        Car c1 = new Car("Toyota", 1500000, 5);
        Car c2 = new Car("Honda", 1200000, 4);

        Bike b1 = new Bike("Yamaha", 250000, true);
        Bike b2 = new Bike("Suzuki", 200000, false);

        vehicles.add(c1);
        vehicles.add(c2);
        vehicles.add(b1);
        vehicles.add(b2);

        System.out.println("Only Bikes:");
        for(Vehicle v : vehicles){
            if(v instanceof Bike){
                v.display();
            }
        }
    }
}
