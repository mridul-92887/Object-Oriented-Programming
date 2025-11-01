// Base class
class Animal {
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}


class Dog extends Animal {
    public void makeSound() {
        System.out.println("Dog barks: Woof! Woof!");
    }
}
class Cat extends Animal {
    public void makeSound() {
        System.out.println("Cat meows: Meow! Meow!");
    }
}
class Cow extends Animal {
    public void makeSound() {
        System.out.println("Cow moos: Moo! Moo!");
    }
}

// Main class
public class RuntimePolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();
        Animal animal3 = new Cow();

        System.out.println("Animal 1:");
        animal1.makeSound();
        
        System.out.println("\nAnimal 2:");
        animal2.makeSound();
        
        System.out.println("\nAnimal 3:");
        animal3.makeSound();
    }
}