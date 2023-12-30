import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        while(true){
            ExamSaver es = ExamSaver.getInstance();
            es.checkAndCreateFolder();

            System.out.println("Type [start] to proceed , [exit] to exit the program" +
                    ", [options] to see the options");
            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();
            choice = choice.toLowerCase();

            if(choice.equals("exit")){
                System.out.println("Exiting program...");
                break;
            }
            else if(choice.equals("options")){
                FeatureFactory ff = FeatureFactory.getInstance();
                ff.showFeatureChoice();
                continue;
            }
            else if(!choice.equals("start") && !choice.equals("options")){
                System.out.println("Invalid input");
                continue;
            }

            ExamFactory ef = ExamFactory.getInstance();
            Exam e = ef.getExamChoice();
            e.runExam();
        }
    }
}