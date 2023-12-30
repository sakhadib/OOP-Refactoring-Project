import java.util.Scanner;

public class FeatureFactory {
    private static FeatureFactory instance;
    private FeatureFactory() {}

    public static FeatureFactory getInstance() {
        if (instance == null) {
            instance = new FeatureFactory();
        }
        return instance;
    }

    public void showFeatureChoice(){
        System.out.println("What do you want to do?");
        System.out.print("[history]\t|\t");
        System.out.print("[start]\t|\t");
        System.out.print("[delete-history] \t\n");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        if(choice.equals("history")){
            ExamSaver es = ExamSaver.getInstance();
            es.showHistory();
        }
        else if(choice.equals("start")){
            ExamFactory ef = ExamFactory.getInstance();
            Exam e = ef.getExamChoice();
            e.runExam();
        }
        else if(choice.equals("delete-history")){
            ExamSaver es = ExamSaver.getInstance();
            es.deleteHistory();
        }
        else{
            throw new IllegalArgumentException("Feature not found");
        }
    }
}
