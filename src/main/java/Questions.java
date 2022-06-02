import java.util.LinkedList;
import java.util.Objects;

public class Questions {
    LinkedList<String> popQuestions = new LinkedList<>();
    LinkedList<String> scienceQuestions = new LinkedList<>();
    LinkedList<String> sportsQuestions = new LinkedList<>();
    LinkedList<String> rockQuestions = new LinkedList<>();
    LinkedList<String>[] QuestionsList;
    Questions(int numberOfQuestions){
        String[] Categories = new Category().returnAllCategories();
        QuestionsList = new LinkedList[Categories.length];
        for (int i = 0; i < Categories.length ; i++) {
            QuestionsList[i] = new LinkedList<String>();
        }
        for (int j = 0; j < QuestionsList.length ; j++) {
            for (int i = 0; i < numberOfQuestions; i++) {
                QuestionsList[j].addLast(Categories[j]+" Question " + i);
            }
        }
    }
    public String askQuestion(String currentCategory) {
        String Result = null;
        for (int i = 0; i < QuestionsList.length; i++) {
            if (QuestionsList[i].getLast().contains(currentCategory)){
                Result = QuestionsList[i].removeFirst();
                break;
            }
        }

        System.out.println(Result);
        return Result;
    }
}
