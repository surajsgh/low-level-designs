public class Player {
    int id;
    int counter = 0;
    int position;

    public Player(int position) {
        this.counter += 1;
        this.id = this.counter;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
