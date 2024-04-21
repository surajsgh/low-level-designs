import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Theater {
    private static int idCounter = 0;
    private int id;
    private String name;
    private String address;
    private int capacity;
    private ArrayList<Show> shows;

    public Theater(String name, String address, int capacity) {
        idCounter += 1;
        this.id = idCounter;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
        this.shows = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public ArrayList<Show> getShows() {
        return shows;
    }

    public void setShows(ArrayList<Show> shows) {
        this.shows = shows;
    }
}

