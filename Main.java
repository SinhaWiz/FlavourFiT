import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to [Savour the Favour of Health] System");



        int input = 10;
        while (input != 0) {
            System.out.println("Select Option");
            System.out.println(" 1 . B M I     ");
             input =sc.nextInt();
            switch (input) {
                case 1:
                    System.out.println("Please Enter your weight (Kilograms)");
                    double weight = sc.nextDouble();

                    System.out.println("Please Enter your height (Meters)");
                    double height = sc.nextDouble();

                    BMIcalculator bmicalc = new BMIcalculator(weight, height);
                    System.out.println("Your BMI is : " + bmicalc.calculateBMI(weight, height));
                    break;
                case 2:
                    System.out.println("Please Enter your weight (Kilograms)");
                    weight = sc.nextDouble();
                    System.out.println("Please Enter your height (Meters)");
                    height = sc.nextDouble();
                    System.out.println("Please Enter your target BMI");
                    double bmi = sc.nextDouble();
                    bmicalc = new BMIcalculator(weight, height, bmi);
                    System.out.println("your weight should be " + bmicalc.bmigoalcalculate(height, bmi) + " or below to reach your goal");
                    break;
                default:
                    System.out.println("Exiting Program");
            }
        }

    }
}