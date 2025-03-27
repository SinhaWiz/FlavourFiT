import java.util.Scanner;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HealthApp {
    private static Scanner scanner = new Scanner(System.in);
    private static Map<LocalDate, Double> waterIntakeRecords = new HashMap<>();
    private static double dailyWaterTarget = 2000; // Default 2000ml (2 liters)
    public static void main(String[] args) {
        displayWelcomeMessage();
        boolean exit = false;

        while (!exit) {
            displayMainMenu();
            int choice = getUserChoice(1, 8);

            switch (choice) {
                case 1:
                    bmiCalculatorMenu();
                    break;
                case 2:
                    bmrCalculatorMenu();
                    break;
                case 3:
                    workoutPlanMenu();
                    break;
                case 4:
                    dietSuggestionsMenu();
                    break;
                case 5:
                    healthyCookingMenu();
                    break;
                case 6:
                    bloodPressureSuggestionsMenu();
                    break;
                case 7:
                    heartDiseaseAndDiabetesSuggestionsMenu();
                    break;
                case 8:
                    waterIntakeTrackerMenu();
                    break;
                case 0:
                    exit = true;
                    System.out.println("Thank you for using Savour The Flavour of Health. Stay healthy!");
                    break;
            }
        }
        scanner.close();
    }
    private static void displayWelcomeMessage() {
        System.out.println("    *******************************************");
        System.out.println("    *                                         *");
        System.out.println("     *                FlavourFiT             *");
        System.out.println("    *                                         *");
        System.out.println("    *******************************************");
        System.out.println("\nWelcome to your personal health companion!");
        System.out.println("This application will help you maintain a healthy lifestyle");
        System.out.println("through proper nutrition and exercise guidance.");
        System.out.println("\nPress Enter to continue...");
        scanner.nextLine();
    }

    private static void displayMainMenu() {
        System.out.println("\n=== MAIN MENU ===");
        System.out.println("1. BMI Calculator");
        System.out.println("2. BMR Calculator");
        System.out.println("3. Home Workout Plans");
        System.out.println("4. Diet Change Suggestions");
        System.out.println("5. Healthy Cooking Recipes");
        System.out.println("6. Blood Pressure Management");
        System.out.println("7. Heart Disease & Diabetes Management");
        System.out.println("8. Water Intake Tracker");
        System.out.println("0. Exit");
        System.out.print("\nEnter your choice: ");
    }

    private static int getUserChoice(int min, int max) {
        int choice = -1;
        boolean validInput = false;

        while (!validInput) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= 0 && choice <= max) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a number between 0 and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }

        return choice;
    }

    private static void bmiCalculatorMenu() {
        System.out.println("\n=== BMI CALCULATOR ===");
        System.out.print("Enter your weight in kilograms: ");
        double weight = getDoubleInput();

        System.out.print("Enter your height in meters: ");
        double height = getDoubleInput();

        BMIcalculator bmiCalc = new BMIcalculator(weight, height);
        double bmi = bmiCalc.calculateBMI(weight, height);
        bmiCalc.setBmi(bmi);

        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.println("BMI Category: " + getBMICategory(bmi));

        System.out.println("\nDo you want to calculate a target weight for a specific BMI?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 2);
        if (choice == 1) {
            System.out.print("Enter your target BMI: ");
            double targetBMI = getDoubleInput();
            double targetWeight = bmiCalc.bmigoalcalculate(height, targetBMI);
            System.out.printf("To achieve a BMI of %.2f, your target weight should be: %.2f kg\n",
                    targetBMI, targetWeight);
        }

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static String getBMICategory(double bmi) {
        if (bmi < 18.5) {
            return "Underweight - Consider consulting with a nutritionist for a healthy weight gain plan.";
        } else if (bmi < 25) {
            return "Normal weight - Keep up the good work!";
        } else if (bmi < 30) {
            return "Overweight - Consider making some lifestyle changes.";
        } else if (bmi < 35) {
            return "Obesity Class I - Please consider consulting with a healthcare professional.";
        } else if (bmi < 40) {
            return "Obesity Class II - Strongly recommended to consult with a healthcare professional.";
        } else {
            return "Obesity Class III - Urgent medical consultation recommended.";
        }
    }

    private static void bmrCalculatorMenu() {
        System.out.println("\n=== BMR CALCULATOR ===");
        System.out.println("BMR (Basal Metabolic Rate) is the number of calories your body needs at rest.");

        System.out.print("Enter your weight in kilograms: ");
        double weight = getDoubleInput();

        System.out.print("Enter your height in centimeters: ");
        double height = getDoubleInput();

        System.out.print("Enter your age in years: ");
        int age = (int) getDoubleInput();

        System.out.println("Select your gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.print("Enter your choice: ");
        int genderChoice = getUserChoice(1, 2);

        BMRcalculator bmrCalc = new BMRcalculator();
        double bmr = bmrCalc.calculateBMR(weight, height, age, genderChoice == 1);

        System.out.printf("Your BMR is: %.2f calories per day\n", bmr);

        System.out.println("\nSelect your activity level to calculate your daily calorie needs:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise/sports 1-3 days/week)");
        System.out.println("3. Moderately active (moderate exercise/sports 3-5 days/week)");
        System.out.println("4. Very active (hard exercise/sports 6-7 days a week)");
        System.out.println("5. Extra active (very hard exercise, physical job or training twice a day)");
        System.out.print("Enter your choice: ");

        int activityChoice = getUserChoice(1, 5);
        double dailyCalories = bmrCalc.calculateDailyCalories(bmr, activityChoice);

        System.out.printf("Your estimated daily calorie needs: %.2f calories\n", dailyCalories);

        double workoutCalories = dailyCalories - bmr;
        System.out.printf("\nAdditional calories burned through activity: %.2f calories\n", workoutCalories);

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void workoutPlanMenu() {
        System.out.println("\n=== HOME WORKOUT PLANS ===");
        System.out.println("Choose a workout plan:");
        System.out.println("1. Beginner Workout Plan");
        System.out.println("2. Intermediate Workout Plan");
        System.out.println("3. Advanced Workout Plan");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 3);

        WorkoutPlanner planner = new WorkoutPlanner();
        planner.displayWorkoutPlan(choice);

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void dietSuggestionsMenu() {
        System.out.println("\n=== DIET CHANGE SUGGESTIONS ===");

        DietSuggestions dietSuggestions = new DietSuggestions();
        dietSuggestions.displayRandomSuggestions(5);

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void healthyCookingMenu() {
        System.out.println("\n=== HEALTHY COOKING ===");
        System.out.println("1. View Healthy Cooking Ingredients");
        System.out.println("2. Browse Recipes");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 2);

        RecipeManager recipeManager = new RecipeManager();

        if (choice == 1) {
            recipeManager.displayHealthyIngredients();
        } else {
            recipeManager.displayRecipeMenu();
            System.out.print("Enter recipe number (1-26): ");
            int recipeChoice = getUserChoice(1, 26);
            recipeManager.displayRecipe(recipeChoice);
        }

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void bloodPressureSuggestionsMenu() {
        System.out.println("\n=== BLOOD PRESSURE MANAGEMENT ===");
        System.out.println("1. High Blood Pressure Suggestions");
        System.out.println("2. Low Blood Pressure Suggestions");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 2);

        HealthConditionManager healthManager = new HealthConditionManager();

        if (choice == 1) {
            healthManager.displayHighBloodPressureSuggestions();
        } else {
            healthManager.displayLowBloodPressureSuggestions();
        }

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void heartDiseaseAndDiabetesSuggestionsMenu() {
        System.out.println("\n=== HEART DISEASE & DIABETES MANAGEMENT ===");
        System.out.println("1. Heart Disease Management");
        System.out.println("2. Diabetes Management");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 2);

        HealthConditionManager healthManager = new HealthConditionManager();

        if (choice == 1) {
            healthManager.displayHeartDiseaseSuggestions();
        } else {
            healthManager.displayDiabetesSuggestions();
        }

        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void waterIntakeTrackerMenu() {
        System.out.println("\n=== WATER INTAKE TRACKER ===");
        System.out.println("Staying hydrated is essential for your health.");
        System.out.println("1. Calculate Recommended Water Intake");
        System.out.println("2. Log Water Consumption");
        System.out.println("3. View Today's Status");
        System.out.println("4. View Hydration Tips");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 4);

        switch (choice) {
            case 1:
                calculateWaterIntakeTarget();
                break;
            case 2:
                logWaterConsumption();
                break;
            case 3:
                displayWaterIntakeStatus();
                break;
            case 4:
                displayHydrationTips();
                break;
        }
        System.out.println("\nPress Enter to return to the main menu...");
        scanner.nextLine();
    }

    private static void calculateWaterIntakeTarget() {
        System.out.println("\n=== CALCULATE RECOMMENDED WATER INTAKE ===");

        System.out.print("Enter your weight in kilograms: ");
        double weight = getDoubleInput();

        System.out.println("\nSelect your activity level:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise/sports 1-3 days/week)");
        System.out.println("3. Moderately active (moderate exercise/sports 3-5 days/week)");
        System.out.println("4. Very active (hard exercise/sports 6-7 days a week)");
        System.out.println("5. Extra active (very hard exercise, physical job or training twice a day)");
        System.out.print("Enter your choice: ");

        int activityLevel = getUserChoice(1, 5);
        double baseIntake = weight * 35;
        double activityMultiplier = 1.0;
        switch (activityLevel) {
            case 1:
                activityMultiplier = 1.0;
                break;
            case 2:
                activityMultiplier = 1.1;
                break;
            case 3:
                activityMultiplier = 1.2;
                break;
            case 4:
                activityMultiplier = 1.3;
                break;
            case 5:
                activityMultiplier = 1.4;
                break;
        }

        double recommendedIntake = Math.round(baseIntake * activityMultiplier / 100) * 100; // Round to nearest 100ml

        System.out.printf("\nBased on your weight (%.1f kg) and activity level, ", weight);
        System.out.printf("your recommended daily water intake is: %.0f ml\n", recommendedIntake);
        System.out.println("\nWould you like to set this as your daily target?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");

        int setTarget = getUserChoice(1, 2);
        if (setTarget == 1) {
            dailyWaterTarget = recommendedIntake;
            System.out.printf("Daily water intake target set to %.0f ml.\n", dailyWaterTarget);
        }
    }
    private static void logWaterConsumption() {
        System.out.println("\n=== LOG WATER CONSUMPTION ===");
        System.out.println("Common water portions:");
        System.out.println("1. Glass of water (250 ml)");
        System.out.println("2. Small bottle (500 ml)");
        System.out.println("3. Large bottle (1000 ml)");
        System.out.println("4. Cup of water (200 ml)");
        System.out.println("5. Custom amount");
        System.out.print("Enter your choice: ");

        int choice = getUserChoice(1, 5);

        double amount = 0;
        switch (choice) {
            case 1:
                amount = 250;
                break;
            case 2:
                amount = 500;
                break;
            case 3:
                amount = 1000;
                break;
            case 4:
                amount = 200;
                break;
            case 5:
                System.out.print("Enter the amount in milliliters: ");
                amount = getDoubleInput();
                break;
        }
        LocalDate today = LocalDate.now();
        double currentIntake = waterIntakeRecords.getOrDefault(today, 0.0);
        waterIntakeRecords.put(today, currentIntake + amount);

        System.out.printf("Added %.0f ml of water. ", amount);
        displayWaterIntakeStatus();
    }

    private static void displayWaterIntakeStatus() {
        System.out.println("\n=== TODAY'S HYDRATION STATUS ===");

        LocalDate today = LocalDate.now();
        double currentIntake = waterIntakeRecords.getOrDefault(today, 0.0);
        double remainingIntake = Math.max(0, dailyWaterTarget - currentIntake);
        double percentageComplete = (currentIntake / dailyWaterTarget) * 100;

        System.out.printf("Target: %.0f ml\n", dailyWaterTarget);
        System.out.printf("Consumed: %.0f ml\n", currentIntake);
        System.out.printf("Remaining: %.0f ml\n", remainingIntake);
        System.out.printf("Progress: %.1f%%\n", percentageComplete);

        // Display progress bar
        displayProgressBar(percentageComplete);

        if (currentIntake >= dailyWaterTarget) {
            System.out.println("Congratulations! You've reached your water intake goal for today.");
        } else {
            System.out.printf("You need to drink %.0f more ml to reach your goal.\n", remainingIntake);
        }
    }
    private static void displayProgressBar(double percentage) {
        int barLength = 20;
        int filledLength = (int) (percentage / 100 * barLength);

        System.out.print("[");
        for (int i = 0; i < barLength; i++) {
            if (i < filledLength) {
                System.out.print("■");
            } else {
                System.out.print("□");
            }
        }
        System.out.println("]");
    }

    /**
     * Displays hydration tips
     */
    private static void displayHydrationTips() {
        System.out.println("\n=== HYDRATION TIPS ===");
        System.out.println("1. Start your day with a glass of water");
        System.out.println("2. Carry a reusable water bottle with you");
        System.out.println("3. Set reminders to drink water throughout the day");
        System.out.println("4. Drink a glass of water before each meal");
        System.out.println("5. Eat water-rich foods (cucumbers, watermelon, oranges)");
        System.out.println("6. Flavor water with fruits if you find plain water boring");
        System.out.println("7. Drink more water during and after exercise");
        System.out.println("8. Increase intake during hot weather");
        System.out.println("9. Limit caffeine and alcohol, which can cause dehydration");
        System.out.println("10. Monitor your urine color - pale yellow indicates good hydration");
    }
    private static double getDoubleInput() {
        double value = 0;
        boolean validInput = false;

        while (!validInput) {
            try {
                value = Double.parseDouble(scanner.nextLine());
                if (value > 0) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a positive number: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }
        return value;
    }
}