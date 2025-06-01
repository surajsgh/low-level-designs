public class UserAcceptService {
    private User user;

    public UserAcceptService(User user) {
        this.user = user;
    }

    public void markQuestionAccepted(Answer answer) {
        for (Answer newAnswer: user.getAnswers()) {
            if (newAnswer.equals(answer)) {
                answer.setAccepted(true);
            }
        }
    }
}
