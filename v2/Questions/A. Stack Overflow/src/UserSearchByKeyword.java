import java.util.ArrayList;
import java.util.List;

public class UserSearchByKeyword implements UserSearchStrategy{
    @Override
    public List<Question> searchQuestion(User user, String query) {
        if (query.isEmpty()) {
            System.out.println("Please enter something");
            return new ArrayList<>();
        }
        return user.getQuestions().stream().filter(question -> question.getTitle().contains(query)).toList();
    }
}
