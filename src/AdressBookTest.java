import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AdressBookTest {
    adress adress1 = new adress("Nevskiy", 54, 10);
    adress adress2 = new adress("Moskovskiy", 10, 105);
    adress adress3 = new adress("Nevskiy", 26, 541);
    adress adress4 = new adress("Nevskiy", 26, 123);
    String name = "Sasha";

    @Test
    void addPerson() {
        assertTrue(new AdressBook().addPerson(name, adress1).book.get(name) == adress1);
    }

    @Test
    void deletePerson() {
        assertFalse(new AdressBook().deletePerson(name).book.containsKey(name));
    }

    @Test
    void changeAdress() {
        assertFalse(new AdressBook().changeAdress(name, adress2).book.get(name) == adress2);
        assertTrue(new AdressBook().addPerson(name, adress1).changeAdress(name, adress2).book.get(name) == adress2);
    }

    @Test
    void getAdress() {
        assertEquals(adress1, new AdressBook().addPerson(name, adress1).getAdress(name));
        assertNotEquals(adress1, new AdressBook().addPerson(name, adress2).getAdress(name));
    }

    @Test
    void peopleByStreet() {
        AdressBook myBook = new AdressBook();
        myBook.addPerson("Sasha", adress1);
        myBook.addPerson("Dasha", adress2);
        myBook.addPerson("Masha", adress3);
        myBook.addPerson("Natasha", adress4);

        assertEquals(new HashSet<>(Arrays.asList("Natasha", "Masha", "Sasha")), myBook.peopleByStreet("Nevskiy"));
        assertNotEquals(new HashSet<>(Arrays.asList("Dasha", "Masha", "Sasha")), myBook.peopleByStreet("Nevskiy"));
    }

    @Test
    void peopleByHouse() {
        AdressBook myBook = new AdressBook();
        myBook.addPerson("Sasha", adress1);
        myBook.addPerson("Dasha", adress2);
        myBook.addPerson("Masha", adress3);
        myBook.addPerson("Natasha", adress4);

        assertEquals(new HashSet<>(Arrays.asList("Natasha", "Masha")), myBook.peopleByHouse("Nevskiy", 26));
        assertEquals(new HashSet<>(Arrays.asList("Sasha")), myBook.peopleByHouse("Nevskiy", 54));
        assertNotEquals(new HashSet<>(Arrays.asList("Dasha")), myBook.peopleByHouse("Nevskiy", 54));
    }
}