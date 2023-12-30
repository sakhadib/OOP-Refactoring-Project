import java.text.DecimalFormat;

public class MultiplicationQuestion extends Question{
    private double number1;
    private double number2;

    public MultiplicationQuestion(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.answer = number1 * number2;
        this.givenAnswer = -1;
    }

    public MultiplicationQuestion() {
        DecimalFormat df = new DecimalFormat("#.##");
        this.number1 = Double.valueOf(df.format(Math.random() * (10000 - 10) + 10));
        this.number2 = Double.valueOf(df.format(Math.random() * (10000 - 10) + 10));
        this.answer = number1 * number2;
        this.givenAnswer = -1;
    }


    @Override
    public void checkAnswer(String givenAnswer) {
        try{
            this.givenAnswer = Double.parseDouble(givenAnswer);
        }
        catch (NumberFormatException e) {
            throw new NumberFormatException("Answer must be a number");
        }
    }

    @Override
    public void show() {
        System.out.println("What is " + this.number1 + " * " + this.number2 + "?");
    }
}
