import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonTimedExam implements iExam{
    List<iQuestion> questions;

    public NonTimedExam(List<iQuestion> questions) {
        this.questions = questions;
    }

    public NonTimedExam() {
        this.questions = new ArrayList<iQuestion>();
    }

    public void addQuestion(iQuestion question) {
        questions.add(question);
    }

    public int getCorrect() {
        int correct = 0;
        for (iQuestion question : questions) {
            if (question.isCorrect()) {
                correct++;
            }
        }
        return correct;
    }

    public int getIncorrect() {
        int incorrect = 0;
        for (iQuestion question : questions) {
            if (!question.isCorrect()) {
                incorrect++;
            }
        }
        return incorrect;
    }

    public int getUnanswered() {
        int unanswered = 0;
        for (iQuestion question : questions) {
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

    public void runExam() {
        Scanner input = new Scanner(System.in);
        for (iQuestion question : questions) {
            question.show();

            System.out.println("Write your answer: ");
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            question.checkAnswer(answer);
        }
    }
}
