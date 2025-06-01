public class Comment extends Post {
    private int id;
    private Post parentPost;
    private User user;
    private String content;

    public Comment(String content, User user) {
        super(content, user);
    }
}
