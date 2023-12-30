import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class TimedExam implements iExam{
    List<iQuestion> questions;
    int timeLimit;

    public TimedExam(List<iQuestion> questions, int timeLimit) {
        this.questions = questions;
        this.timeLimit = timeLimit;
    }

    public TimedExam(int timeLimit) {
        this.timeLimit = timeLimit;
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
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Scanner input = new Scanner(System.in);

        for (iQuestion question : questions) {
            question.show();
            System.out.println("Enter your answer: ");

            Future<String> future = executor.submit(() -> input.nextLine());

            try {
                String answer = future.get(timeLimit, TimeUnit.MINUTES);
                question.checkAnswer(answer);
            } catch (TimeoutException e) {
                future.cancel(true);
                System.out.println("Time's up!");
                break;
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }

        executor.shutdownNow();
    }
}
