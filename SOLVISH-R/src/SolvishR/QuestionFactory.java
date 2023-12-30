package SolvishR;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * The SolvishR.QuestionFactory class is responsible for creating instances of different types of questions.
 * It follows the Singleton pattern to ensure only one instance is created.
 * It provides methods to generate specific types of questions, build a list of questions, and interactively get user preferences for question types and quantity.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public class QuestionFactory {
    private static QuestionFactory instance;

    private QuestionFactory() {}

    /**
     * Gets the singleton instance of the SolvishR.QuestionFactory.
     *
     * @return The singleton instance of the SolvishR.QuestionFactory.
     */
    public static QuestionFactory getInstance() {
        if (instance == null) {
            instance = new QuestionFactory();
        }
        return instance;
    }

    /**
     * Gets a specific type of question based on the provided question type.
     *
     * @param questionType The type of question to create ("addition", "subtraction", "multiplication", "division").
     * @return An instance of the specified question type.
     * @throws IllegalArgumentException If the question type is not recognized.
     */
    public Question getQuestion(String questionType) {
        if (questionType.equals("division")) {
            return new DivisionQuestion();
        } else if (questionType.equals("subtraction")) {
            return new SubtractionQuestion();
        } else if (questionType.equals("addition")) {
            return new AdditionQuestion();
        } else if (questionType.equals("multiplication")) {
            return new MultiplicationQuestion();
        } else {
            throw new IllegalArgumentException("SolvishR.Question type not found");
        }
    }

    /**
     * Builds a list of questions of a specific type.
     *
     * @param amount The number of questions to generate.
     * @param type The type of question to create ("addition", "subtraction", "multiplication", "division").
     * @return A list of questions of the specified type.
     */
    public List<Question> buildQuestion(int amount, String type) {
        List<Question> questions = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            Question q = getQuestion(type);
            questions.add(q);
        }
        return questions;
    }

    /**
     * Interactively gets user preferences for question types and quantity.
     *
     * @return A list of questions based on the user's preferences.
     */
    public List<Question> getQuestionChoice() {
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

        if (!choice.equals("all")) {
            questions = buildQuestion(amount, choice);
        } else {
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
