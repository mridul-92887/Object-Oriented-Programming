interface Vehicle {
    void start();
    void stop();
}

class Car implements Vehicle {
    public void start() {
        System.out.println("Car is starting");
    }
    public void stop() {
        System.out.println("Car is stopping");
    }
}

class Bike implements Vehicle {
    public void start() {
        System.out.println("Bike is starting");
    }
    public void stop() {
        System.out.println("Bike is stopping");
    }
}

class lab_48 {
    public static void main(String[] args) {
        Vehicle v1 = new Car();
        Vehicle v2 = new Bike();

        v1.start(); // Car is starting
        v2.start(); // Bike is starting
    }
}
