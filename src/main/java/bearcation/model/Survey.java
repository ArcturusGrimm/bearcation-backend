package bearcation.model;

import java.util.List;

public class Survey {

    private List<String> answerList;

    public Survey(List<String> answerList) {
        this.answerList = answerList;
    }

    public List<String> getAnswerList() {
        return answerList;
    }
}
