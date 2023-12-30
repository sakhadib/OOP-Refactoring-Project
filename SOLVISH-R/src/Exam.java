import java.util.List;

public abstract class Exam{
    List<Question> questions;

    public void addQuestion(Question question) {
        questions.add(question);
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public int getCorrect() {
        int correct = 0;
        for (Question question : questions) {
            if (question.isCorrect()) {
                correct++;
            }
        }
        return correct;
    }

    public int getIncorrect() {
        int incorrect = 0;
        for (Question question : questions) {
            if (!question.isCorrect() && question.isAnswered()) {
                incorrect++;
            }
        }
        return incorrect;
    }

    public int getUnanswered() {
        int unanswered = 0;
        for (Question question : questions) {
            if (!question.isAnswered()) {
                unanswered++;
            }
        }
        return unanswered;
    }

    public double getScore() {
        int corr = getCorrect();
        int incorr = getIncorrect();
        double score = corr - (incorr * 0.25);

        return score;
    }

    public abstract void runExam();

    public void showResults() {
        System.out.println("Correct: " + getCorrect());
        System.out.println("Incorrect: " + getIncorrect());
        System.out.println("Unanswered: " + getUnanswered());
        System.out.println("Score: " + getScore());

        ExamSaver.getInstance().saveExam(this);
    }
}
