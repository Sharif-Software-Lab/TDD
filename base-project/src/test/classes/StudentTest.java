package test.classes;

import main.classes.Book;

import main.classes.Student;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentTest {

    @Test
    public void testName(){
        Student student1, student2, student3;
        student1 = new Student("Hamraz A", 1);
        student2 = new Student("Amir B", 2);
        student3 = new Student("Amir A", 3);

        assertEquals("Hamraz A", student1.getName());
        assertEquals("Amir B", student2.getName());
        assertEquals("Amir A", student3.getName());
    }

    @Test
    public void testAddAndRemoveBooks() {
        Student student = new Student("Amir", 1);
        Book book1 = new Book("Java Programming", "Java Programmer", 1);
        Book book2 = new Book("Java Programming 2", "Java Programmer the second", 2);

        assertFalse(student.hasBook(book1));
        student.addBook(book1);
        assertFalse(student.hasBook(book2));
        assertTrue(student.hasBook(book1));
        student.addBook(book2);
        assertTrue(student.hasBook(book2));
        student.removeBook(book1);
        assertFalse(student.hasBook(book1));
        assertTrue(student.hasBook(book2));
    }
}
