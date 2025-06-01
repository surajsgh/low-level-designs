public class UserUpVote implements UserVoteStrategy{
    @Override
    public void vote(User user, Post post) {
        post.getVote().add(new Vote(user, post, VoteType.UPVOTE));
        ReputationService.upVoteHandler(post);
    }
}
