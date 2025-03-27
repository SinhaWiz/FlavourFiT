import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class DietSuggestions implements HealthFeature {
    private InputHandler inputHandler;
    private List<String> suggestions;
    public DietSuggestions(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.suggestions = new ArrayList<>();
        initializeSuggestions();
    }

    public DietSuggestions() {
        this.suggestions = new ArrayList<>();
        initializeSuggestions();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== DIET CHANGE SUGGESTIONS ===");

        displayRandomSuggestions(5);

        System.out.println("\nPress Enter to return to the main menu...");
        inputHandler.waitForEnter();
    }

    private void initializeSuggestions() {
        suggestions.add("Did you know that if you do not like cottage cheese, you can add peanut butter as a protein source?");
        suggestions.add("Did you know you can reduce the fat content, if you skip the butter and only use the egg whites?");
        suggestions.add("Did you know, you can add any leftover you have? Peppers, tomatoes, mushrooms, potatoes...");
        suggestions.add("Try replacing white rice with brown rice or quinoa for more fiber and nutrients.");
        suggestions.add("Swap regular pasta for whole grain or legume-based pasta for more protein and fiber.");
        suggestions.add("Use Greek yogurt instead of sour cream for a higher protein, lower fat alternative.");
        suggestions.add("Replace sugary breakfast cereals with oatmeal topped with fresh fruit and nuts.");
        suggestions.add("Try using avocado instead of mayonnaise as a sandwich spread for healthy fats.");
        suggestions.add("Snack on a handful of nuts instead of chips for a more nutritious option.");
        suggestions.add("Use herbs and spices to flavor food instead of salt to reduce sodium intake.");
        suggestions.add("Replace soda with sparkling water infused with fresh fruit for a healthier beverage.");
        suggestions.add("Try meatless Monday - replace meat with beans, lentils, or tofu once a week.");
        suggestions.add("Use olive oil or avocado oil instead of butter for cooking and baking.");
        suggestions.add("Add leafy greens to smoothies for an extra nutrient boost without changing the taste much.");
        suggestions.add("Replace cream-based soups with broth-based ones for fewer calories and less saturated fat.");
        suggestions.add("Try using natural sweeteners like honey or maple syrup instead of refined sugar.");
        suggestions.add("Incorporate fermented foods like kimchi, sauerkraut, or kefir for gut health benefits.");
        suggestions.add("Replace white bread with whole grain bread for more fiber and nutrients.");
        suggestions.add("Try making your own salad dressing with olive oil and vinegar instead of store-bought options.");
        suggestions.add("Add beans or lentils to salads and soups for extra protein and fiber.");
        suggestions.add("Swap beef for lean ground turkey in recipes like burgers, meatballs, or chili.");
        suggestions.add("Try using lettuce wraps instead of tortillas for a lower-carb option.");
        suggestions.add("Replace ice cream with frozen yogurt or fruit sorbet for a lighter dessert.");
        suggestions.add("Use cauliflower rice as a substitute for white rice in some meals.");
        suggestions.add("Try plant-based milk alternatives like almond, oat, or soy milk instead of whole milk.");
        suggestions.add("Incorporate more fatty fish like salmon or mackerel for heart-healthy omega-3 fatty acids.");
        suggestions.add("Replace croutons in salads with nuts or seeds for healthier crunch.");
        suggestions.add("Try using pureed fruit as a natural sweetener in baking instead of sugar.");
        suggestions.add("Replace cream in coffee with cinnamon or vanilla extract for flavor without calories.");
        suggestions.add("Use spiralized vegetables as a substitute for pasta in some meals.");
    }

    public void displayRandomSuggestions(int count) {
        if (count <= 0 || count > suggestions.size()) {
            count = 5;
        }

        List<String> shuffledSuggestions = new ArrayList<>(suggestions);
        Collections.shuffle(shuffledSuggestions);

        System.out.println("Here are some healthy diet change suggestions:");
        for (int i = 0; i < count; i++) {
            System.out.println("\n" + (i + 1) + ". " + shuffledSuggestions.get(i));
        }
    }

    public List<String> getAllSuggestions() {
        return new ArrayList<>(suggestions);
    }
} 