public class PostAnswer implements PostStrategy{
    @Override
    public void post(User user, Post answer) {
        if (!(answer instanceof Answer)) {
            throw new RuntimeException("Different Post");
        }
        user.getAnswers().add((Answer) answer);
    }
}
