public final class ThreadSafeSingleton {
    private static volatile ThreadSafeSingleton instance;
    public String value;

    private ThreadSafeSingleton(String value) {
        try {
            Thread.sleep(1000);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }
        this.value = value;
    }

    public static ThreadSafeSingleton getInstance(String value) {
        synchronized (ThreadSafeSingleton.class) {
            if (instance==null) {
                instance = new ThreadSafeSingleton(value);
            }
            return instance;
        }
    }
}
