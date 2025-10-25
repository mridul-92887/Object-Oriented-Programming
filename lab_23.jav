// Parent class
class Car {
    String brand;

    void start() {
        System.out.println(brand + " car is starting");
    }
}

// Child class
class SportsCar extends Car {
    int maxSpeed;

    void display() {
        System.out.println("Sports car brand: " + brand);
        System.out.println("Max speed: " + maxSpeed + " km/h");
    }
}

// Main class
public class lab_23 {
    public static void main(String[] args) {
        SportsCar myCar = new SportsCar();
        myCar.brand = "Ferrari";   // inherited property
        myCar.maxSpeed = 350;      // own property

        myCar.start();    // inherited method
        myCar.display();  // child class method
    }
}
