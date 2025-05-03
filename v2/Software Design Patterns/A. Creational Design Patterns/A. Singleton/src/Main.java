import javax.swing.plaf.synth.SynthTextAreaUI;

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
        /*
        Thread threadFoo = new Thread(new ThreadFoo());
        Thread threadBar = new Thread(new ThreadBar());
        threadFoo.start();
        threadBar.start();

        OUTPUT:
        Bar
        Foo
        */


        //  THREAD-SAFE SINGLETON
        ThreadSafeSingleton first = ThreadSafeSingleton.getInstance("first");
        ThreadSafeSingleton second = ThreadSafeSingleton.getInstance("second");
        System.out.println(first==second);

        Thread threadSafeFoo = new Thread(new ThreadSafeFoo());
        Thread threadSafeBar = new Thread(new ThreadSafeBar());
        threadSafeBar.start();
        threadSafeFoo.start();

        /*
        true
        first
        first
        */
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

    static class ThreadSafeFoo implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton foo = ThreadSafeSingleton.getInstance("Foo");
            System.out.println(foo.value);
        }
    }

    static class ThreadSafeBar implements Runnable {
        @Override
        public void run() {
            ThreadSafeSingleton bar = ThreadSafeSingleton.getInstance("Bar");
            System.out.println(bar.value);
        }
    }
}