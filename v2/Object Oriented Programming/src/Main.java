public class Main {
    public static void main(String[] args) {
        Book physics = new Book(1, "Physics", "HC Verma");
        Book chemistry = new Book(2, "Chemistry", "Alok Tiwari");

        System.out.println(physics.toString());
        System.out.println(chemistry.toString());

        Member student = new Student(101, "Ramesh", "CSE");
        Member teacher = new Faculty(201, "Suresh", "CSE");

        student.borrowBook();
        teacher.borrowBook();

        Library library = new Library();
        library.issue(student.getName());
        library.issue(teacher.getName(), chemistry.getName());
    }
}