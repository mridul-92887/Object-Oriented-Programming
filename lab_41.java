import java.util.*;

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

public class lab_41 {
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
        
        vehicles.add(new Car("BMW",200000,4));
        vehicles.add(new Car("Lamboo",150000,2));
        vehicles.add(new Bike("Kawasaki",30000,true));

        System.out.println("Only Bikes:");
        for(Vehicle v:vehicles){
            if(v instanceof Bike){
                v.display();
            }
        }
        System.out.println("Only Cars:");
        for(Vehicle v:vehicles){
            if(v instanceof Car){
                v.display();
            }
        }
        
        //Remove a bike_______
        for(int i=0;i<vehicles.size();i++){
            if(vehicles.get(i) instanceof Bike && vehicles.get(i).brand.equals("Kawasaki")){
                vehicles.remove(i);
                break;
            }
        }
        //Found a element    
        boolean found=false;
        for(Vehicle v:vehicles){
            if(v.brand.equals("Honda")){
                System.out.println("F O U N D ");
                found=true;
                break;
            }
        }
        if(!found){
            System.out.println("N O T Found ");
        }
        
    }
}
