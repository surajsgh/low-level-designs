public class Library {
    public void issue(String member) {
        System.out.println("Issuing book to " + member);
    }

    public void issue(String member, String book) {
        System.out.println("Issuing book: " + book + " to " + member);
    }
}
