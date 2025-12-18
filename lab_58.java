// Part class
class Room {
    void describe() {
        System.out.println("This is a room.");
    }
}

// Whole class (Composition)
class House {
    private Room room;   // Strong HAS-A (Composition)

    House() {
        room = new Room();   // Room created inside House
    }

    void showHouse() {
        System.out.println("House details:");
        room.describe();
    }
}

// Main class
public class CompositionExample2 {
    public static void main(String[] args) {

        House house = new House();
        house.showHouse();
    }
}
