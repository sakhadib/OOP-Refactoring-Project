import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("How many questions would you like to answer?");
        int numQuestions = scanner.nextInt();

        for (int i = 0; i < numQuestions; i++) {
            int questionType = (int) (Math.random() * 4);
            switch (questionType) {
                case 0:
                    questions.add(new AdditionQuestion());
                    break;
                case 1:
                    questions.add(new SubtractionQuestion());
                    break;
                case 2:
                    questions.add(new MultiplicationQuestion());
                    break;
                case 3:
                    questions.add(new DivisionQuestion());
                    break;
            }
        }

        Exam exam = ExamFactory.getInstance().getExam();
        exam.setQuestions(questions);
        exam.runExam();

    }
}