import java.util.ArrayList;
import java.util.List;

public class UserSearchByTag implements UserSearchStrategy{
    @Override
    public List<Question> searchQuestion(User user, String query) {
        if (query.isEmpty()) {
            System.out.println("Please enter something");
            return new ArrayList<>();
        }
        List<Question> list = new ArrayList<>();
        for (Question question: user.getQuestions()) {
            for (Tag tag: question.getTag()) {
                if (tag.name().equals(query)) {
                    list.add(question);
                }
            }
        }
        return list;
    }
}
