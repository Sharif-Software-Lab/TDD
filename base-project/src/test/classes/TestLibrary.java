package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.Student;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestLibrary {
    @Test
    public void testLend() {
        Student student1 = new Student("John", 1);
        Student student2 = new Student("Jane", 2);

        Book book1 = new Book("Book 1", "Author 1", 1);

        Library library = new Library();

        assertFalse(library.lendBook(book1, student1));

        library.addBook(book1);
        assertFalse(library.lendBook(book1, student1));

        library.addStudent(student1);
        assertTrue(library.lendBook(book1, student1));
        assertTrue(student1.hasBook(book1));

        assertFalse(library.lendBook(book1, student2));

    }

    @Test
    public void testReturn() {
        Student student1 = new Student("John", 1);

        Book book1 = new Book("Book 1", "Author 1", 1);

        Library library = new Library();

        assertFalse(library.returnBook(book1, student1));

        student1.addBook(book1);
        assertFalse(library.returnBook(book1, student1));

        library.addStudent(student1);
        assertTrue(library.returnBook(book1, student1));
        assertFalse(student1.hasBook(book1));
    }
}
