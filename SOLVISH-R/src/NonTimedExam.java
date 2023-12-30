import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NonTimedExam extends Exam{

    public NonTimedExam(List<iQuestion> questions) {
        this.questions = questions;
    }

    public NonTimedExam() {
        this.questions = new ArrayList<iQuestion>();
    }


    @Override
    public void runExam() {
        Scanner input = new Scanner(System.in);
        for (iQuestion question : questions) {
            question.show();

            System.out.println("Write your answer: ");
            String answer = input.nextLine();
            answer = answer.toLowerCase();
            question.checkAnswer(answer);
        }
        showResults();
    }

}
