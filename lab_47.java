abstract class Animal {
    String name;
    Animal(String name) {
        this.name = name;
    }
    abstract void sound();
}

class Dog extends Animal {
    Dog(String name) {
        super(name);
    }
    void sound() {
        System.out.println(name + " says Woof Woof!");
    }
}

class Cat extends Animal {
    Cat(String name) {
        super(name);
    }
    void sound() {
        System.out.println(name + " says Meow Meow!");
    }
}

class lab_47{
    public static void main(String[] args) {
        Animal a1 = new Dog("Pepo");
        Animal a2 = new Cat("Mimi");

        a1.sound(); // Pepo says Woof Woof!
        a2.sound(); // Mimi says Meow Meow!
    }
}
