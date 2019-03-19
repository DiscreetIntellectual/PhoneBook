
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;

class PhoneBookTest {

    private PhoneBook testBook = new PhoneBook();

    @Test
    @Tag("addName")
    void addName() {
        testBook.addName("Test");
        assertTrue(testBook.getNames().contains("Test"));
        testBook.addName("Test");
        assertEquals(1, testBook.getNames().size());
    }

    @Test
    @Tag("addPhone")
    void addPhone() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        assertTrue(testBook.getPhones("Test").contains("+7"));

        assertFalse(testBook.getNames().contains("NotTest"));
        testBook.addPhone("+9", "NotTest");
        assertTrue(testBook.getPhones("NotTest").contains("+9"));

        assertThrows(IllegalArgumentException.class, () -> testBook.addPhone("^_^", "0_0"));
    }


    @Test
    @Tag("deletePhone")
    void deletePhone() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        testBook.deletePhone("+7", "Test");
        assertFalse(testBook.getPhones("Test").contains("+7"));
        assertFalse(testBook.deletePhone("+9", "NotTest"));
    }

    @Test
    @Tag("deleteName")
    void deleteName() {
        testBook.addName("Test");
        testBook.addName("NotTest");
        testBook.deleteName("Test");
        assertFalse(testBook.getNames().contains("Test"));
        assertFalse(testBook.deleteName("ActuallyTest"));
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
        assertNull(testBook.getPhones("NotTest"));
    }

    @Test
    @Tag("getNameByPhone")
    void getNameByPhone() {
        testBook.addName("Test");
        testBook.addPhone("+7", "Test");
        assertEquals("Test", testBook.getNameByPhone("+7"));
        assertNull(testBook.getNameByPhone("+9"));
    }
}
