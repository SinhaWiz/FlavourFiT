public class BMIcalculator implements Calculator {
    private InputHandler inputHandler;
    private double weight;
    private double height;
    private double bmi;
    public BMIcalculator(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    public BMIcalculator(double weight, double height) {
        this.weight = weight;
        this.height = height;
    }
    public void setBmi(double bmi) {
        this.bmi = bmi;
    }


    public double bmigoalcalculate(double height, double targetBMI) {
        return calculateTargetWeight(height, targetBMI);
    }

    @Override
    public void displayMenu() {
        System.out.println("\n=== BMI CALCULATOR ===");
        collectUserData();
        calculateAndDisplayBMI();
        offerTargetBMICalculation();

        System.out.println("\nPress Enter to return to the main menu...");
        inputHandler.waitForEnter();
    }
    private void collectUserData() {
        System.out.print("Enter your weight in kilograms: ");
        weight = inputHandler.getDoubleInput();

        System.out.print("Enter your height in meters: ");
        height = inputHandler.getDoubleInput();
    }
    private void calculateAndDisplayBMI() {
        bmi = calculateBMI(weight, height);

        System.out.printf("Your BMI is: %.2f\n", bmi);
        System.out.println("BMI Category: " + getBMICategory(bmi));
    }
    private void offerTargetBMICalculation() {
        System.out.println("\nDo you want to calculate a target weight for a specific BMI?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Enter your choice: ");

        int choice = inputHandler.getUserChoice(1, 2);
        if (choice == 1) {
            calculateTargetWeight();
        }
    }
    private void calculateTargetWeight() {
        System.out.print("Enter your target BMI: ");
        double targetBMI = inputHandler.getDoubleInput();
        double targetWeight = calculateTargetWeight(height, targetBMI);

        System.out.printf("To achieve a BMI of %.2f, your target weight should be: %.2f kg\n",
                targetBMI, targetWeight);
    }

    public double calculateBMI(double weight, double height) {
        return weight / (height * height);
    }

    public double calculateTargetWeight(double height, double targetBMI) {
        return (height * height) * targetBMI;
    }
    public String getBMICategory(double bmi) {
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
    public double getBmi() {
        return bmi;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }
}