package COSC111_FinalProject_Davis;

/**
 * 
 * 
 * 
 */
import java.util.Scanner;

public class Davis_Final {
    /**
     * printMenu() prints the menu options for the user
     */
    public static void printMenu() {
        System.out.println("1) Take Test");
        System.out.println("2) Restart Test");
        System.out.println("3) View Score");
        System.out.println("4) View Descriptions");
        System.out.print("Choose 1-4: ");
    }

    /**
     * reads valid menu choices
     * 
     * @param kb
     * @return
     */
    static int readMenuChoice(Scanner kb) {
        int validChoice = 0;
        while (true) {
            if (kb.hasNextInt()) {
                validChoice = kb.nextInt();
                if (validChoice >= 1 && validChoice <= 4) {
                    return validChoice;
                } else {
                    System.out.print("Choose 1-4: ");
                }
            }
        }
    }

    /**
     * Descriptions prints out the descriptions for the four temperaments.
     */
    public static void Descriptions() {
        System.out.println(
                "Sanguine\nPeople with a Sanguine temperament are naturally people-oriented and do not need a reason to be with other people. The Sanguine is extroverted, fun-loving, playful, activity-prone, impulsive, entertaining, persuasive, easily amused, and optimistic.\n");
        System.out.println(
                "Melancholic\nMelancholies are detailed-oriented, operate from a plan, and they are usually very private. They are introverted, logical, analytical, and factual in communication. They need information, time alone to think, and a detailed plan in order to function effectively without anxiety.\n");
        System.out.println(
                "Choleric\nThe Choleric person is extroverted, driven to get results, and will not give in to the pressure of what others think unless they cannot get quick results. They are slow to build relationships and tend to have only a few close friends because results are more important than people.\n");
        System.out.println(
                "Phlegmatic\nThe Phlegmatic is introverted, calm, unemotional, easygoing, indecisive, patient, and agreeable. They are both slow and indirect when responding to others. Although the Phlegmatic is usually slow to warm up, they are accommodating in the process.");
    }

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        Test test = new Test(kb);
        int choice;
        int lastScore = 0;
        System.out.println("Four Temperaments Personality Test");
        System.out.println("===================================");
        System.out.println();

        do {
            printMenu();
            choice = readMenuChoice(kb);

            if (choice == 1) {
                // Take the test
                lastScore = test.run();
            } else if (choice == 2) {
                // Restart the test
                test.reset();
                System.out.println("Test has been reset.");
            } else if (choice == 3) {
                // Check score
                System.out.println("Your current score is: " + lastScore);
            } else if (choice == 4) {
                // Show personality descriptions
                Descriptions();
            }

            System.out.println();
        } while (true);

    }
}
