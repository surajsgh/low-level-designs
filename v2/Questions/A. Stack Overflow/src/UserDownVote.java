public class UserDownVote implements UserVoteStrategy{
    @Override
    public void vote(User user, Post post) {
        post.getVote().add(new Vote(user, post, VoteType.DOWNVOTE));
        ReputationService.downVoteHandler(post);
    }
}
