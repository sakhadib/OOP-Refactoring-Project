import java.util.List;
import java.util.Scanner;

/**
 * The ExamFactory class is responsible for creating instances of different types of exams.
 * It follows the Singleton pattern to ensure only one instance is created.
 * It provides methods to get a non-timed exam, a timed exam with a specified time limit, and interactively get user preferences for exam types and questions.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class ExamFactory {
    /**
     * The singleton instance of the ExamFactory.
     */
    private static ExamFactory instance = new ExamFactory();

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private ExamFactory() {}

    /**
     * Gets the singleton instance of the ExamFactory.
     *
     * @return The singleton instance of the ExamFactory.
     */
    public static ExamFactory getInstance() {
        if (instance == null) {
            instance = new ExamFactory();
        }
        return instance;
    }

    /**
     * Gets a non-timed exam with an empty list of questions.
     *
     * @return A non-timed exam.
     */
    public Exam getExam() {
        return new NonTimedExam();
    }

    /**
     * Gets a timed exam with a specified time limit and an empty list of questions.
     *
     * @param timeLimit The time limit for the exam in minutes.
     * @return A timed exam.
     * @throws IllegalArgumentException If the time limit is not a positive integer.
     */
    public Exam getExam(int timeLimit) {
        try {
            return new TimedExam(timeLimit);
        } catch (Exception e) {
            throw new IllegalArgumentException("Time limit must be a positive integer in minutes");
        }
    }

    /**
     * Interactively gets user preferences for exam types and questions, then creates and returns the corresponding exam.
     *
     * @return An exam based on user preferences.
     * @throws IllegalArgumentException If the exam type is not recognized.
     */
    public Exam getExamChoice() {
        Exam exam;

        System.out.println("What type of exam do you want?");
        System.out.print("[Timed]\t|\t");
        System.out.print("[Non-timed]\n");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        if (choice.equals("timed")) {
            System.out.println("Enter time limit in minutes: ");
            int timeLimit = input.nextInt();
            exam = getExam(timeLimit);
        } else if (choice.equals("non-timed")) {
            exam = getExam();
        } else {
            throw new IllegalArgumentException("Exam type not found");
        }

        QuestionFactory qf = QuestionFactory.getInstance();
        List<Question> questions = qf.getQuestionChoice();

        exam.setQuestions(questions);

        return exam;
    }
}
