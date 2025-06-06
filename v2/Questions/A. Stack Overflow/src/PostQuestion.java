public class PostQuestion implements PostStrategy{
    @Override
    public void post(User user, Post question) {
        if (!(question instanceof Question)) {
            throw new RuntimeException("Different Post!");
        }
        user.getQuestions().add((Question) question);
        ReputationService.postUpdateHandler(user, "Question");
    }
}
