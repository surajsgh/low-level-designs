import javax.xml.stream.events.Comment;
import java.util.List;

public class Answer extends Post {
    private boolean isAccepted = false;
    private Question question;
    private List<Comment> comments;

    public Answer(String content, User user) {
        super(content, user);
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean accepted) {
        isAccepted = accepted;
    }
}
