import java.util.List;

/**
 * The abstract Exam class represents a generic exam consisting of a list of questions.
 * It provides methods to add questions, set questions, get the number of correct, incorrect, and unanswered questions,
 * calculate the exam score, run the exam, and display the results.
 * This class is meant to be extended by specific exam implementations.
 *
 * @author Adib Sakhawat
 * @version 1.0
 */
public abstract class Exam {
    /**
     * The list of questions in the exam.
     */
    List<Question> questions;

    /**
     * Adds a question to the exam.
     *
     * @param question The question to add to the exam.
     */
    public void addQuestion(Question question) {
        questions.add(question);
    }

    /**
     * Sets the list of questions for the exam.
     *
     * @param questions The list of questions to set for the exam.
     */
    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    /**
     * Gets the number of correct answers in the exam.
     *
     * @return The number of correct answers.
     */
    public int getCorrect() {
        int correct = 0;
        for (Question question : questions) {
            if (question.isCorrect()) {
                correct++;
            }
        }
        return correct;
    }

    /**
     * Gets the number of incorrect answers in the exam.
     *
     * @return The number of incorrect answers.
     */
    public int getIncorrect() {
        int incorrect = 0;
        for (Question question : questions) {
            if (!question.isCorrect() && question.isAnswered()) {
                incorrect++;
            }
        }
        return incorrect;
    }

    /**
     * Gets the number of unanswered questions in the exam.
     *
     * @return The number of unanswered questions.
     */
    public int getUnanswered() {
        int unanswered = 0;
        for (Question question : questions) {
            if (!question.isAnswered()) {
                unanswered++;
            }
        }
        return unanswered;
    }

    /**
     * Calculates the exam score based on correct and incorrect answers.
     *
     * @return The exam score.
     */
    public double getScore() {
        int corr = getCorrect();
        int incorr = getIncorrect();
        double score = corr - (incorr * 0.25);

        return score;
    }

    /**
     * Abstract method to be implemented by specific exam implementations.
     * It represents the process of running the exam.
     */
    public abstract void runExam();

    /**
     * Displays the results of the exam, including the number of correct, incorrect, and unanswered questions, and the score.
     * Saves the exam using ExamSaver.
     */
    public void showResults() {
        System.out.println("Correct: " + getCorrect());
        System.out.println("Incorrect: " + getIncorrect());
        System.out.println("Unanswered: " + getUnanswered());
        System.out.println("Score: " + getScore());

        ExamSaver.getInstance().saveExam(this);
    }
}
