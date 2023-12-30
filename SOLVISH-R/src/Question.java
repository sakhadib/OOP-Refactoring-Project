public abstract class Question {
    double answer;
    double givenAnswer;
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

    public boolean isAnswered() {
        if(this.givenAnswer == -1) {
            return false;
        } else {
            return true;
        }
    }

    public String getGivenAnswer() {
        return this.givenAnswer + "";
    }

    public String getCorrectAnswer() {
        return this.answer + "";
    }

    public abstract void checkAnswer(String givenAnswer);

    public abstract void show();
}
