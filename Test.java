package COSC111_FinalProject_Davis;

/**
 * 
 * @author Cayden Davis
 * @version 12/12/2025
 */
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

                printPersonalityType(score); // Prints personality type after test

                return score;
        }

        // Ask a single question
        private int askQuestion(Question q) {
                System.out.println("\n" + q.getPrompt());

                AnswerChoices[] opts = q.getChoices();
                for (int i = 0; i < opts.length; i++) {
                        System.out.println((i + 1) + ". " + opts[i].getText());
                }
                System.out.println("5. Return to Menu");

                int choice;
                while (true) {
                        System.out.print("Choose 1-5: ");
                        while (!kb.hasNextInt()) {
                                System.out.print("Invalid input. Enter 1-5: ");
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
                        System.out.println(
                                        "Sanguine\nPeople with a Sanguine temperament are naturally people-oriented and do not need a reason to be with other people. The Sanguine is extroverted, fun-loving, playful, activity-prone, impulsive, entertaining, persuasive, easily amused, and optimistic.\n");
                } else if (score <= 40) {
                        System.out.println(
                                        "Melancholic\nMelancholies are detailed-oriented, operate from a plan, and they are usually very private. They are introverted, logical, analytical, and factual in communication. They need information, time alone to think, and a detailed plan in order to function effectively without anxiety.\n");
                } else if (score <= 60) {
                        System.out.println(
                                        "Choleric\nThe Choleric person is extroverted, driven to get results, and will not give in to the pressure of what others think unless they cannot get quick results. They are slow to build relationships and tend to have only a few close friends because results are more important than people.\n");
                } else {
                        System.out.println(
                                        "Phlegmatic\nThe Phlegmatic is introverted, calm, unemotional, easygoing, indecisive, patient, and agreeable. They are both slow and indirect when responding to others. Although the Phlegmatic is usually slow to warm up, they are accommodating in the process.");
                }
        }

        // Builds all 16 questions
        private void buildQuestions() {
                questions[0] = new Question(
                                "People may describe you as: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Enthusiastic and optimistic.", 1),
                                                new AnswerChoices("Analytical and private.", 2),
                                                new AnswerChoices("Driven and motivated.", 3),
                                                new AnswerChoices("Laid-back and accommodating.", 4)
                                });

                questions[1] = new Question(
                                "When dealing with conflict you: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Try to resolve it.", 1),
                                                new AnswerChoices("Withdraw to avoid anxiety.", 2),
                                                new AnswerChoices("Argue my own side vehemently.", 3),
                                                new AnswerChoices("Try not to get involved.", 4)
                                });

                questions[2] = new Question(
                                "You make decisions based on: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Personal feelings at the moment", 1),
                                                new AnswerChoices("Carefully assessing options.", 2),
                                                new AnswerChoices(
                                                                "Whatever produces results in the most efficient manner.",
                                                                3),
                                                new AnswerChoices("Whichever choice maintains my peace.", 4)
                                });

                questions[3] = new Question(
                                "Your biggest strengths are: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Bringing joy and energy to friends.", 1),
                                                new AnswerChoices("Attention to detail and analysis.", 2),
                                                new AnswerChoices("Leadership and perserverance.", 3),
                                                new AnswerChoices("Patience and loyalty.", 4)
                                });

                questions[4] = new Question(
                                "Your biggest weaknesses are: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Staying focused and impulsivity.", 1),
                                                new AnswerChoices("Overthinking and anxiety.", 2),
                                                new AnswerChoices("Being controlling and instense.", 3),
                                                new AnswerChoices("Indecisiveness and passivity.", 4)
                                });

                questions[5] = new Question(
                                "When criticized, you: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Brush it off and stay optimistic.", 1),
                                                new AnswerChoices("Take it as an insult and reflect on it.", 2),
                                                new AnswerChoices("Defend yourself to disprove the criticism.", 3),
                                                new AnswerChoices("Accept it and live it off.", 4)
                                });

                questions[6] = new Question(
                                "If you have to learn something new, you: ",
                                new AnswerChoices[] {
                                                new AnswerChoices(
                                                                "Try to put new information into practice immediately.",
                                                                1),
                                                new AnswerChoices(
                                                                "Carefully study and research to gain a full understanding.",
                                                                2),
                                                new AnswerChoices(
                                                                "Try to master the new skill as efficiently as possible.",
                                                                3),
                                                new AnswerChoices("Move at your own pace to learn it.", 4)
                                });

                questions[7] = new Question(
                                "Your ideal friend group is: ",
                                new AnswerChoices[] {
                                                new AnswerChoices(
                                                                "A large, energetic group, that loves adventure and going out.",
                                                                1),
                                                new AnswerChoices(
                                                                "A close-knit circle who have meaningful conversations.",
                                                                2),
                                                new AnswerChoices(
                                                                "A small group that challenge and push each other to be better.",
                                                                3),
                                                new AnswerChoices(
                                                                "A moderately sized group that try to foster long-term, conflict free, relationships.",
                                                                4)
                                });

                questions[8] = new Question(
                                "You express affection: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Openly and playfully.", 1),
                                                new AnswerChoices("Thoughtfully and considerately.", 2),
                                                new AnswerChoices("Directly and specific.", 3),
                                                new AnswerChoices("Gently and supporting.", 4)
                                });

                questions[9] = new Question(
                                "Your plans with a friend to go out were cancelled. You: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Reach out to another friend to make plans.", 1),
                                                new AnswerChoices(
                                                                "Feel disappointed and think about why it may have happened.",
                                                                2),
                                                new AnswerChoices("Request their reasoning and reschedule.", 3),
                                                new AnswerChoices("Accept it and stay relaxed at home.", 4)
                                });

                questions[10] = new Question(
                                "When you feel angry you: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Express it openly and dramatically.", 1),
                                                new AnswerChoices("Think about what made you so upset.", 2),
                                                new AnswerChoices("Confront the source and work to manage your anger.",
                                                                3),
                                                new AnswerChoices("Suppress it and hope it passes over.", 4)
                                });

                questions[11] = new Question(
                                "When dealing with stress, you: ",
                                new AnswerChoices[] {
                                                new AnswerChoices(
                                                                "Distract yourself by going out and doing something fun.",
                                                                1),
                                                new AnswerChoices(
                                                                "Stick to your plans to keep the stress to a minimum.",
                                                                2),
                                                new AnswerChoices(
                                                                "Take care of the stressful situation as quickly as possible.",
                                                                3),
                                                new AnswerChoices("Take a break to help reduce stress.", 4)
                                });

                questions[12] = new Question(
                                "Your workspace is: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Messy, but colorful and personalized.", 1),
                                                new AnswerChoices("Neat and organized.", 2),
                                                new AnswerChoices("Minimal and functional.", 3),
                                                new AnswerChoices("Anywhere that is convenient.", 4)
                                });

                questions[13] = new Question(
                                "You can not live without: ",
                                new AnswerChoices[] {
                                                new AnswerChoices("Adventure", 1),
                                                new AnswerChoices("Structure", 2),
                                                new AnswerChoices("Purpose", 3),
                                                new AnswerChoices("Stability", 4)
                                });

                questions[14] = new Question(
                                "You are happiest when: ",
                                new AnswerChoices[] {
                                                new AnswerChoices(
                                                                "You are having fun doing what you love with the people you love.",
                                                                1),
                                                new AnswerChoices(
                                                                "You feel understood and you understand the world around you.",
                                                                2),
                                                new AnswerChoices("Your goals are being accomplished.", 3),
                                                new AnswerChoices("Your life feels quiet and calm.", 4)
                                });

                questions[15] = new Question(
                                "You are at a party. You: ",
                                new AnswerChoices[] {
                                                new AnswerChoices(
                                                                "Talk to new people, play games, keep the energy high.",
                                                                1),
                                                new AnswerChoices(
                                                                "Stick to the group you came in with and hang out with them.",
                                                                2),
                                                new AnswerChoices(
                                                                "Organize games and challenges for people to partake in.",
                                                                3),
                                                new AnswerChoices(
                                                                "Observe quietly and go along with what everyone else is doing.",
                                                                4)
                                });
        }
}
