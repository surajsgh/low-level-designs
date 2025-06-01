public class Vote {
    private int id = 0;
    private User user;
    private Post parentPost;
    private VoteType voteType;

    public Vote(User user, Post parentPost, VoteType voteType) {
        this.id += 1;
        this.user = user;
        this.parentPost = parentPost;
        this.voteType = voteType;
    }
}
