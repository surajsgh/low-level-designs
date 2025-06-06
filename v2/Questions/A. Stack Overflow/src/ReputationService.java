public class ReputationService {
    public static void upVoteHandler(Post post) {
        if (post instanceof Question) {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.QUESTION_UPVOTE);
        }
        else if (post instanceof Answer) {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.ANSWER_UPVOTE);
        }
        else {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.COMMENT_UPVOTE);
        }
    }

    public static void downVoteHandler(Post post) {
        if (post instanceof Question) {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.QUESTION_DOWNVOTE);
        }
        else if (post instanceof Answer) {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.ANSWER_DOWNVOTE);
        }
        else {
            post.getUser().setReputation(post.getUser().getReputation() + ReputationHandler.COMMENT_DOWNVOTE);
        }
    }

    public static void postUpdateHandler(User user, String post) {
       if (post.equals("Question")) {
           user.setReputation(user.getReputation() + ReputationHandler.POST_QUESTION);
       }
       else if (post.equals("Comment")) {
           user.setReputation(user.getReputation() + ReputationHandler.POST_COMMENT);
       }
       else {
           user.setReputation(user.getReputation() + ReputationHandler.POST_ANSWER);
       }
    }
}
