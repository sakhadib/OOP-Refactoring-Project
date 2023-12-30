import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class TimedExam extends Exam{
    int timeLimit;

    public TimedExam(List<Question> questions, int timeLimit) {
        this.questions = questions;
        this.timeLimit = timeLimit;
    }

    public TimedExam(int timeLimit) {
        this.timeLimit = timeLimit;
        this.questions = new ArrayList<Question>();
    }

    @Override
    public void runExam() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        Scanner input = new Scanner(System.in);

        for (Question question : questions) {
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

        showResults();
    }
}
