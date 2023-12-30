import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<iQuestion> questions = new ArrayList<iQuestion>();
        questions.add(new AdditionQuestion());
        questions.add(new SubtractionQuestion());

        iExam exam = new NonTimedExam(1);
        for (iQuestion question : questions) {
            exam.addQuestion(question);
        }
        exam.runExam();
    }
}