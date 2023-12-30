public class QuestionFactory {
    private static QuestionFactory instance = new QuestionFactory();
    private QuestionFactory() {}
    public static QuestionFactory getInstance() {
        if(instance == null) {
            instance = new QuestionFactory();
        }
        return instance;
    }

    public iQuestion getQuestion(String type) {
        if(type.equals("addition")) {
            return new AdditionQuestion();
        } else if(type.equals("subtraction")) {
            return new SubtractionQuestion();
        } else if(type.equals("multiplication")) {
            return new MultiplicationQuestion();
        } else if(type.equals("division")) {
            return new DivisionQuestion();
        } else {
            return null;
        }
    }

}
