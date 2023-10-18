import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    
    private String question, answer;
    private String choice1, choice2, choice3;
    private boolean currentQuestion;
    private ArrayList<String> answerList;

    public Question(String q, String a, String c1, String c2, String c3) {

        question = q;
        answer = a;
        choice1 = c1;
        choice2 = c2;
        choice3 = c3;
        currentQuestion = false;
        answerList = new ArrayList<String>(Arrays.asList(answer, choice1, choice2, choice3));

    }

    public String getAnswer() {
        return answer;
    }

    public String getQuestion() {
        return question;
    }

    public ArrayList<String> getAnswerList() {
        return answerList;
    }

    public boolean isCurrentQuestion() {
        return currentQuestion;
    }

    public void setCurrentQuestion(boolean set) {
        currentQuestion = set;
    }
}