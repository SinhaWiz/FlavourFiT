public class WorkoutPlanner implements HealthFeature {
    private InputHandler inputHandler;
    public WorkoutPlanner(InputHandler inputHandler) {
        this.inputHandler = inputHandler;
    }
    public WorkoutPlanner() {
    }
    @Override
    public void displayMenu() {
        System.out.println("\n=== HOME WORKOUT PLANS ===");
        System.out.println("Choose a workout plan:");
        System.out.println("1. Beginner Workout Plan");
        System.out.println("2. Intermediate Workout Plan");
        System.out.println("3. Advanced Workout Plan");
        System.out.print("Enter your choice: ");

        int choice = inputHandler.getUserChoice(1, 3);
        displayWorkoutPlan(choice);

        System.out.println("\nPress Enter to return to the main menu...");
        inputHandler.waitForEnter();
    }
    public void displayWorkoutPlan(int level) {
        switch (level) {
            case 1:
                displayBeginnerWorkout();
                break;
            case 2:
                displayIntermediateWorkout();
                break;
            case 3:
                displayAdvancedWorkout();
                break;
            default:
                System.out.println("Invalid workout level selected.");
        }
    }


    private void displayBeginnerWorkout() {
        System.out.println("\n=== BEGINNER HOME WORKOUT PLAN ===");
        System.out.println("Perform this workout 3 times per week with at least one rest day between sessions.");

        displayWarmUp("5 minutes", new String[] {
                "Jumping jacks: 30 seconds",
                "Arm circles: 30 seconds",
                "High knees: 30 seconds",
                "Bodyweight squats: 10 reps",
                "Push-ups against wall: 10 reps"
        });

        System.out.println("\nMAIN WORKOUT:");
        displayExercise("Bodyweight Squats", "3 sets of 10 reps", new String[] {
                "Stand with feet shoulder-width apart",
                "Lower your body as if sitting in a chair",
                "Keep your back straight and knees behind toes",
                "Rest 60 seconds between sets"
        });

        displayExercise("Modified Push-ups", "3 sets of 8 reps", new String[] {
                "Perform push-ups with knees on the ground if needed",
                "Keep your body in a straight line from head to knees",
                "Rest 60 seconds between sets"
        });

        displayExercise("Glute Bridges", "3 sets of 12 reps", new String[] {
                "Lie on your back with knees bent and feet flat on the floor",
                "Lift your hips toward the ceiling, squeezing your glutes",
                "Hold for 2 seconds at the top",
                "Rest 60 seconds between sets"
        });

        displayExercise("Bird Dogs", "3 sets of 8 reps each side", new String[] {
                "Start on hands and knees",
                "Extend opposite arm and leg while keeping your back flat",
                "Hold for 2 seconds, then switch sides",
                "Rest 60 seconds between sets"
        });

        displayExercise("Plank", "3 sets of 20 seconds", new String[] {
                "Hold a forearm plank position with body in a straight line",
                "Keep your core engaged",
                "Rest 60 seconds between sets"
        });

        displayCoolDown("5 minutes", new String[] {
                "Gentle stretching for major muscle groups",
                "Hold each stretch for 20-30 seconds"
        });
    }


    private void displayIntermediateWorkout() {
        System.out.println("\n=== INTERMEDIATE HOME WORKOUT PLAN ===");
        System.out.println("Perform this workout 4 times per week with proper rest days between sessions.");

        displayWarmUp("5-7 minutes", new String[] {
                "Jumping jacks: 45 seconds",
                "Arm circles: 30 seconds",
                "High knees: 45 seconds",
                "Bodyweight squats: 15 reps",
                "Push-ups: 10 reps",
                "Lunges: 10 reps each leg"
        });

        System.out.println("\nMAIN WORKOUT:");
        displayExercise("Bodyweight Squats", "4 sets of 15 reps", new String[] {
                "Add a 3-second hold at the bottom position",
                "Rest 45 seconds between sets"
        });

        displayExercise("Push-ups", "4 sets of 12 reps", new String[] {
                "Full push-ups with proper form",
                "Add a 1-second pause at the bottom",
                "Rest 45 seconds between sets"
        });

        displayExercise("Walking Lunges", "3 sets of 20 steps total", new String[] {
                "Take a step forward and lower your back knee toward the ground",
                "Push through front heel to stand and repeat with other leg",
                "Rest 45 seconds between sets"
        });

        displayExercise("Plank with Shoulder Taps", "3 sets of 30 seconds", new String[] {
                "Hold a plank position on hands",
                "Tap opposite shoulder while maintaining a stable core",
                "Rest 45 seconds between sets"
        });

        displayExercise("Mountain Climbers", "3 sets of 40 seconds", new String[] {
                "Start in a push-up position",
                "Alternate bringing knees toward chest in a running motion",
                "Rest 45 seconds between sets"
        });

        displayExercise("Tricep Dips", "3 sets of 12 reps", new String[] {
                "Use a sturdy chair or couch",
                "Lower your body by bending elbows to about 90 degrees",
                "Push back up to starting position",
                "Rest 45 seconds between sets"
        });

        displayCoolDown("5-7 minutes", new String[] {
                "Gentle stretching for all major muscle groups",
                "Hold each stretch for 30 seconds"
        });
    }

    private void displayAdvancedWorkout() {
        System.out.println("\n=== ADVANCED HOME WORKOUT PLAN ===");
        System.out.println("Perform this workout 5 times per week with proper rest days between sessions.");

        displayWarmUp("7-10 minutes", new String[] {
                "Jumping jacks: 60 seconds",
                "High knees: 60 seconds",
                "Bodyweight squats: 20 reps",
                "Push-ups: 15 reps",
                "Lunges: 15 reps each leg",
                "Burpees: 10 reps"
        });

        System.out.println("\nMAIN WORKOUT (CIRCUIT - Perform 4 rounds with minimal rest between exercises):");
        displayExercise("Jump Squats", "15 reps", new String[] {
                "Perform a squat, then explode upward into a jump",
                "Land softly and immediately lower into the next squat"
        });

        displayExercise("Push-up Variations", "15 reps", new String[] {
                "Choose from: diamond push-ups, decline push-ups, or clapping push-ups",
                "Maintain proper form throughout"
        });

        displayExercise("Bulgarian Split Squats", "12 reps each leg", new String[] {
                "Place one foot on a chair or bench behind you",
                "Lower into a lunge position and push back up",
                "Complete all reps on one leg before switching"
        });

        displayExercise("Plank Variations", "45 seconds", new String[] {
                "Choose from: side plank, plank with leg lifts, or plank jacks",
                "Maintain proper form throughout"
        });

        displayExercise("Burpees", "12 reps", new String[] {
                "Start standing, drop to a push-up position",
                "Perform a push-up, jump feet toward hands, then jump up with hands overhead"
        });

        displayExercise("Mountain Climbers", "60 seconds", new String[] {
                "Maintain a fast pace while keeping proper form"
        });

        displayExercise("Tricep Dips", "15 reps", new String[] {
                "Use a sturdy chair or couch",
                "Lower your body by bending elbows to about 90 degrees",
                "Push back up to starting position"
        });

        displayExercise("V-ups", "15 reps", new String[] {
                "Lie on your back, then simultaneously lift legs and upper body to form a V shape",
                "Lower back down with control"
        });

        System.out.println("\nRest 2 minutes between circuits");

        displayCoolDown("7-10 minutes", new String[] {
                "Gentle stretching for all major muscle groups",
                "Hold each stretch for 30-45 seconds",
                "Focus on deep breathing and relaxation"
        });
    }
    private void displayWarmUp(String duration, String[] exercises) {
        System.out.println("\nWARM-UP (" + duration + "):");
        for (String exercise : exercises) {
            System.out.println("- " + exercise);
        }
    }
    private void displayExercise(String name, String prescription, String[] instructions) {
        System.out.println("\n" + (name.startsWith("1") || name.startsWith("2") ||
                name.startsWith("3") || name.startsWith("4") ||
                name.startsWith("5") || name.startsWith("6") ||
                name.startsWith("7") || name.startsWith("8") ?
                name : (name + ": " + prescription)));
        for (String instruction : instructions) {
            System.out.println("   - " + instruction);
        }
    }
    private void displayCoolDown(String duration, String[] instructions) {
        System.out.println("\nCOOL-DOWN (" + duration + "):");
        for (String instruction : instructions) {
            System.out.println("- " + instruction);
        }
    }
} 