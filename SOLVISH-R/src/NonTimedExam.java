import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonTimedExam extends Exam{

    public NonTimedExam(List<Question> questions) {
        this.questions = questions;
    }

    public NonTimedExam() {
        this.questions = new ArrayList<Question>();
    }


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
