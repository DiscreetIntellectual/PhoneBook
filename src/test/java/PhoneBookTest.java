
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PhoneBookTest {

    private PhoneBook testBook = new PhoneBook();

    @Test
    @Tag("addName")
    void addName() {
        testBook.addName("Test");
        assertTrue(testBook.book.containsKey("Test"));
    }

    @Test
    @Tag("addPhone")
    void addPhone() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        assertTrue(testBook.book.get("Test").contains("+7"));

        testBook.addPhone("+9", "NotTest");
        assertTrue(testBook.book.get("NotTest") == null);
    }

    @Test
    @Tag("deletePhone")
    void deletePhone() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        testBook.deletePhone("+7", "Test");
        assertFalse(testBook.book.get("Test").contains("+7"));
    }

    @Test
    @Tag("deleteName")
    void deleteName() {
        testBook.addName("Test");
        testBook.addName("NotTest");
        testBook.deleteName("Test");
        assertFalse(testBook.book.containsKey("Test"));
    }

    @Test
    @Tag("getPhones")
    void getPhones() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        testBook.addPhone("+9", "Test");
        ArrayList<String> check = new ArrayList<String>(2);
        check.add("+7");
        check.add("+9");
        assertTrue(testBook.getPhones("Test").containsAll(check));
        assertTrue(testBook.getPhones("NotTest").isEmpty());
    }

    @Test
    @Tag("getName")
    void getName() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        assertEquals("Test", testBook.getName("+7"));
        assertEquals("This number is not associated with any name", testBook.getName("+9"));
    }
}
