import java.util.ArrayList;

interface StockObservable {
    public void add(NotificationObserver notificationObserver);
    public void remove(NotificationObserver notificationObserver);
    public void inform();
    public void set(int stockAmount);
    public int get();
}

class IphoneObservable implements StockObservable {
    ArrayList<NotificationObserver> list;
    int stock = 0;

    public IphoneObservable() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(NotificationObserver notificationObserver) {
        list.add(notificationObserver);
    }

    @Override
    public void remove(NotificationObserver notificationObserver) {
        list.remove(notificationObserver);
    }

    @Override
    public void inform() {
        for (NotificationObserver notificationObserver: list) {
            notificationObserver.update();
        }
    }

    @Override
    public void set(int stockAmount) {
        if (stock==0) {
            inform();
        }
        stock += stockAmount;
    }

    @Override
    public int get() {
        return stock;
    }
}

interface NotificationObserver {
    public void update();
}

class MobilePhoneObserver implements NotificationObserver {
    String username;

    public MobilePhoneObserver(String username) {
        this.username = username;
    }

    @Override
    public void update() {
        System.out.println("Stock has been update " + this.username + ".");
    }
}

public class Main {
    public static void main(String[] args) {
        NotificationObserver suraj = new MobilePhoneObserver("Suraj");
        NotificationObserver ganesh = new MobilePhoneObserver("Ganesh");

        StockObservable iPhoneObservable = new IphoneObservable();
        System.out.println("Current stock in the market " + iPhoneObservable.get());

        iPhoneObservable.add(suraj);
        iPhoneObservable.add(ganesh);

        iPhoneObservable.set(10);

        System.out.println("Current stock in the market " + iPhoneObservable.get());
    }
}