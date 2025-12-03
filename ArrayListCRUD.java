import java.util.ArrayList;

public class ArrayListCRUD {
    public static void main(String[] args) {
        ArrayList<String> fruits = new ArrayList<>();
        
        fruits.add("Apple");                    // Add to end
        fruits.add("Banana");
        fruits.add("Orange");
        fruits.add(1, "Mango");                 // Add at index 1
        
        // Add another ArrayList
        ArrayList<String> moreFruits = new ArrayList<>();
        moreFruits.add("Grapes");
        moreFruits.add("Pineapple");
        fruits.addAll(moreFruits);              // Add entire ArrayList
        
        System.out.println("After adding: " + fruits);
        
        // READ - Accessing from ArrayList
        String first = fruits.get(0);           // Get by index
        int size = fruits.size();               // Get size
        boolean empty = fruits.isEmpty();       // Check if empty
        boolean hasApple = fruits.contains("Apple"); // Check element
        
        System.out.println("First: " + first);
        System.out.println("Size: " + size);
        System.out.println("Empty: " + empty);
        System.out.println("Has Apple: " + hasApple);
        
        // UPDATE - Modifying ArrayList
        fruits.set(2, "Sweet Orange");          // Update at index 2
        System.out.println("After update: " + fruits);
        
        // DELETE - Removing from ArrayList
        fruits.remove("Banana");                // Remove by object
        fruits.remove(0);                       // Remove by index
        fruits.clear();                         // Remove all
        System.out.println("After clear: " + fruits);
    }
}