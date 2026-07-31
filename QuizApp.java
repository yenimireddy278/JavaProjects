import java.util.Scanner;

public class QuizApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Questions array
        String[] questions = {
            "1. Which language is used for Android Development?",
            "2. What is the default value of a boolean variable in Java?",
            "3. Which data structure operates on LIFO (Last In, First Out)?"
        };
        
        // Options array
        String[][] options = {
            {"1. Python", "2. Java", "3. HTML", "4. C++"},
            {"1. true", "2. false", "3. 0", "4. null"},
            {"1. Queue", "2. Stack", "3. Array", "4. Tree"}
        };
        
        // Correct answers index (0-based: 1 means second option)
        int[] correctAnswers = {1, 1, 1};
        int score = 0;

        System.out.println("===== WELCOME TO THE JAVA QUIZ APP =====");

        // Loop through questions
        for (int i = 0; i < questions.length; i++) {
            System.out.println("\n" + questions[i]);
            
            for (String option : options[i]) {
                System.out.println(option);
            }
            
            System.out.print("Enter your choice (1-4): ");
            int userChoice = scanner.nextInt();

            // Check if the answer is correct
            if (userChoice - 1 == correctAnswers[i]) {
                System.out.println("Correct! 🎉");
                score++;
            } else {
                System.out.println("Wrong! ❌");
            }
        }

        // Final Score display
        System.out.println("\n================================");
        System.out.println("Quiz Finished!");
        System.out.println("Your Final Score: "  + score + "/" + questions.length);
        System.out.println("================================");
        
        scanner.close();
    }
}