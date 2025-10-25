import java.util.*;

public class lab_15 {
    public static void main(String[] args) {
        ArrayList<ArrayList<String>> store = new ArrayList<>();

        ArrayList<String> iceCreams = new ArrayList<>();
        ArrayList<String> foods = new ArrayList<>();
        ArrayList<String> drinks = new ArrayList<>();

        iceCreams.add("Vanilla");
        iceCreams.add("Chocolate");
        iceCreams.add("Strawberry");

        foods.add("Burger");
        foods.add("Pizza");
        foods.add("Pasta");

        drinks.add("Coke");
        drinks.add("Orange Juice");
        drinks.add("Water");

        store.add(iceCreams);
        store.add(foods);
        store.add(drinks);

        System.out.println("===== Store Items =====");
        System.out.println("Ice Creams: " + store.get(0));
        System.out.println("Foods: " + store.get(1));
        System.out.println("Drinks: " + store.get(2));

        System.out.println("\n===== Display Using Loop =====");
        String[] category = {"Ice Creams", "Foods", "Drinks"};
        for (int i = 0; i < store.size(); i++) {
            System.out.println(category[i] + ": " + store.get(i));
        }
    }
}
