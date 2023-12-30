package SolvishR;

import java.text.DecimalFormat;

/**
 * Represents a question related to subtraction.
 * Extends the {@link Question} class and provides functionality to generate subtraction questions with random numbers.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class SubtractionQuestion extends Question {
    /**
     * The minuend in the subtraction operation.
     */
    private double number1;

    /**
     * The subtrahend in the subtraction operation.
     */
    private double number2;

    /**
     * Constructs a subtraction question with specified numbers.
     *
     * @param number1 The minuend.
     * @param number2 The subtrahend.
     */
    public SubtractionQuestion(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.answer = number1 - number2;
        this.givenAnswer = -1;
    }

    /**
     * Constructs a random subtraction question with numbers generated between 10 and 10000 (inclusive).
     * The subtrahend is generated to be between 10 and the value of the minuend.
     */
    public SubtractionQuestion() {
        DecimalFormat df = new DecimalFormat("#.##");
        this.number1 = Double.valueOf(df.format(Math.random() * (10000 - 10) + 10));
        this.number2 = Double.valueOf(df.format(Math.random() * (this.number1 - 10) + 10));
        this.answer = number1 - number2;
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
     * Displays the subtraction question.
     */
    @Override
    public void show() {
        System.out.println("What is " + this.number1 + " - " + this.number2 + "?");
    }
}
