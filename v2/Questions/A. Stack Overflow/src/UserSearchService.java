import java.util.List;

public class UserSearchService {
    private User user;
    private UserSearchStrategy userSearchStrategy;

    public UserSearchService(User user) {
        this.user = user;
    }

    public void setUserSearchStrategy(UserSearchStrategy userSearchStrategy) {
        this.userSearchStrategy = userSearchStrategy;
    }

    public List<Question> search(String query) {
        return this.userSearchStrategy.searchQuestion(this.user, query);
    }
}
