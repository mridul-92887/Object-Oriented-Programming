import java.util.*;   // ArrayList এবং Scanner এর জন্য

public class ArrayList_basic {
    public static void main(String[] args) {
        // main array list (store)
        ArrayList<ArrayList<String>> store = new ArrayList<>();

        // 3টা আলাদা category এর list
        ArrayList<String> iceCreams = new ArrayList<>();
        ArrayList<String> foods = new ArrayList<>();
        ArrayList<String> drinks = new ArrayList<>();

        // Ice Cream items যোগ করা
        iceCreams.add("Vanilla");
        iceCreams.add("Chocolate");
        iceCreams.add("Strawberry");

        // Food items যোগ করা
        foods.add("Burger");
        foods.add("Pizza");
        foods.add("Pasta");

        // Drink items যোগ করা
        drinks.add("Coke");
        drinks.add("Orange Juice");
        drinks.add("Water");

        // এখন এই তিনটা list main store list এ যোগ করা
        store.add(iceCreams);
        store.add(foods);
        store.add(drinks);

        // এখন display করবো সব items
        System.out.println("===== Store Items =====");
        System.out.println("Ice Creams: " + store.get(0));
        System.out.println("Foods: " + store.get(1));
        System.out.println("Drinks: " + store.get(2));

        // 🔹 চাইলে loop দিয়েও দেখানো যায়
        System.out.println("\n===== Display Using Loop =====");
        String[] category = {"Ice Creams", "Foods", "Drinks"};
        for (int i = 0; i < store.size(); i++) {
            System.out.println(category[i] + ": " + store.get(i));
        }
    }
}
