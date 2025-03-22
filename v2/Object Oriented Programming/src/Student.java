public class Student extends Member {
    private static final int MAX_BOOK = 3;

    public Student(int id, String name, String department) {
        super(id, name, department);
    }

    @Override
    public void borrowBook() {
        System.out.println(this.getName() + " (Student) is borrowing a book from the library. Max allowed books: " + MAX_BOOK);
    }
}
