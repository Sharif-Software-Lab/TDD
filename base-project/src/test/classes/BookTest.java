package test.classes;

import static org.junit.Assert.assertEquals;
import main.classes.Book;

import org.junit.Test;

public class BookTest {

    @Test
    public void testFields() {
        Book book1, book2;
        book1 = new Book("Ketabe 1", "nevisande 1", 1);
        book2 = new Book("Ketabe 2", "nevisande 2", 2);
        assertEquals(book1.getTitle(), "Ketabe 1");
        assertEquals(book2.getTitle(), "Ketabe 2");
        assertEquals(book1.getAuthor(), "nevisande 1");
        assertEquals(book2.getAuthor(), "nevisande 2");
        assertEquals(book1.toString(), "Ketabe 1 by nevisande 1");
        assertEquals(book2.toString(), "Ketabe 2 by nevisande 2");
    }

}
