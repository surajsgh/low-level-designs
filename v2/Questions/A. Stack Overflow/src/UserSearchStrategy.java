import java.util.List;

public interface UserSearchStrategy {
    List<Question> searchQuestion(User user, String query);
}
