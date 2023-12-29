import java.util.List;
import java.util.Scanner;

public class NonTimedExam implements iExam{
    int examID;
    List<iQuestion> questions;

    public NonTimedExam(int examID, List<iQuestion> questions) {
        this.examID = examID;
        this.questions = questions;
    }

    public NonTimedExam(int examID) {
        this.examID = examID;
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
            String Question = question.getQuestion();
            String OptionA = question.getOptionA();
            String OptionB = question.getOptionB();
            String OptionC = question.getOptionC();
            String OptionD = question.getOptionD();

            System.out.println(Question);
            System.out.println("A. " + OptionA);
            System.out.println("B. " + OptionB);
            System.out.println("C. " + OptionC);
            System.out.println("D. " + OptionD);

            System.out.println("Write your answer: ");
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            question.checkAnswer(answer);
        }
    }
}
