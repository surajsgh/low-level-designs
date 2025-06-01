import java.util.ArrayList;
import java.util.List;

public class User {
    private int id = 0;
    private String username;
    private int reputation = 0;
    private List<Question> questions = new ArrayList<>();
    private List<Answer> answers = new ArrayList<>();
    private List<Comment> comments = new ArrayList<>();

    public User(String username) {
        this.id += 1;
        this.username = username;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public String getUsername() {
        return username;
    }

    public int getId() {
        return id;
    }

    public int getReputation() {
        return reputation;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
