public class UserVoteService {
    private User user;
    private Post post;
    private UserVoteStrategy userVoteStrategy;

    public UserVoteService(User user, Post post) {
        this.user = user;
        this.post = post;
    }

    public void setUserVoteStrategy(UserVoteStrategy userVoteStrategy) {
        this.userVoteStrategy = userVoteStrategy;
    }

    public synchronized void castVote() {
        this.userVoteStrategy.vote(this.user, this.post);
    }
}
