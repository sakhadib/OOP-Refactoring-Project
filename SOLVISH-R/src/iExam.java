public interface iExam {
    int getCorrect();
    int getIncorrect();
    int getUnanswered();
    double getScore();
    void runExam();

    void addQuestion(iQuestion question);

}
