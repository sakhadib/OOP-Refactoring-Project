import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.List;

public class ExamSaver {

    private static ExamSaver instance;
    private ExamSaver() {}

    public static ExamSaver getInstance() {
        if (instance == null) {
            instance = new ExamSaver();
        }
        return instance;
    }

    public final String drive = "C:\\";
    public final String folder = "solvishR\\";
    public final String file = "exam.txt";

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


    public void saveExam(Exam e){
        String examType = e.getClass().getSimpleName();
        String correct = String.valueOf(e.getCorrect());
        String wrong = String.valueOf(e.getIncorrect());
        String skip = String.valueOf(e.getUnanswered());
        String score = String.valueOf(e.getScore());

        String thisexam = examType + "," + correct + "," + wrong + "," + skip + "," + score;

        Path filePath = Paths.get(this.drive + this.folder + this.file);
        List<String> lines = Arrays.asList(thisexam);

        try {
            Files.write(filePath, lines, StandardOpenOption.APPEND);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void showHistory(){
        Path filePath = Paths.get(this.drive + this.folder + this.file);
        try {
            List<String> lines = Files.readAllLines(filePath);
            System.out.println("Exam History: ");
            System.out.println("The Exam Type\t|\tCr\t|\tWr\t|\tSk\t|\tScore");
            System.out.println("---------------------------------------------------------------");
            for(String line : lines){
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


    public void deleteHistory(){
        Path filePath = Paths.get(this.drive + this.folder + this.file);
        try {
            Files.delete(filePath);
            System.out.println("History deleted");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
