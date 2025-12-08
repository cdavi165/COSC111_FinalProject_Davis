package COSC111_FinalProject_Davis;

public class Question {

    private String prompt;
    private AnswerChoices[] options; // Must contain exactly 4 choices

    public Question(String prompt, AnswerChoices[] options) {
        this.prompt = prompt;
        this.options = options;
    }

    public String getPrompt() {
        return prompt;
    }

    public AnswerChoices[] getChoices() {
        return options;
    }
}
