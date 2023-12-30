import java.util.List;
import java.util.Scanner;

public class ExamFactory {
    private static ExamFactory instance = new ExamFactory();
    private ExamFactory() {}
    public static ExamFactory getInstance() {
        if(instance == null) {
            instance = new ExamFactory();
        }
        return instance;
    }

    public Exam getExam() {
        return new NonTimedExam();
    }

    public Exam getExam(int timeLimit) {
        try{
            return new TimedExam(timeLimit);
        }
        catch(Exception e){
            throw new IllegalArgumentException("Time limit must be a positive integer in minutes");
        }
    }

    public Exam getExamChoice(){
        Exam exam;

        System.out.println("What type of exam do you want?");
        System.out.print("[Timed]\t|\t");
        System.out.print("[Non-timed]\n");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        if(choice.equals("timed")){
            System.out.println("Enter time limit in minutes: ");
            int timeLimit = input.nextInt();
            exam = getExam(timeLimit);
        }

        else if(choice.equals("non-timed")){
            exam = getExam();
        }
        else{
            throw new IllegalArgumentException("Exam type not found");
        }

        QuestionFactory qf = QuestionFactory.getInstance();
        List<Question> questions = qf.getQuestionChoice();

        exam.setQuestions(questions);

        return exam;
    }
}
