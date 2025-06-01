public class UserService {
    private PostStrategy postStrategy;

    public void setPostStrategy(PostStrategy postStrategy) {
        this.postStrategy = postStrategy;
    }

    public void post(User user, Post post) {
        this.postStrategy.post(user, post);
    }
}
