import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * The NonTimedExam class represents a non-timed exam, extending the abstract Exam class.
 * It allows the user to run the exam by displaying questions, receiving answers, and showing results.
 * This class can be instantiated with a pre-defined list of questions or an empty list.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class NonTimedExam extends Exam {

    /**
     * Constructs a NonTimedExam with a pre-defined list of questions.
     *
     * @param questions The list of questions for the exam.
     */
    public NonTimedExam(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Constructs a NonTimedExam with an empty list of questions.
     */
    public NonTimedExam() {
        this.questions = new ArrayList<Question>();
    }

    /**
     * Runs the non-timed exam by displaying questions, receiving answers, and showing results.
     * Allows skipping questions by entering specific keywords.
     */
    @Override
    public void runExam() {
        Scanner input = new Scanner(System.in);
        for (Question question : questions) {
            question.show();

            System.out.println("Write your answer: ");
            String answer = input.nextLine();
            answer = answer.toLowerCase();

            if (answer.equals("s") || answer.equals("S") || answer.equals("skip") || answer.equals("skipped") || answer.equals("skip question")) {
                System.out.println("Question skipped");
                continue;
            }

            question.checkAnswer(answer);
        }
        showResults();
    }
}
