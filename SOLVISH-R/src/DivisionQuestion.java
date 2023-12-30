import java.text.DecimalFormat;

/**
 * Represents a question related to division.
 * Extends the {@link Question} class and provides functionality to generate division questions with random numbers.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class DivisionQuestion extends Question {
    /**
     * The dividend in the division operation.
     */
    private double number1;

    /**
     * The divisor in the division operation.
     */
    private double number2;

    /**
     * Constructs a division question with specified numbers.
     *
     * @param number1 The dividend.
     * @param number2 The divisor.
     */
    public DivisionQuestion(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.answer = number1 / number2;
        this.givenAnswer = -1;
    }

    /**
     * Constructs a random division question with numbers generated between 10 and 10000 (inclusive).
     * The divisor is generated to be between 10 and the value of the dividend.
     */
    public DivisionQuestion() {
        DecimalFormat df = new DecimalFormat("#.##");
        this.number1 = Double.valueOf(df.format(Math.random() * (10000 - 10) + 10));
        this.number2 = Double.valueOf(df.format(Math.random() * (this.number1 - 10) + 10));
        this.answer = number1 / number2;
        this.givenAnswer = -1;
    }

    /**
     * Checks the provided answer for correctness.
     *
     * @param givenAnswer The answer provided by the user.
     * @throws NumberFormatException If the provided answer is not a valid number.
     */
    @Override
    public void checkAnswer(String givenAnswer) {
        try {
            this.givenAnswer = Double.parseDouble(givenAnswer);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Answer must be a number");
        }
    }

    /**
     * Displays the division question.
     */
    @Override
    public void show() {
        System.out.println("What is " + this.number1 + " / " + this.number2 + "?");
    }
}
