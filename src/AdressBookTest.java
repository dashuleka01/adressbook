import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class AdressBookTest {
    @Test
    void addPerson() {
        adress adress1 = new adress("Nevskiy", 54, 10);
        String name = "Sasha";
        AdressBook book1 = new AdressBook();
        //book1.book.put("", new adress("", 0, 0));
        assertTrue(book1.addPerson(name, adress1).book.get(name) == adress1);
    }

    @Test
    void deletePerson() {
        adress adress1 = new adress("Nevskiy", 54, 10);
        String name = "Sasha";
        assertFalse(new AdressBook().deletePerson(name).book.containsKey(name));
    }

    @Test
    void changeAdress() {
    }

    @org.junit.jupiter.api.Test
    void getAdress() {
    }

}