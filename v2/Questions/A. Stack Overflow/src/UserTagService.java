public class UserTagService {
    private User user;

    public UserTagService(User user) {
        this.user = user;
    }

    public void addTags(Question question, Tag tag) {
        if (question == null) {
            throw new RuntimeException("Oops! You can add tags to questions only");
        }
        if (!user.equals(question.getUser())) {
            throw new RuntimeException("Invalid user");
        }
        question.getTag().add(tag);
    }
}
