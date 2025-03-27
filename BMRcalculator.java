public class BMRcalculator implements Calculator {
    private InputHandler inputHandler;
    private double weight;
    private double height;
    private int age;
    private boolean isMale;
    private double bmr;
    private double dailyCalories;
    public BMRcalculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    public BMRcalculator() {
    }
    @Override
    public void displayMenu() {
        System.out.println("\n=== BMR CALCULATOR ===");
        System.out.println("BMR (Basal Metabolic Rate) is the number of calories your body needs at rest.");

        collectUserData();
        calculateAndDisplayBMR();
        calculateAndDisplayDailyCalories();

        System.out.println("\nPress Enter to return to the main menu...");
        inputHandler.waitForEnter();
    }

    private void collectUserData() {
        System.out.print("Enter your weight in kilograms: ");
        weight = inputHandler.getDoubleInput();

        System.out.print("Enter your height in centimeters: ");
        height = inputHandler.getDoubleInput();

        System.out.print("Enter your age in years: ");
        age = (int) inputHandler.getDoubleInput();

        System.out.println("Select your gender:");
        System.out.println("1. Male");
        System.out.println("2. Female");
        System.out.print("Enter your choice: ");
        int genderChoice = inputHandler.getUserChoice(1, 2);
        isMale = (genderChoice == 1);
    }

    private void calculateAndDisplayBMR() {
        bmr =calculateBMR(weight, height, age, isMale)*1.2;
        System.out.printf("Your BMR is: %.2f calories per day\n", bmr);
    }

    private void calculateAndDisplayDailyCalories() {
        System.out.println("\nSelect your activity level to calculate your daily calorie needs:");
        System.out.println("1. Sedentary (little or no exercise)");
        System.out.println("2. Lightly active (light exercise/sports 1-3 days/week)");
        System.out.println("3. Moderately active (moderate exercise/sports 3-5 days/week)");
        System.out.println("4. Very active (hard exercise/sports 6-7 days a week)");
        System.out.println("5. Extra active (very hard exercise, physical job or training twice a day)");
        System.out.print("Enter your choice: ");

        int activityChoice = inputHandler.getUserChoice(1, 5);
        dailyCalories = calculateDailyCalories(bmr, activityChoice);

        System.out.printf("Your estimated daily calorie needs: %.2f calories\n", dailyCalories);

        double workoutCalories = dailyCalories - (bmr*1.2);
        System.out.printf("\nAdditional calories can be burned through activity: %.2f calories\n", workoutCalories);
    }
    public double calculateBMR(double weight, double height, int age, boolean isMale) {
        if (isMale) {
            return (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            return (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
    }

    public double calculateDailyCalories(double bmr, int activityLevel) {
        switch (activityLevel) {
            case 1:
                return bmr * 1.2;
            case 2:
                return bmr * 1.375;
            case 3:
                return bmr * 1.55;
            case 4:
                return bmr * 1.725;
            case 5:
                return bmr * 1.9;
            default:
                return bmr * 1.2;
        }
    }
    public double getBmr() {
        return bmr;
    }
    public double getDailyCalories() {
        return dailyCalories;
    }
}