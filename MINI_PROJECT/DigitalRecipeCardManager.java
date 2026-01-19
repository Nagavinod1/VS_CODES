import java.util.ArrayList;
import java.util.Scanner;

class Recipe {
    private String name;
    private int prepTime;
    private ArrayList<String> ingredients;

    public Recipe(String name, int prepTime, ArrayList<String> ingredients) {
        this.name = name;
        this.prepTime = prepTime;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void displayRecipe() {
        System.out.println("\n🍴 Recipe: " + name);
        System.out.println("⏱ Preparation Time: " + prepTime + " mins");
        System.out.println("📝 Ingredients:");
        for (String ing : ingredients) {
            System.out.println("  - " + ing);
        }
    }
}

class RecipeManager {
    private ArrayList<Recipe> recipes;
    private Scanner sc;

    public RecipeManager() {
        recipes = new ArrayList<>();
        sc = new Scanner(System.in);
    }

    public void addRecipe() {
        System.out.print("Enter recipe name: ");
        String name = sc.nextLine();

        System.out.print("Enter preparation time (in minutes): ");
        int prepTime = Integer.parseInt(sc.nextLine());

        System.out.print("Enter ingredients (comma separated): ");
        String[] ingArr = sc.nextLine().split(",");
        ArrayList<String> ingredients = new ArrayList<>();
        for (String ing : ingArr) {
            ingredients.add(ing.trim());
        }

        Recipe newRecipe = new Recipe(name, prepTime, ingredients);
        recipes.add(newRecipe);
        System.out.println("✅ '" + name + "' added successfully!");
    }

    public void viewRecipes() {
        if (recipes.isEmpty()) {
            System.out.println("❌ No recipes found!");
            return;
        }
        System.out.println("\n📚 All Recipes:");
        for (int i = 0; i < recipes.size(); i++) {
            System.out.println((i + 1) + ". " + recipes.get(i).getName());
        }
    }

    public void searchRecipe() {
        System.out.print("Enter recipe name to search: ");
        String keyword = sc.nextLine().toLowerCase();

        boolean found = false;
        for (Recipe r : recipes) {
            if (r.getName().toLowerCase().contains(keyword)) {
                r.displayRecipe();
                found = true;
            }
        }
        if (!found) {
            System.out.println("❌ Recipe not found!");
        }
    }
}

public class DigitalRecipeCardManager {
    public static void main(String[] args) {
        RecipeManager manager = new RecipeManager();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== Digital Recipe Card Manager =====");
            System.out.println("1. Add Recipe");
            System.out.println("2. View Recipes");
            System.out.println("3. Search Recipe");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    manager.addRecipe();
                    break;
                case "2":
                    manager.viewRecipes();
                    break;
                case "3":
                    manager.searchRecipe();
                    break;
                case "4":
                    System.out.println("👋 Exiting... Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("❌ Invalid choice! Try again.");
            }
        }
    }
}
