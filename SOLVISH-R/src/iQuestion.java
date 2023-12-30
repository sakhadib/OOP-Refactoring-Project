import java.util.List;

public interface iQuestion {
    boolean isCorrect();
    boolean isAnswered();
    String getGivenAnswer();
    String getCorrectAnswer();

    void checkAnswer(String givenAnswer);

    void show();
}
