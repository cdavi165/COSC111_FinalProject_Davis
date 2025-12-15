package COSC111_FinalProject_Davis;

/**
 * 
 * @author Cayden Davis
 * @version 12/12/2025
 */
public class AnswerChoices {

    private String text;
    private int score;

    public AnswerChoices(String text, int score) {
        this.text = text;
        this.score = score;
    }

    public String getText() {
        return text;
    }

    public int getScore() {
        return score;
    }
}
