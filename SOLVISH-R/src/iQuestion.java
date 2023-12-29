import java.util.List;

public interface iQuestion {
    boolean isCorrect();
    boolean isAnswered();
    String getGivenAnswer();
    String getCorrectAnswer();

    void checkAnswer(String givenAnswer);

    String getQuestion();
    String getOptionA();
    String getOptionB();
    String getOptionC();
    String getOptionD();
}
