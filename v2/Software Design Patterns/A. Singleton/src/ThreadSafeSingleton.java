public final class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;

    private ThreadSafeSingleton() {

    }

    public static ThreadSafeSingleton getInstance() {
        synchronized (ThreadSafeSingleton.class) {
            if (instance==null) {
                instance = new ThreadSafeSingleton();
            }
            return instance;
        }
    }
}
