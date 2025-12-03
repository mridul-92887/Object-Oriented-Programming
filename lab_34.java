import java.util.ArrayList;

class Vehicle {
    String name;
    int speed;

    Vehicle(String name, int speed) {
        this.name = name;
        this.speed = speed;
    }

    void showInfo() {
        System.out.println("Vehicle: " + name + ", Speed: " + speed);
    }
}

class Car extends Vehicle {
    int seat;

    Car(String name, int speed, int seat) {
        super(name, speed);
        this.seat = seat;
    }

    void showInfo() {
        System.out.println("Car: " + name + ", Speed: " + speed + ", Seats: " + seat);
    }
}

class Bike extends Vehicle {
    boolean hasGear;

    Bike(String name, int speed, boolean hasGear) {
        super(name, speed);
        this.hasGear = hasGear;
    }

    void showInfo() {
        System.out.println("Bike: " + name + ", Speed: " + speed + ", Gear: " + hasGear);
    }
}

public class lab_34 {
    public static void main(String[] args) {

        ArrayList<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Car("Toyota Axio", 160, 5));
        vehicles.add(new Bike("Yamaha R15", 140, true));
        vehicles.add(new Car("Honda Civic", 180, 5));
        vehicles.add(new Bike("Hero Splendor", 90, false));

        System.out.println("--- All Vehicles ---");
        for (Vehicle v : vehicles) {
            v.showInfo();
        }

        System.out.println("--- Only Cars ---");
        for (Vehicle v : vehicles) {
            if (v instanceof Car) {
                v.showInfo();
            }
        }

        System.out.println("--- Only Bikes ---");
        for (Vehicle v : vehicles) {
            if (v instanceof Bike) {
                v.showInfo();
            }
        }
    }
}
