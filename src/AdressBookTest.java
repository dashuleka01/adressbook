import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.*;

class AdressBookTest {
    Adress adress1 = new Adress("Nevskiy", 54, 10);
    Adress adress2 = new Adress("Moskovskiy", 10, 105);
    Adress adress3 = new Adress("Nevskiy", 26, 541);
    Adress adress4 = new Adress("Nevskiy", 26, 123);
    String name = "Sasha";

    @Test
    void addPerson() {
        assertEquals(adress1, new AdressBook().addPerson(name, adress1).getAdress(name));

        AdressBook adressBook = new AdressBook();
        adressBook.addPerson(name, adress1);
        try {
            adressBook.addPerson(name, adress2);
            fail("Illegal Argument");
        } catch (IllegalArgumentException e) {
        }
        assertEquals(adress1, adressBook.getAdress(name));
    }

    @Test
    void deletePerson() {
        AdressBook adressBook = new AdressBook();
        try {
            adressBook.deletePerson(name);
            fail("Illegal Argument");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void changeAdress() {
        assertEquals(adress2, new AdressBook().addPerson(name, adress1).changeAdress(name, adress2).getAdress(name));

        AdressBook adressBook = new AdressBook();
        try {
            adressBook.changeAdress(name, adress1);
            fail("Illegal Argument");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void getAdress() {
        assertEquals(adress1, new AdressBook().addPerson(name, adress1).getAdress(name));

        AdressBook adressBook = new AdressBook();
        try {
            adressBook.getAdress(name);
            fail("Illegal Argument");
        } catch (IllegalArgumentException e) {
        }
    }

    @Test
    void peopleByStreet() {
        AdressBook myBook = new AdressBook();
        myBook.addPerson("Sasha", adress1);
        myBook.addPerson("Dasha", adress2);
        myBook.addPerson("Masha", adress3);
        myBook.addPerson("Natasha", adress4);

        assertEquals(new HashSet<>(Arrays.asList("Natasha", "Masha", "Sasha")), myBook.peopleByStreet("Nevskiy"));
        assertEquals(new HashSet<>(), myBook.peopleByStreet("Street"));
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
        assertEquals(new HashSet<>(), myBook.peopleByHouse("Nevskiy", 27));
        assertEquals(new HashSet<>(), myBook.peopleByHouse("Street", 26));
    }
}