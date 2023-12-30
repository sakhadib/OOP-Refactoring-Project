import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * The TimedExam class represents a timed exam, extending the abstract Exam class.
 * It allows the user to run the exam with a specified time limit, displaying questions, receiving answers, and showing results.
 * This class can be instantiated with a pre-defined list of questions or an empty list.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class TimedExam extends Exam {
    /**
     * The time limit for the timed exam in minutes.
     */
    private int timeLimit;

    /**
     * Constructs a TimedExam with a pre-defined list of questions and a time limit.
     *
     * @param questions The list of questions for the exam.
     * @param timeLimit The time limit for the exam in minutes.
     */
    public TimedExam(List<Question> questions, int timeLimit) {
        this.questions = questions;
        this.timeLimit = timeLimit;
    }

    /**
     * Constructs a TimedExam with a time limit and an empty list of questions.
     *
     * @param timeLimit The time limit for the exam in minutes.
     */
    public TimedExam(int timeLimit) {
        this.timeLimit = timeLimit;
        this.questions = new ArrayList<Question>();
    }

    /**
     * Runs the timed exam by displaying questions, receiving answers within the time limit, and showing results.
     */
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
