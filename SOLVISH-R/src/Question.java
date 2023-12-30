/**
 * The base class for representing a question.
 * Subclasses must implement the abstract methods {@link #checkAnswer(String)} and {@link #show()}.
 * Provides methods to check if an answer is correct, determine if the question has been answered,
 * and retrieve the given and correct answers.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public abstract class Question {
    /**
     * The correct answer to the question.
     */
    public double answer;

    /**
     * The answer provided by the user.
     */
    double givenAnswer;

    /**
     * Checks if the given answer is correct.
     *
     * @return {@code true} if the answer is correct within a tolerance of 0.01,
     *         {@code false} otherwise.
     * @throws NullPointerException If the answer is not a number.
     */
    public boolean isCorrect() {
        try {
            if (Math.abs(this.answer - this.givenAnswer) < 0.01) {
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Answer must be a number");
        }
    }

    /**
     * Checks if the question has been answered.
     *
     * @return {@code true} if the question has been answered, {@code false} otherwise.
     */
    public boolean isAnswered() {
        return this.givenAnswer != -1;
    }

    /**
     * Gets the given answer as a string.
     *
     * @return The given answer as a string.
     */
    public String getGivenAnswer() {
        return this.givenAnswer + "";
    }

    /**
     * Gets the correct answer as a string.
     *
     * @return The correct answer as a string.
     */
    public String getCorrectAnswer() {
        return this.answer + "";
    }

    /**
     * Abstract method to check the provided answer.
     *
     * @param givenAnswer The answer provided by the user.
     */
    public abstract void checkAnswer(String givenAnswer);

    /**
     * Abstract method to display the question.
     */
    public abstract void show();
}
