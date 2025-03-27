import java.util.Scanner;
public class InputHandler {
    private Scanner scanner;
    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }
    public int getUserChoice(int min, int max) {
        int choice = -1;
        boolean validInput = false;
        while (!validInput) {
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= min && choice <= max) {
                    validInput = true;
                } else {
                    System.out.print("Please enter a number between " + min + " and " + max + ": ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a number: ");
            }
        }

        return choice;
    }
    public double getDoubleInput() {
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
    public void waitForEnter() {
        scanner.nextLine();
    }
    public String getStringInput() {
        return scanner.nextLine();
    }
} 