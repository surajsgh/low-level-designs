public class PostComment implements PostStrategy{
    @Override
    public void post(User user, Post comment) {
        if (!(comment instanceof Comment)) {
            throw new RuntimeException("Different Post");
        }
        user.getComments().add((Comment) comment);
    }
}
