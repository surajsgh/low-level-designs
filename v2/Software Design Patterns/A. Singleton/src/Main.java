public class Main {
    public static void main(String[] args) {
        Singleton kitKat = Singleton.getInstance("Kit-Kat");
        Singleton snicker = Singleton.getInstance("Snicker");
        System.out.println(kitKat.value);
        System.out.println(snicker.value);
    }
}