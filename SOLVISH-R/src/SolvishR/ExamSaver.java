package SolvishR;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Arrays;
import java.util.List;

/**
 * The SolvishR.ExamSaver class is responsible for saving exam results, showing exam history, and deleting exam history records.
 * It follows the Singleton pattern to ensure only one instance is created.
 * The class uses file operations to manage exam history data.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class ExamSaver {

    /**
     * The singleton instance of the SolvishR.ExamSaver.
     */
    private static ExamSaver instance;

    /**
     * Private constructor to enforce the singleton pattern.
     */
    private ExamSaver() {}

    /**
     * Gets the singleton instance of the SolvishR.ExamSaver.
     *
     * @return The singleton instance of the SolvishR.ExamSaver.
     */
    public static ExamSaver getInstance() {
        if (instance == null) {
            instance = new ExamSaver();
        }
        return instance;
    }

    /**
     * The drive where exam history data is stored.
     */
    public final String drive = "C:\\";

    /**
     * The folder where exam history data is stored.
     */
    public final String folder = "solvishR\\";

    /**
     * The file where exam history data is stored.
     */
    public final String file = "exam.txt";

    /**
     * Checks and creates the folder and file for storing exam history data.
     */
    public void checkAndCreateFolder() {
        Path folderPath = Paths.get(this.drive + this.folder);
        try {
            if (!Files.exists(folderPath)) {
                Files.createDirectory(folderPath);
            }

            Path filePath = Paths.get(this.drive + this.folder + this.file);
            if (!Files.exists(filePath)) {
                Files.createFile(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Saves exam results to the exam history file.
     *
     * @param e The exam whose results need to be saved.
     */
    public void saveExam(Exam e) {
        String examType = e.getClass().getSimpleName();
        String correct = String.valueOf(e.getCorrect());
        String wrong = String.valueOf(e.getIncorrect());
        String skip = String.valueOf(e.getUnanswered());
        String score = String.valueOf(e.getScore());

        String thisExam = examType + "," + correct + "," + wrong + "," + skip + "," + score;

        Path filePath = Paths.get(this.drive + this.folder + this.file);
        List<String> lines = Arrays.asList(thisExam);

        try {
            Files.write(filePath, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Shows the exam history by reading and displaying data from the exam history file.
     */
    public void showHistory() {
        Path filePath = Paths.get(this.drive + this.folder + this.file);
        try {
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("SolvishR.Exam History: ");
            System.out.println("The SolvishR.Exam Type\t|\tCr\t|\tWr\t|\tSk\t|\tScore");
            System.out.println("---------------------------------------------------------------");
            for (String line : lines) {
                String[] exam = line.split(",");
                if (exam.length < 5) {
                    continue;
                }
                String examType = exam[0];
                String correct = exam[1];
                String wrong = exam[2];
                String skip = exam[3];
                String score = exam[4];

                System.out.println(examType + "\t|\t" + correct + "\t|\t" + wrong + "\t|\t" + skip + "\t|\t" + score);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes the exam history file.
     */
    public void deleteHistory() {
        Path filePath = Paths.get(this.drive + this.folder + this.file);
        try {
            Files.delete(filePath);
            System.out.println("History deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
