public abstract class User {
    static int countId = 0;
    private int id;
    private String name;

    public User(String name) {
        countId += 1;
        this.id = countId;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
