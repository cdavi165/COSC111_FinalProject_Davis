package COSC111_FinalProject_Davis;
import java.util.Scanner;

public class Test {

    private Question[] questions = new Question[16];
    private Scanner kb;

    private int score; // Total score
    private int currentQuestionIndex; // Tracks which question to start from

    public Test(Scanner kb) {
        this.kb = kb;
        buildQuestions();
        reset(); // initialize score and index
    }

    // Reset test to start over
    public void reset() {
        score = 0;
        currentQuestionIndex = 0;
    }

    // Run the test
    public int run() {

        for (int i = currentQuestionIndex; i < questions.length; i++) {
            Question q = questions[i];
            int choice = askQuestion(q);

            if (choice == 5) { // Return to menu
                currentQuestionIndex = i; // Save progress
                System.out.println("Returning to menu...");
                return score;
            }

            score += q.getChoices()[choice - 1].getScore();
        }

        System.out.println("\nTest complete! Your total score is: " + score);
        printPersonalityType(score);

        return score;
    }

    // Ask a single question
    private int askQuestion(Question q) {
        System.out.println("\n" + q.getChoices());

        AnswerChoices[] opts = q.getChoices();
        for (int i = 0; i < opts.length; i++) {
            System.out.println((i + 1) + ". " + opts[i].getText());
        }
        System.out.println("5. Return to Menu");

        int choice;
        while (true) {
            System.out.print("Choose 1–5: ");
            while (!kb.hasNextInt()) {
                System.out.print("Invalid input. Enter 1–5: ");
                kb.next();
            }
            choice = kb.nextInt();
            if (choice >= 1 && choice <= 5)
                break;
        }

        return choice;
    }

    // Determine personality type based on score
    private void printPersonalityType(int score) {
        System.out.println("\nYour personality type is:");
        if (score <= 20) {
            System.out.println("Calm & Reserved");
        } else if (score <= 40) {
            System.out.println("Balanced & Thoughtful");
        } else if (score <= 60) {
            System.out.println("Energetic & Expressive");
        } else {
            System.out.println("Bold & Adventurous");
        }
    }

    // Build all 16 questions (numbered placeholders)
    private void buildQuestions() {
        questions[0] = new Question(
                "1. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[1] = new Question(
                "2. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[2] = new Question(
                "3. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[3] = new Question(
                "4. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[4] = new Question(
                "5. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[5] = new Question(
                "6. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[6] = new Question(
                "7. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[7] = new Question(
                "8. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[8] = new Question(
                "9. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[9] = new Question(
                "10. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[10] = new Question(
                "11. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[11] = new Question(
                "12. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[12] = new Question(
                "13. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[13] = new Question(
                "14. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[14] = new Question(
                "15. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });

        questions[15] = new Question(
                "16. Question",
                new AnswerChoices[] {
                        new AnswerChoices("Choice 1", 1),
                        new AnswerChoices("Choice 2", 2),
                        new AnswerChoices("Choice 3", 3),
                        new AnswerChoices("Choice 4", 4)
                });
    }
}
