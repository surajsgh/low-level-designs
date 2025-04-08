public class Main {
    public static void main(String[] args) {
        //  SINGLE THREADED ENV
        /*
        Singleton kitKat = Singleton.getInstance("Kit-Kat");
        Singleton snicker = Singleton.getInstance("Snicker");
        System.out.println(kitKat.value);
        System.out.println(snicker.value);

        OUTPUT:
        Kit-Kat
        Kit-Kat
        */

        //  MULTI-THREADED ENV
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();

        //  THREAD-SAFE SINGLETON
        ThreadSafeSingleton first = ThreadSafeSingleton.getInstance();
        ThreadSafeSingleton second = ThreadSafeSingleton.getInstance();
        System.out.println(first==second);
    }

    static class ThreadFoo implements Runnable {
        @Override
        public void run() {
            Singleton foo = Singleton.getInstance("Foo");
            System.out.println(foo.value);
        }
    }

    static class ThreadBar implements Runnable {
        @Override
        public void run() {
            Singleton bar = Singleton.getInstance("Bar");
            System.out.println(bar.value);
        }
    }
}