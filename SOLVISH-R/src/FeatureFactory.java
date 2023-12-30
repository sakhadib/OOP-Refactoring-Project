import java.util.Scanner;

/**
 * The FeatureFactory class is responsible for providing user options related to exam features,
 * such as displaying exam history, starting a new exam, or deleting exam history records.
 */
public class FeatureFactory {

    private static FeatureFactory instance;

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private FeatureFactory() {}

    /**
     * Gets the singleton instance of the FeatureFactory.
     *
     * @return The singleton instance of the FeatureFactory.
     */
    public static FeatureFactory getInstance() {
        if (instance == null) {
            instance = new FeatureFactory();
        }
        return instance;
    }

    /**
     * Displays the available features and prompts the user to choose an action.
     * Based on the user's choice, it either shows exam history, starts a new exam, or deletes exam history.
     */
    public void showFeatureChoice() {
        System.out.println("What do you want to do?");
        System.out.print("[history]\t|\t");
        System.out.print("[start]\t|\t");
        System.out.print("[delete-history] \t\n");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        if (choice.equals("history")) {
            ExamSaver es = ExamSaver.getInstance();
            es.showHistory();
        } else if (choice.equals("start")) {
            ExamFactory ef = ExamFactory.getInstance();
            Exam e = ef.getExamChoice();
            e.runExam();
        } else if (choice.equals("delete-history")) {
            ExamSaver es = ExamSaver.getInstance();
            es.deleteHistory();
        } else {
            throw new IllegalArgumentException("Feature not found");
        }
    }
}
