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
        assertFalse(new AdressBook().addPerson(name, adress2).book.get(name) == adress1);
        assertTrue(new AdressBook().addPerson(name, adress1).book.get(name) == adress1);
        try {
            AdressBook adressBook = new AdressBook();
            adressBook.addPerson(name, adress1);
            adressBook.addPerson(name, adress2);
        }
        catch (IllegalArgumentException e){
        }
    }

    @Test
    void deletePerson() {
        assertFalse(new AdressBook().addPerson(name, adress1).deletePerson(name).book.containsKey(name));
        try {
            AdressBook adressBook = new AdressBook();
            adressBook.deletePerson(name);
        }
        catch (IllegalArgumentException e){
        }
    }

    @Test
    void changeAdress() {
        assertTrue(new AdressBook().addPerson(name, adress1).changeAdress(name, adress2).book.get(name) == adress2);
        try {
            AdressBook adressBook = new AdressBook();
            adressBook.changeAdress(name, adress1);
        }
        catch (IllegalArgumentException e){
        }
    }

    @Test
    void getAdress() {
        assertEquals(adress1, new AdressBook().addPerson(name, adress1).getAdress(name));
        assertNotEquals(adress1, new AdressBook().addPerson(name, adress2).getAdress(name));
        try {
            AdressBook adressBook = new AdressBook();
            adressBook.getAdress(name);
        }
        catch (IllegalArgumentException e){
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
        assertNotEquals(new HashSet<>(Arrays.asList("Dasha", "Masha", "Sasha")), myBook.peopleByStreet("Nevskiy"));
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
        assertNotEquals(new HashSet<>(Arrays.asList("Dasha")), myBook.peopleByHouse("Nevskiy", 54));
        assertEquals(new HashSet<>(), myBook.peopleByHouse("Nevskiy", 27));
        assertEquals(new HashSet<>(), myBook.peopleByHouse("Street", 26));
    }
}