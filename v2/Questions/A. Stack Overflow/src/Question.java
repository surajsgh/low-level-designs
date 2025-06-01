import java.util.ArrayList;
import java.util.List;

public class Question extends Post {
    private String title;

    private List<Tag> tag = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public Question(String content, User user, String title) {
        super(content, user);
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public List<Tag> getTag() {
        return tag;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Question{" +
                "title='" + title + '\'' +
                ", tag=" + tag +
                ", answers=" + answers +
                ", comments=" + comments +
                '}';
    }
}
