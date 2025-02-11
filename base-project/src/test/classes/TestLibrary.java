package test.classes;

import main.classes.Book;
import main.classes.Library;
import main.classes.SearchByType;
import main.classes.Student;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

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

    @Test
    public void testSearchBooksByID() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 3", "Author 3", 3));
        books.add(new Book("Book 4", "Author 4", 4));
        books.add(new Book("Book 5", "Author 5", 5));

        ArrayList<Object> keys = new ArrayList<Object>();
        keys.add(1);
        keys.add(3);
        keys.add(5);

        Library library = new Library();
        for (Book book : books) library.addBook(book);

        ArrayList<Book> result = library.searchBooks(SearchByType.ID, keys);
        assertEquals(result.get(0), books.get(0));
        assertEquals(result.get(1), books.get(2));
        assertEquals(result.get(2), books.get(4));
        assertEquals(result.size(), 3);
    }

    @Test
    public void testSearchBooksByTitle() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 1", "Author 3", 3));
        books.add(new Book("Book 1", "Author 4", 4));
        books.add(new Book("Book 1", "Author 5", 5));

        ArrayList<Object> keys = new ArrayList<Object>();
        keys.add("Book 1");

        Library library = new Library();
        for (Book book : books) library.addBook(book);

        ArrayList<Book> result = library.searchBooks(SearchByType.TITLE, keys);
        assertEquals(result.get(0), books.get(0));
        assertEquals(result.get(1), books.get(2));
        assertEquals(result.get(2), books.get(3));
        assertEquals(result.get(3), books.get(4));
        assertEquals(result.size(), 4);
    }

    @Test
    public void testSearchBooksByAuthor() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book 1", "Author 1", 1));
        books.add(new Book("Book 2", "Author 2", 2));
        books.add(new Book("Book 3", "Author 3", 3));
        books.add(new Book("Book 4", "Author 1", 4));
        books.add(new Book("Book 5", "Author 5", 5));

        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Author 1");
        keys.add("Author 2");

        Library library = new Library();
        for (Book book : books) library.addBook(book);

        ArrayList<Book> result = library.searchBooks(SearchByType.AUTHOR, keys);
        assertEquals(result.get(0), books.get(0));
        assertEquals(result.get(1), books.get(1));
        assertEquals(result.get(2), books.get(3));
        assertEquals(result.size(), 3);
    }

    @Test
    public void testSearchStudentByID() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Student 1", 1));
        students.add(new Student("Student 1", 2));
        students.add(new Student("Student 1", 3));
        students.add(new Student("Student 1", 4));
        students.add(new Student("Student 1", 5));

        ArrayList<Object> keys = new ArrayList<>();
        keys.add("Student 1");

        Library library = new Library();
        for (Student student : students) library.addStudent(student);

        ArrayList<Student> result = library.searchStudents(SearchByType.NAME, keys);
        assertEquals(result.get(0), students.get(0));
        assertEquals(result.get(1), students.get(1));
        assertEquals(result.get(2), students.get(2));
        assertEquals(result.get(3), students.get(3));
        assertEquals(result.get(4), students.get(4));
        assertEquals(result.size(), 5);
    }

    @Test
    public void testSearchStudentByName() {
        ArrayList<Student> students = new ArrayList<>();
        students.add(new Student("Student 1", 1));
        students.add(new Student("Student 2", 2));
        students.add(new Student("Student 3", 3));
        students.add(new Student("Student 4", 4));
        students.add(new Student("Student 5", 4));

        ArrayList<Object> keys = new ArrayList<>();
        keys.add(3);
        keys.add(4);

        Library library = new Library();
        for (Student student : students) library.addStudent(student);

        ArrayList<Student> result = library.searchStudents(SearchByType.ID, keys);
        assertEquals(result.get(0), students.get(2));
        assertEquals(result.get(1), students.get(3));
        assertEquals(result.get(2), students.get(4));
        assertEquals(result.size(), 3);
    }

    @Test
    public void testReturn2() {
        Student student = new Student("H A", 1);
        Book book = new Book("Arnold", "Schw", 1);

        Library library = new Library();
        library.addStudent(student);

        assertFalse(library.returnBook(book, student));
        student.addBook(book);
        assertTrue(library.returnBook(book, student));
    }

    @Test
    public void testLend2(){
        Student student = new Student("H A", 1);
        Book book = new Book("Arnold", "Schw", 1);

        Library library = new Library();
        library.addStudent(student);
        assertFalse(library.lendBook(book, student));

        library.addBook(book);
        assertTrue(library.lendBook(book, student));

        library.addBook(book);
        assertFalse(library.lendBook(book, student));
    }

    @Test
    public void testStudentAndBookDisplayNames(){
        Student student = new Student("H A", 1);
        Library library = new Library();
        library.addStudent(student);

        library.displayStudents();
        assertEquals(student.toString(), "H A|1");

        Book book = new Book("Arnold", "Schw", 1);
        library.addBook(book);

        assertEquals(book.toString(), "Arnold by Schw");
    }
}
