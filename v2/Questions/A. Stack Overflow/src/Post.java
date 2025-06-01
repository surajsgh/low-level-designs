import java.util.ArrayList;
import java.util.List;

public abstract class Post {
    private int id = 0;
    private String content;
    private User user;
    private List<Vote> vote = new ArrayList<>();

    public Post(String content, User user) {
        this.id += 1;
        this.content = content;
        this.user = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getUser() {
        return user;
    }

    public List<Vote> getVote() {
        return this.vote;
    }
}
