public class Faculty extends Member{
    private static final int MAX_BOOK = 5;

    public Faculty(int id, String name, String department) {
        super(id, name, department);
    }

    @Override
    public void borrowBook() {
        System.out.println(this.getName() + " (Faculty) is borrowing a book from the library. Max allowed books: " + MAX_BOOK);
    }
}
