import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class RecipeManager implements HealthFeature {
    private InputHandler inputHandler;
    private List<String> healthyIngredients;
    private Map<Integer, Recipe> recipes;
    public RecipeManager(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
        this.healthyIngredients = new ArrayList<>();
        this.recipes = new HashMap<>();
        initializeHealthyIngredients();
        initializeRecipes();
    }

    public RecipeManager() {
        this.healthyIngredients = new ArrayList<>();
        this.recipes = new HashMap<>();
        initializeHealthyIngredients();
        initializeRecipes();
    }
    @Override
    public void displayMenu() {
        System.out.println("\n=== HEALTHY COOKING ===");
        System.out.println("1. View Healthy Cooking Ingredients");
        System.out.println("2. Browse Recipes");
        System.out.print("Enter your choice: ");

        int choice = inputHandler.getUserChoice(1, 2);

        if (choice == 1) {
            displayHealthyIngredients();
        } else {
            displayRecipeMenu();
            System.out.print("Enter recipe number (1-" + recipes.size() + "): ");
            int recipeChoice = inputHandler.getUserChoice(1, recipes.size());
            displayRecipe(recipeChoice);
        }

        System.out.println("\nPress Enter to return to the main menu...");
        inputHandler.waitForEnter();
    }
    private void initializeHealthyIngredients() {
        healthyIngredients.add("Olive oil - Rich in monounsaturated fats and antioxidants");
        healthyIngredients.add("Avocado oil - High smoke point and heart-healthy fats");
        healthyIngredients.add("Coconut oil - Contains medium-chain triglycerides");
        healthyIngredients.add("Quinoa - Complete protein with all essential amino acids");
        healthyIngredients.add("Brown rice - Whole grain with more fiber than white rice");
        healthyIngredients.add("Oats - High in soluble fiber that helps lower cholesterol");
        healthyIngredients.add("Chia seeds - Rich in omega-3 fatty acids and fiber");
        healthyIngredients.add("Flaxseeds - Excellent source of omega-3 fatty acids and lignans");
        healthyIngredients.add("Nuts (almonds, walnuts, cashews) - Healthy fats and protein");
        healthyIngredients.add("Greek yogurt - High protein, probiotic-rich dairy option");
        healthyIngredients.add("Eggs - Complete protein source with essential nutrients");
        healthyIngredients.add("Leafy greens (spinach, kale, Swiss chard) - Packed with vitamins and minerals");
        healthyIngredients.add("Berries (blueberries, strawberries, raspberries) - High in antioxidants");
        healthyIngredients.add("Garlic - Contains allicin, which has antimicrobial properties");
        healthyIngredients.add("Ginger - Anti-inflammatory and digestive aid");
        healthyIngredients.add("Turmeric - Contains curcumin, a powerful anti-inflammatory compound");
        healthyIngredients.add("Cinnamon - May help regulate blood sugar");
        healthyIngredients.add("Legumes (beans, lentils, chickpeas) - High in protein and fiber");
        healthyIngredients.add("Sweet potatoes - Rich in beta-carotene and fiber");
        healthyIngredients.add("Salmon - Excellent source of omega-3 fatty acids");
    }

    private void initializeRecipes() {
        addRecipe(1, "Overnight Oats",
                "A simple, nutritious breakfast that you prepare the night before.",
                new String[] {
                        "1/2 cup rolled oats",
                        "1/2 cup milk of choice (dairy or plant-based)",
                        "1/4 cup Greek yogurt",
                        "1 tablespoon chia seeds",
                        "1 tablespoon honey or maple syrup (optional)",
                        "1/4 teaspoon vanilla extract",
                        "Pinch of salt",
                        "Toppings: fresh fruit, nuts, seeds, etc."
                },
                new String[] {
                        "1. In a jar or container, combine oats, milk, yogurt, chia seeds, sweetener (if using), vanilla, and salt.",
                        "2. Stir well to combine.",
                        "3. Cover and refrigerate overnight or for at least 4 hours.",
                        "4. In the morning, add your favorite toppings and enjoy cold or warm it up if preferred."
                }
        );

        addRecipe(2, "Greek Salad",
                "A refreshing Mediterranean salad packed with vegetables and feta cheese.",
                new String[] {
                        "1 cucumber, diced",
                        "2 large tomatoes, diced",
                        "1 red onion, thinly sliced",
                        "1 bell pepper, diced",
                        "1/2 cup Kalamata olives",
                        "200g feta cheese, cubed",
                        "2 tablespoons extra virgin olive oil",
                        "1 tablespoon red wine vinegar",
                        "1 teaspoon dried oregano",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. In a large bowl, combine cucumber, tomatoes, red onion, bell pepper, and olives.",
                        "2. In a small bowl, whisk together olive oil, red wine vinegar, oregano, salt, and pepper.",
                        "3. Pour the dressing over the vegetables and toss gently to combine.",
                        "4. Add the feta cheese and toss lightly.",
                        "5. Serve immediately or refrigerate for up to 1 hour before serving."
                }
        );

        addRecipe(3, "Baked Salmon with Lemon and Herbs",
                "A simple, healthy way to prepare salmon with bright flavors.",
                new String[] {
                        "4 salmon fillets (about 150g each)",
                        "2 tablespoons olive oil",
                        "2 cloves garlic, minced",
                        "1 lemon, thinly sliced",
                        "2 tablespoons fresh dill, chopped",
                        "2 tablespoons fresh parsley, chopped",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 375°F (190°C).",
                        "2. Place salmon fillets on a baking sheet lined with parchment paper.",
                        "3. Brush salmon with olive oil and sprinkle with minced garlic.",
                        "4. Season with salt and pepper.",
                        "5. Place lemon slices on top of each fillet.",
                        "6. Sprinkle with fresh herbs.",
                        "7. Bake for 12-15 minutes, until salmon flakes easily with a fork.",
                        "8. Serve immediately with additional lemon wedges if desired."
                }
        );
        addRecipe(4, "Quinoa Vegetable Bowl",
                "A nutritious bowl packed with protein and vegetables.",
                new String[] {
                        "1 cup quinoa, rinsed",
                        "2 cups vegetable broth",
                        "1 cup cherry tomatoes, halved",
                        "1 cucumber, diced",
                        "1 avocado, sliced",
                        "1/2 red onion, finely chopped",
                        "1/4 cup fresh cilantro, chopped",
                        "2 tablespoons olive oil",
                        "1 tablespoon lemon juice",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Cook quinoa in vegetable broth according to package instructions.",
                        "2. Let quinoa cool to room temperature.",
                        "3. In a large bowl, combine quinoa, tomatoes, cucumber, avocado, and red onion.",
                        "4. In a small bowl, whisk together olive oil, lemon juice, salt, and pepper.",
                        "5. Pour dressing over the quinoa mixture and toss gently.",
                        "6. Garnish with fresh cilantro before serving."
                }
        );

        addRecipe(5, "Vegetable Stir-Fry",
                "A quick and colorful stir-fry loaded with vegetables and tofu.",
                new String[] {
                        "1 block (400g) firm tofu, cubed",
                        "2 tablespoons vegetable oil",
                        "2 cloves garlic, minced",
                        "1 tablespoon ginger, grated",
                        "1 bell pepper, sliced",
                        "1 carrot, julienned",
                        "1 cup broccoli florets",
                        "1 cup snap peas",
                        "2 tablespoons soy sauce",
                        "1 tablespoon sesame oil",
                        "1 teaspoon honey or maple syrup",
                        "Sesame seeds for garnish"
                },
                new String[] {
                        "1. Press tofu between paper towels to remove excess moisture.",
                        "2. Heat vegetable oil in a large wok or skillet over medium-high heat.",
                        "3. Add tofu and cook until golden brown on all sides, about 5 minutes.",
                        "4. Add garlic and ginger, stir for 30 seconds until fragrant.",
                        "5. Add bell pepper, carrot, broccoli, and snap peas. Stir-fry for 3-4 minutes.",
                        "6. In a small bowl, mix soy sauce, sesame oil, and honey.",
                        "7. Pour sauce over the vegetables and tofu, toss to coat.",
                        "8. Cook for another 2 minutes until vegetables are tender-crisp.",
                        "9. Garnish with sesame seeds before serving."
                }
        );

        addRecipe(6, "Mediterranean Chickpea Salad",
                "A protein-rich salad with Mediterranean flavors.",
                new String[] {
                        "2 cans (15oz each) chickpeas, drained and rinsed",
                        "1 cucumber, diced",
                        "1 cup cherry tomatoes, halved",
                        "1/2 red onion, finely chopped",
                        "1/2 cup Kalamata olives, pitted and halved",
                        "1/2 cup feta cheese, crumbled",
                        "1/4 cup fresh parsley, chopped",
                        "3 tablespoons olive oil",
                        "2 tablespoons lemon juice",
                        "1 teaspoon dried oregano",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. In a large bowl, combine chickpeas, cucumber, tomatoes, red onion, and olives.",
                        "2. In a small bowl, whisk together olive oil, lemon juice, oregano, salt, and pepper.",
                        "3. Pour dressing over the salad and toss gently to combine.",
                        "4. Add feta cheese and parsley, toss lightly.",
                        "5. Refrigerate for at least 30 minutes before serving to allow flavors to meld."
                }
        );

        addRecipe(7, "Overnight Oats with Berries",
                "A make-ahead breakfast that's both nutritious and delicious.",
                new String[] {
                        "1/2 cup rolled oats",
                        "1/2 cup milk (dairy or plant-based)",
                        "1/4 cup Greek yogurt",
                        "1 tablespoon chia seeds",
                        "1 tablespoon honey or maple syrup",
                        "1/2 teaspoon vanilla extract",
                        "1/2 cup mixed berries (strawberries, blueberries, raspberries)",
                        "1 tablespoon sliced almonds"
                },
                new String[] {
                        "1. In a jar or container, combine oats, milk, yogurt, chia seeds, honey, and vanilla.",
                        "2. Stir well to combine.",
                        "3. Cover and refrigerate overnight or for at least 4 hours.",
                        "4. Before serving, top with mixed berries and sliced almonds."
                }
        );

        addRecipe(8, "Lentil Soup",
                "A hearty, protein-rich soup that's perfect for cold days.",
                new String[] {
                        "1 cup dried lentils, rinsed",
                        "1 tablespoon olive oil",
                        "1 onion, diced",
                        "2 carrots, diced",
                        "2 celery stalks, diced",
                        "3 cloves garlic, minced",
                        "1 teaspoon ground cumin",
                        "1/2 teaspoon ground coriander",
                        "1/4 teaspoon red pepper flakes",
                        "4 cups vegetable broth",
                        "1 can (14oz) diced tomatoes",
                        "2 cups fresh spinach",
                        "1 tablespoon lemon juice",
                        "Salt and pepper to taste",
                        "Fresh parsley for garnish"
                },
                new String[] {
                        "1. Heat olive oil in a large pot over medium heat.",
                        "2. Add onion, carrots, and celery. Cook until softened, about 5 minutes.",
                        "3. Add garlic, cumin, coriander, and red pepper flakes. Cook for 1 minute until fragrant.",
                        "4. Add lentils, vegetable broth, and diced tomatoes. Bring to a boil.",
                        "5. Reduce heat, cover, and simmer for 25-30 minutes until lentils are tender.",
                        "6. Stir in spinach and lemon juice. Cook for another 2-3 minutes until spinach wilts.",
                        "7. Season with salt and pepper to taste.",
                        "8. Garnish with fresh parsley before serving."
                }
        );

        addRecipe(9, "Stuffed Bell Peppers",
                "Colorful bell peppers stuffed with a flavorful quinoa mixture.",
                new String[] {
                        "4 large bell peppers (any color), halved and seeds removed",
                        "1 cup quinoa, rinsed",
                        "2 cups vegetable broth",
                        "1 tablespoon olive oil",
                        "1 onion, diced",
                        "2 cloves garlic, minced",
                        "1 zucchini, diced",
                        "1 cup mushrooms, chopped",
                        "1 can (15oz) black beans, drained and rinsed",
                        "1 cup corn kernels (fresh or frozen)",
                        "1 teaspoon ground cumin",
                        "1 teaspoon chili powder",
                        "1/2 cup fresh cilantro, chopped",
                        "1 cup shredded cheese (optional)",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 375°F (190°C).",
                        "2. Cook quinoa in vegetable broth according to package instructions.",
                        "3. In a large skillet, heat olive oil over medium heat.",
                        "4. Add onion and garlic, cook until softened, about 3 minutes.",
                        "5. Add zucchini and mushrooms, cook for another 5 minutes.",
                        "6. Stir in black beans, corn, cumin, and chili powder.",
                        "7. Add cooked quinoa to the skillet and mix well. Season with salt and pepper.",
                        "8. Stir in cilantro and remove from heat.",
                        "9. Arrange bell pepper halves in a baking dish, cut side up.",
                        "10. Fill each pepper half with the quinoa mixture.",
                        "11. If using cheese, sprinkle on top of each stuffed pepper.",
                        "12. Cover with foil and bake for 30 minutes.",
                        "13. Remove foil and bake for another 10 minutes until peppers are tender."
                }
        );

        addRecipe(10, "Berry Smoothie Bowl",
                "A nutritious breakfast bowl topped with fresh fruits and nuts.",
                new String[] {
                        "1 cup mixed frozen berries",
                        "1 frozen banana",
                        "1/2 cup Greek yogurt",
                        "1/4 cup milk (dairy or plant-based)",
                        "1 tablespoon honey or maple syrup",
                        "Toppings: fresh berries, sliced banana, granola, chia seeds, sliced almonds"
                },
                new String[] {
                        "1. In a blender, combine frozen berries, frozen banana, Greek yogurt, milk, and honey.",
                        "2. Blend until smooth and creamy. The mixture should be thick enough to eat with a spoon.",
                        "3. Pour into a bowl.",
                        "4. Arrange toppings over the smoothie base.",
                        "5. Serve immediately."
                }
        );

        addRecipe(11, "Roasted Vegetable and Hummus Wrap",
                "A satisfying wrap filled with roasted vegetables and creamy hummus.",
                new String[] {
                        "1 zucchini, sliced",
                        "1 bell pepper, sliced",
                        "1 red onion, sliced",
                        "1 tablespoon olive oil",
                        "1 teaspoon dried oregano",
                        "4 whole grain wraps or tortillas",
                        "1 cup hummus",
                        "2 cups fresh spinach",
                        "1/4 cup feta cheese, crumbled (optional)",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 425°F (220°C).",
                        "2. Toss zucchini, bell pepper, and red onion with olive oil, oregano, salt, and pepper.",
                        "3. Spread vegetables on a baking sheet in a single layer.",
                        "4. Roast for 20-25 minutes, stirring halfway through, until vegetables are tender and slightly caramelized.",
                        "5. Warm the wraps according to package instructions.",
                        "6. Spread hummus on each wrap.",
                        "7. Top with spinach, roasted vegetables, and feta cheese if using.",
                        "8. Fold in the sides and roll up tightly.",
                        "9. Cut in half and serve."
                }
        );

        addRecipe(12, "Cauliflower Fried Rice",
                "A low-carb alternative to traditional fried rice using cauliflower.",
                new String[] {
                        "1 medium cauliflower head, riced",
                        "2 tablespoons vegetable oil",
                        "2 eggs, beaten",
                        "1 onion, diced",
                        "2 carrots, diced",
                        "1 cup frozen peas",
                        "3 cloves garlic, minced",
                        "1 tablespoon ginger, grated",
                        "3 tablespoons soy sauce",
                        "1 tablespoon sesame oil",
                        "2 green onions, sliced",
                        "1/4 cup cashews or peanuts (optional)"
                },
                new String[] {
                        "1. To make cauliflower rice, pulse cauliflower florets in a food processor until they resemble rice grains.",
                        "2. Heat 1 tablespoon of oil in a large skillet or wok over medium heat.",
                        "3. Add beaten eggs and scramble until cooked through. Remove and set aside.",
                        "4. Add remaining oil to the skillet. Add onion and carrots, cook for 3-4 minutes.",
                        "5. Add garlic and ginger, cook for 30 seconds until fragrant.",
                        "6. Add cauliflower rice and peas. Cook for 5-6 minutes until cauliflower is tender.",
                        "7. Stir in soy sauce and sesame oil.",
                        "8. Add scrambled eggs back to the skillet and mix well.",
                        "9. Garnish with green onions and nuts if using before serving."
                }
        );

        addRecipe(13, "Avocado Toast with Poached Egg",
                "A simple yet nutritious breakfast or lunch option.",
                new String[] {
                        "2 slices whole grain bread",
                        "1 ripe avocado",
                        "2 eggs",
                        "1 tablespoon white vinegar",
                        "1/2 teaspoon red pepper flakes",
                        "1 tablespoon fresh lemon juice",
                        "Salt and pepper to taste",
                        "Fresh herbs (such as cilantro or parsley) for garnish"
                },
                new String[] {
                        "1. Toast the bread slices until golden brown.",
                        "2. In a small bowl, mash the avocado with lemon juice, salt, and pepper.",
                        "3. Spread the mashed avocado on the toast slices.",
                        "4. To poach the eggs, bring a pot of water to a gentle simmer and add vinegar.",
                        "5. Create a whirlpool in the water with a spoon, then carefully crack an egg into the center.",
                        "6. Cook for 3-4 minutes for a runny yolk, then remove with a slotted spoon.",
                        "7. Place a poached egg on each avocado toast.",
                        "8. Sprinkle with red pepper flakes and fresh herbs.",
                        "9. Season with additional salt and pepper if desired."
                }
        );

        addRecipe(14, "Sweet Potato and Black Bean Chili",
                "A hearty vegetarian chili that's full of flavor and nutrition.",
                new String[] {
                        "2 tablespoons olive oil",
                        "1 onion, diced",
                        "2 bell peppers, diced",
                        "3 cloves garlic, minced",
                        "2 sweet potatoes, peeled and diced",
                        "2 tablespoons chili powder",
                        "1 tablespoon ground cumin",
                        "1 teaspoon smoked paprika",
                        "1/4 teaspoon cayenne pepper (optional)",
                        "2 cans (15oz each) black beans, drained and rinsed",
                        "1 can (28oz) diced tomatoes",
                        "2 cups vegetable broth",
                        "1 cup corn kernels (fresh or frozen)",
                        "1/4 cup fresh cilantro, chopped",
                        "Juice of 1 lime",
                        "Salt and pepper to taste",
                        "Optional toppings: avocado, Greek yogurt, shredded cheese"
                },
                new String[] {
                        "1. Heat olive oil in a large pot over medium heat.",
                        "2. Add onion and bell peppers, cook until softened, about 5 minutes.",
                        "3. Add garlic and cook for 30 seconds until fragrant.",
                        "4. Add sweet potatoes, chili powder, cumin, smoked paprika, and cayenne if using. Stir to coat.",
                        "5. Add black beans, diced tomatoes, and vegetable broth. Bring to a boil.",
                        "6. Reduce heat, cover, and simmer for 20-25 minutes until sweet potatoes are tender.",
                        "7. Stir in corn and cook for another 5 minutes.",
                        "8. Add lime juice and cilantro. Season with salt and pepper to taste.",
                        "9. Serve with optional toppings."
                }
        );

        addRecipe(15, "Spinach and Feta Stuffed Chicken Breast",
                "Juicy chicken breasts stuffed with a flavorful spinach and feta mixture.",
                new String[] {
                        "4 boneless, skinless chicken breasts",
                        "2 cups fresh spinach, chopped",
                        "1/2 cup feta cheese, crumbled",
                        "2 cloves garlic, minced",
                        "2 tablespoons olive oil",
                        "1 teaspoon dried oregano",
                        "1/2 teaspoon dried thyme",
                        "1 lemon, zested and juiced",
                        "Salt and pepper to taste",
                        "Toothpicks for securing"
                },
                new String[] {
                        "1. Preheat oven to 375°F (190°C).",
                        "2. In a bowl, mix spinach, feta cheese, garlic, lemon zest, oregano, and thyme.",
                        "3. Cut a pocket into each chicken breast, being careful not to cut all the way through.",
                        "4. Stuff each chicken breast with the spinach and feta mixture.",
                        "5. Secure with toothpicks if needed.",
                        "6. Season chicken with salt and pepper.",
                        "7. Heat olive oil in an oven-safe skillet over medium-high heat.",
                        "8. Sear chicken breasts for 3-4 minutes on each side until golden brown.",
                        "9. Drizzle with lemon juice.",
                        "10. Transfer skillet to the oven and bake for 15-20 minutes until chicken is cooked through.",
                        "11. Remove toothpicks before serving."
                }
        );

        addRecipe(16, "Mango and Chickpea Curry",
                "A sweet and spicy curry that combines fruit and protein.",
                new String[] {
                        "2 tablespoons coconut oil",
                        "1 onion, diced",
                        "3 cloves garlic, minced",
                        "1 tablespoon ginger, grated",
                        "2 tablespoons curry powder",
                        "1 teaspoon ground turmeric",
                        "1/2 teaspoon ground coriander",
                        "1/4 teaspoon cayenne pepper (adjust to taste)",
                        "2 cans (15oz each) chickpeas, drained and rinsed",
                        "1 can (14oz) coconut milk",
                        "2 ripe mangoes, peeled and diced",
                        "1 cup vegetable broth",
                        "2 tablespoons tomato paste",
                        "1 tablespoon lime juice",
                        "1/4 cup fresh cilantro, chopped",
                        "Salt to taste"
                },
                new String[] {
                        "1. Heat coconut oil in a large pot over medium heat.",
                        "2. Add onion and cook until softened, about 5 minutes.",
                        "3. Add garlic and ginger, cook for 30 seconds until fragrant.",
                        "4. Add curry powder, turmeric, coriander, and cayenne. Stir for 1 minute.",
                        "5. Add chickpeas, coconut milk, one diced mango, vegetable broth, and tomato paste.",
                        "6. Bring to a simmer and cook for 15-20 minutes, stirring occasionally.",
                        "7. Add the remaining diced mango and lime juice. Cook for another 5 minutes.",
                        "8. Season with salt to taste.",
                        "9. Garnish with fresh cilantro before serving.",
                        "10. Serve over rice or with naan bread."
                }
        );

        addRecipe(17, "Zucchini Noodles with Pesto",
                "A light and fresh alternative to traditional pasta.",
                new String[] {
                        "4 medium zucchini",
                        "2 cups fresh basil leaves",
                        "1/3 cup pine nuts",
                        "2 cloves garlic",
                        "1/2 cup grated Parmesan cheese",
                        "1/2 cup olive oil",
                        "1 tablespoon lemon juice",
                        "1 cup cherry tomatoes, halved",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Using a spiralizer, turn the zucchini into noodles (zoodles).",
                        "2. Place zoodles on paper towels and sprinkle with salt. Let sit for 10 minutes to draw out moisture.",
                        "3. Meanwhile, make the pesto by combining basil, pine nuts, garlic, and Parmesan in a food processor.",
                        "4. With the processor running, slowly add olive oil until smooth.",
                        "5. Stir in lemon juice, salt, and pepper.",
                        "6. Pat zoodles dry with paper towels.",
                        "7. In a large skillet, heat 1 tablespoon of olive oil over medium heat.",
                        "8. Add zoodles and cook for 2-3 minutes until just tender but still crisp.",
                        "9. Remove from heat and toss with pesto sauce.",
                        "10. Add cherry tomatoes and toss gently.",
                        "11. Serve immediately with additional Parmesan cheese if desired."
                }
        );

        addRecipe(18, "Baked Oatmeal with Apples and Cinnamon",
                "A warm and comforting breakfast that can be made ahead.",
                new String[] {
                        "2 cups rolled oats",
                        "1/2 cup chopped walnuts or pecans",
                        "1/3 cup maple syrup or honey",
                        "1 teaspoon baking powder",
                        "1 1/2 teaspoons ground cinnamon",
                        "1/2 teaspoon salt",
                        "2 cups milk (dairy or plant-based)",
                        "1 large egg",
                        "2 tablespoons melted butter or coconut oil",
                        "2 teaspoons vanilla extract",
                        "2 apples, peeled and diced",
                        "1/4 cup raisins or dried cranberries (optional)"
                },
                new String[] {
                        "1. Preheat oven to 350°F (175°C). Grease a 9-inch square baking dish.",
                        "2. In a large bowl, mix oats, half the nuts, baking powder, cinnamon, and salt.",
                        "3. In another bowl, whisk together milk, egg, maple syrup, butter, and vanilla.",
                        "4. Arrange diced apples in the bottom of the baking dish.",
                        "5. Pour the oat mixture over the apples.",
                        "6. Pour the milk mixture over the oats, making sure all oats are moistened.",
                        "7. Sprinkle with remaining nuts and dried fruit if using.",
                        "8. Bake for 40-45 minutes until the top is golden and the oatmeal is set.",
                        "9. Let cool for 5 minutes before serving.",
                        "10. Can be refrigerated and reheated for breakfast throughout the week."
                }
        );

        addRecipe(19, "Roasted Vegetable and Quinoa Bowl",
                "A nutritious bowl packed with roasted vegetables and protein-rich quinoa.",
                new String[] {
                        "1 cup quinoa, rinsed",
                        "2 cups vegetable broth",
                        "1 sweet potato, diced",
                        "1 bell pepper, sliced",
                        "1 zucchini, sliced",
                        "1 red onion, sliced",
                        "2 tablespoons olive oil",
                        "1 teaspoon dried thyme",
                        "1 teaspoon dried rosemary",
                        "1 can (15oz) chickpeas, drained and rinsed",
                        "2 cups kale, chopped",
                        "1/4 cup tahini",
                        "2 tablespoons lemon juice",
                        "1 tablespoon maple syrup",
                        "2 tablespoons water",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 425°F (220°C).",
                        "2. Cook quinoa in vegetable broth according to package instructions.",
                        "3. Toss sweet potato, bell pepper, zucchini, and red onion with olive oil, thyme, rosemary, salt, and pepper.",
                        "4. Spread vegetables on a baking sheet in a single layer.",
                        "5. Roast for 20-25 minutes, stirring halfway through, until vegetables are tender and caramelized.",
                        "6. In a small bowl, whisk together tahini, lemon juice, maple syrup, water, salt, and pepper to make the dressing.",
                        "7. In a large bowl, massage kale with a small amount of olive oil and salt until softened.",
                        "8. To assemble bowls, start with a base of quinoa, add roasted vegetables, chickpeas, and kale.",
                        "9. Drizzle with tahini dressing before serving."
                }
        );

        addRecipe(20, "Grilled Fish Tacos with Avocado Salsa",
                "Fresh and flavorful tacos with grilled fish and a zesty avocado salsa.",
                new String[] {
                        "1 pound white fish fillets (such as tilapia or cod)",
                        "2 tablespoons olive oil",
                        "1 tablespoon lime juice",
                        "1 teaspoon chili powder",
                        "1/2 teaspoon ground cumin",
                        "1/2 teaspoon garlic powder",
                        "8 small corn tortillas",
                        "2 avocados, diced",
                        "1 cup cherry tomatoes, quartered",
                        "1/4 cup red onion, finely diced",
                        "1/4 cup fresh cilantro, chopped",
                        "1 jalapeño, seeded and minced (optional)",
                        "2 tablespoons lime juice",
                        "Salt and pepper to taste",
                        "Lime wedges for serving"
                },
                new String[] {
                        "1. In a shallow dish, mix olive oil, lime juice, chili powder, cumin, garlic powder, salt, and pepper.",
                        "2. Add fish fillets and coat with the marinade. Let sit for 15 minutes.",
                        "3. Meanwhile, make the avocado salsa by combining avocados, cherry tomatoes, red onion, cilantro, jalapeño if using, lime juice, salt, and pepper in a bowl.",
                        "4. Preheat grill or grill pan to medium-high heat.",
                        "5. Grill fish for 3-4 minutes per side until cooked through and flakes easily with a fork.",
                        "6. Warm tortillas on the grill for about 30 seconds per side.",
                        "7. Break fish into chunks and divide among tortillas.",
                        "8. Top with avocado salsa and serve with lime wedges."
                }
        );

        addRecipe(21, "Mushroom and Spinach Frittata",
                "A versatile egg dish that's perfect for breakfast, lunch, or dinner.",
                new String[] {
                        "8 large eggs",
                        "1/4 cup milk",
                        "1/2 cup grated Parmesan cheese",
                        "2 tablespoons olive oil",
                        "1 onion, diced",
                        "2 cloves garlic, minced",
                        "8 oz mushrooms, sliced",
                        "4 cups fresh spinach",
                        "1/4 cup fresh herbs (such as parsley, basil, or chives), chopped",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 375°F (190°C).",
                        "2. In a bowl, whisk together eggs, milk, half the Parmesan cheese, salt, and pepper.",
                        "3. Heat olive oil in an oven-safe skillet over medium heat.",
                        "4. Add onion and cook until softened, about 5 minutes.",
                        "5. Add garlic and mushrooms, cook until mushrooms are golden, about 5-7 minutes.",
                        "6. Add spinach and cook until wilted, about 2 minutes.",
                        "7. Pour the egg mixture over the vegetables in the skillet.",
                        "8. Cook for 3-4 minutes until the edges start to set.",
                        "9. Sprinkle with remaining Parmesan cheese.",
                        "10. Transfer skillet to the oven and bake for 12-15 minutes until the frittata is set and golden on top.",
                        "11. Let cool for 5 minutes before slicing.",
                        "12. Garnish with fresh herbs before serving."
                }
        );

        addRecipe(22, "Lemon Herb Roasted Chicken with Vegetables",
                "A classic one-pan meal with roasted chicken and seasonal vegetables.",
                new String[] {
                        "1 whole chicken (about 4-5 pounds)",
                        "2 lemons, one zested and juiced, one quartered",
                        "3 tablespoons olive oil",
                        "4 cloves garlic, minced",
                        "2 tablespoons fresh rosemary, chopped",
                        "2 tablespoons fresh thyme, chopped",
                        "1 tablespoon fresh sage, chopped",
                        "1 teaspoon salt",
                        "1/2 teaspoon black pepper",
                        "1 pound baby potatoes, halved",
                        "4 carrots, peeled and cut into chunks",
                        "2 onions, quartered",
                        "1 cup chicken broth"
                },
                new String[] {
                        "1. Preheat oven to 425°F (220°C).",
                        "2. In a small bowl, mix lemon zest, lemon juice, olive oil, garlic, herbs, salt, and pepper.",
                        "3. Pat chicken dry with paper towels.",
                        "4. Rub the herb mixture all over the chicken, including under the skin.",
                        "5. Place quartered lemon inside the chicken cavity.",
                        "6. In a large roasting pan, arrange potatoes, carrots, and onions.",
                        "7. Place chicken on top of the vegetables.",
                        "8. Pour chicken broth into the bottom of the pan.",
                        "9. Roast for 1 hour and 15 minutes, or until chicken reaches an internal temperature of 165°F (74°C) and vegetables are tender.",
                        "10. Let chicken rest for 10-15 minutes before carving.",
                        "11. Serve chicken with roasted vegetables and pan juices."
                }
        );

        addRecipe(23, "Vegetable and Bean Soup",
                "A hearty and nutritious soup packed with vegetables and beans.",
                new String[] {
                        "2 tablespoons olive oil",
                        "1 onion, diced",
                        "2 carrots, diced",
                        "2 celery stalks, diced",
                        "3 cloves garlic, minced",
                        "1 zucchini, diced",
                        "1 can (14oz) diced tomatoes",
                        "1 can (15oz) kidney beans, drained and rinsed",
                        "1 can (15oz) cannellini beans, drained and rinsed",
                        "6 cups vegetable broth",
                        "1 bay leaf",
                        "1 teaspoon dried oregano",
                        "1 teaspoon dried thyme",
                        "2 cups chopped kale or spinach",
                        "Salt and pepper to taste",
                        "2 tablespoons fresh parsley, chopped",
                        "1 tablespoon lemon juice",
                        "Grated Parmesan cheese for serving (optional)"
                },
                new String[] {
                        "1. Heat olive oil in a large pot over medium heat.",
                        "2. Add onion, carrots, and celery. Cook for 5 minutes until softened.",
                        "3. Add garlic and cook for another minute until fragrant.",
                        "4. Add zucchini, diced tomatoes, beans, vegetable broth, bay leaf, oregano, and thyme.",
                        "5. Bring to a boil, then reduce heat and simmer for 20 minutes.",
                        "6. Add kale or spinach and cook for another 5 minutes until wilted.",
                        "7. Stir in lemon juice and parsley.",
                        "8. Season with salt and pepper to taste.",
                        "9. Serve hot, topped with grated Parmesan cheese if desired."
                }
        );
        addRecipe(24, "Quinoa Stuffed Bell Peppers",
                "Colorful bell peppers stuffed with protein-rich quinoa and vegetables.",
                new String[] {
                        "4 large bell peppers (any color), halved and seeds removed",
                        "1 cup quinoa, rinsed",
                        "2 cups vegetable broth",
                        "1 tablespoon olive oil",
                        "1 onion, diced",
                        "2 cloves garlic, minced",
                        "1 zucchini, diced",
                        "1 cup mushrooms, chopped",
                        "1 can (15oz) black beans, drained and rinsed",
                        "1 cup corn kernels (fresh or frozen)",
                        "1 teaspoon cumin",
                        "1 teaspoon chili powder",
                        "1/2 teaspoon paprika",
                        "1/4 cup fresh cilantro, chopped",
                        "1 cup shredded cheese (cheddar or Mexican blend)",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat oven to 375°F (190°C).",
                        "2. Cook quinoa in vegetable broth according to package instructions.",
                        "3. Heat olive oil in a large skillet over medium heat.",
                        "4. Add onion and cook until translucent, about 3 minutes.",
                        "5. Add garlic and cook for another minute.",
                        "6. Add zucchini and mushrooms, cook for 5 minutes until softened.",
                        "7. Stir in black beans, corn, cumin, chili powder, and paprika.",
                        "8. Add cooked quinoa to the vegetable mixture and combine well.",
                        "9. Stir in cilantro and season with salt and pepper.",
                        "10. Arrange bell pepper halves in a baking dish, cut side up.",
                        "11. Fill each pepper half with the quinoa mixture.",
                        "12. Sprinkle cheese on top of each stuffed pepper.",
                        "13. Cover with foil and bake for 25 minutes.",
                        "14. Remove foil and bake for another 10 minutes until peppers are tender and cheese is golden.",
                        "15. Serve hot, garnished with additional cilantro if desired."
                }
        );

        addRecipe(25, "Lentil and Sweet Potato Curry",
                "A hearty, plant-based curry rich in protein and fiber.",
                new String[] {
                        "2 tablespoons coconut oil",
                        "1 large onion, diced",
                        "3 cloves garlic, minced",
                        "1 tablespoon fresh ginger, grated",
                        "2 tablespoons curry powder",
                        "1 teaspoon ground cumin",
                        "1 teaspoon ground coriander",
                        "1/2 teaspoon turmeric",
                        "1/4 teaspoon cayenne pepper (optional)",
                        "2 medium sweet potatoes, peeled and cubed",
                        "1 cup red lentils, rinsed",
                        "1 can (14oz) diced tomatoes",
                        "4 cups vegetable broth",
                        "1 can (14oz) coconut milk",
                        "2 cups fresh spinach",
                        "Juice of 1 lime",
                        "1/4 cup fresh cilantro, chopped",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Heat coconut oil in a large pot over medium heat.",
                        "2. Add onion and cook until softened, about 5 minutes.",
                        "3. Add garlic and ginger, cook for 1 minute until fragrant.",
                        "4. Stir in curry powder, cumin, coriander, turmeric, and cayenne pepper if using.",
                        "5. Add sweet potatoes and stir to coat with spices.",
                        "6. Add lentils, diced tomatoes, and vegetable broth.",
                        "7. Bring to a boil, then reduce heat and simmer for 20 minutes until lentils and sweet potatoes are tender.",
                        "8. Stir in coconut milk and simmer for another 5 minutes.",
                        "9. Add spinach and cook until wilted, about 2 minutes.",
                        "10. Stir in lime juice and season with salt and pepper to taste.",
                        "11. Garnish with fresh cilantro before serving.",
                        "12. Serve hot with rice or naan bread."
                }
        );

        addRecipe(26, "Mediterranean Grilled Fish",
                "Light and flavorful grilled fish with Mediterranean herbs and vegetables.",
                new String[] {
                        "4 white fish fillets (such as cod, tilapia, or sea bass)",
                        "3 tablespoons olive oil, divided",
                        "2 cloves garlic, minced",
                        "1 lemon, zested and juiced",
                        "2 tablespoons fresh herbs (oregano, thyme, parsley), chopped",
                        "1 pint cherry tomatoes, halved",
                        "1 zucchini, sliced into half-moons",
                        "1 yellow squash, sliced into half-moons",
                        "1 red onion, thinly sliced",
                        "1/2 cup Kalamata olives, pitted",
                        "1/4 cup feta cheese, crumbled",
                        "Salt and pepper to taste"
                },
                new String[] {
                        "1. Preheat grill to medium-high heat or oven to 400°F (200°C).",
                        "2. In a small bowl, mix 2 tablespoons olive oil with garlic, lemon zest, half the lemon juice, and herbs.",
                        "3. Pat fish fillets dry and season with salt and pepper.",
                        "4. Brush fish with the herb mixture on both sides.",
                        "5. In a large bowl, toss tomatoes, zucchini, yellow squash, and red onion with remaining olive oil, salt, and pepper.",
                        "6. If grilling: Place fish on grill and cook for 3-4 minutes per side. Grill vegetables in a grill basket until tender.",
                        "7. If baking: Place vegetables on a baking sheet, roast for 10 minutes. Add fish to the sheet and bake for another 10-12 minutes until fish flakes easily.",
                        "8. Arrange grilled/baked vegetables on a serving platter.",
                        "9. Place fish fillets on top of the vegetables.",
                        "10. Sprinkle with olives and feta cheese.",
                        "11. Drizzle with remaining lemon juice before serving.",
                        "12. Garnish with additional fresh herbs if desired."
                }
        );
    }
    private void addRecipe(int id, String name, String description, String[] ingredients, String[] instructions) {
        recipes.put(id, new Recipe(name, description, ingredients, instructions));
    }

    public void displayHealthyIngredients() {
        System.out.println("\n=== HEALTHY COOKING INGREDIENTS ===");
        for (int i = 0; i < healthyIngredients.size(); i++) {
            System.out.println((i + 1) + ". " + healthyIngredients.get(i));
        }
    }

    public void displayRecipeMenu() {
        System.out.println("\n=== HEALTHY RECIPES ===");
        for (int i = 1; i <= recipes.size(); i++) {
            if (recipes.containsKey(i)) {
                System.out.println(i + ". " + recipes.get(i).getName());
            }
        }
    }

    public void displayRecipe(int recipeNumber) {
        if (recipes.containsKey(recipeNumber)) {
            Recipe recipe = recipes.get(recipeNumber);

            System.out.println("\n=== " + recipe.getName().toUpperCase() + " ===");
            System.out.println(recipe.getDescription());

            System.out.println("\nINGREDIENTS:");
            for (String ingredient : recipe.getIngredients()) {
                System.out.println("- " + ingredient);
            }

            System.out.println("\nINSTRUCTIONS:");
            for (String instruction : recipe.getInstructions()) {
                System.out.println(instruction);
            }
        } else {
            System.out.println("Recipe not found. Please select a valid recipe number.");
        }
    }

    public List<String> getHealthyIngredients() {
        return new ArrayList<>(healthyIngredients);
    }

    public Recipe getRecipe(int id) {
        return recipes.get(id);
    }

    public Map<Integer, Recipe> getAllRecipes() {
        return new HashMap<>(recipes);
    }

    public static class Recipe {
        private String name;
        private String description;
        private String[] ingredients;
        private String[] instructions;

        public Recipe(String name, String description, String[] ingredients, String[] instructions) {
            this.name = name;
            this.description = description;
            this.ingredients = ingredients;
            this.instructions = instructions;
        }

        public String getName() {
            return name;
        }

        public String getDescription() {
            return description;
        }

        public String[] getIngredients() {
            return ingredients;
        }

        public String[] getInstructions() {
            return instructions;
        }
    }
} 