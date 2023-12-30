import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuestionFactory {
    private static QuestionFactory instance;
    private QuestionFactory() {}

    public static QuestionFactory getInstance() {
        if (instance == null) {
            instance = new QuestionFactory();
        }
        return instance;
    }

    public Question getQuestion(String questionType) {
        if(questionType.equals("division")) {
            return new DivisionQuestion();
        }
        else if(questionType.equals("subtraction")) {
            return new SubtractionQuestion();
        }
        else if(questionType.equals("addition")) {
            return new AdditionQuestion();
        }
        else if(questionType.equals("multiplication")) {
            return new MultiplicationQuestion();
        }
        else {
            throw new IllegalArgumentException("Question type not found");
        }
    }

    public List<Question> buildQuestion(int amount, String type){
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Question q = getQuestion(type);
            questions.add(q);
        }
        return questions;
    }

    public List<Question> getQuestionChoice(){
        System.out.println("What type of question do you want?");
        System.out.print("Addition\t|\t");
        System.out.print("Subtraction\t|\t");
        System.out.print("Multiplication\t|\t");
        System.out.print("Division\t|\t");
        System.out.print("All \t\n");
        System.out.println("Enter your choice: ");

        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();
        choice = choice.toLowerCase();

        System.out.println("How many questions do you want?");
        int amount = input.nextInt();

        List<Question> questions = new ArrayList<>();

        if(!choice.equals("all")){
            questions = buildQuestion(amount, choice);
        }
        else{
            int amountPerType = amount / 4;
            int remainder = amount % 4;
            questions = buildQuestion(amountPerType + remainder, "addition");
            questions.addAll(buildQuestion(amountPerType, "subtraction"));
            questions.addAll(buildQuestion(amountPerType, "multiplication"));
            questions.addAll(buildQuestion(amountPerType, "division"));
        }
        Comparator<Question> comp = Comparator.comparingDouble(q -> q.answer);
        questions.sort(comp);
        return questions;
    }


}
