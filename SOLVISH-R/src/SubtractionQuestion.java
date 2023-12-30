import java.text.DecimalFormat;

public class SubtractionQuestion implements iQuestion{
    private double number1;
    private double number2;
    private double answer;
    private double givenAnswer;

    public SubtractionQuestion(double number1, double number2) {
        this.number1 = number1;
        this.number2 = number2;
        this.answer = number1 - number2;
        this.givenAnswer = -1;
    }

    public SubtractionQuestion() {
        DecimalFormat df = new DecimalFormat("#.##");
        this.number1 = Double.valueOf(df.format(Math.random() * (10000 - 10) + 10));
        this.number2 = Double.valueOf(df.format(Math.random() * (this.number1 - 10) + 10));
        this.answer = number1 - number2;
        this.givenAnswer = -1;
    }


    @Override
    public boolean isCorrect() {
        try{
            if(this.answer - this.givenAnswer < 0.01 && this.answer - this.givenAnswer > -0.01) {
                return true;
            } else {
                return false;
            }
        }
        catch (NullPointerException e) {
            throw new NullPointerException("Answer must be a number");
        }
    }

    @Override
    public boolean isAnswered() {
        if(this.givenAnswer == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public String getGivenAnswer() {
        return this.givenAnswer + "";
    }

    @Override
    public String getCorrectAnswer() {
        return this.answer + "";
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
        System.out.println("What is " + this.number1 + " - " + this.number2 + "?");
    }
}
