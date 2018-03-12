import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdressBook {

    Map<String, Adress> book;

    public AdressBook() {
        this.book = new HashMap<>();
    }

    //добавление пары человек-адрес
    public AdressBook addPerson(String person, Adress ad) {
        if (this.book.containsKey(person))
            throw new IllegalArgumentException();
        this.book.putIfAbsent(person, ad);
        return this;
    }

    //удаление человека
    public AdressBook deletePerson(String person) {
        if (!this.book.containsKey(person))
            throw new IllegalArgumentException();
        this.book.remove(person);
        return this;
    }

    //изменение адреса
    public AdressBook changeAdress(String person, Adress ad) {
        if (!this.book.containsKey(person))
            throw new IllegalArgumentException();
        this.book.replace(person, ad);
        return this;
    }

    //получение адреса
    public Adress getAdress(String person) {
        if (!this.book.containsKey(person)) {
            throw new IllegalArgumentException();
        }
        return this.book.get(person);
    }

    //получение списка людей по улице
    public Set<String> peopleByStreet(String sourceStreet) {
        Set<String> listOfNames = new HashSet<>();
        for (Map.Entry<String, Adress> i : this.book.entrySet()) {
            if (i.getValue().getStreet().equals(sourceStreet))
                listOfNames.add(i.getKey());
        }
        return listOfNames;
    }

    //получение списка людей по дому
    public Set<String> peopleByHouse(String sourceStreet, int sourceHouse) {
        Set<String> listOfNames = new HashSet<>();
        for (Map.Entry<String, Adress> i : this.book.entrySet()) {
            if (i.getValue().getStreet().equals(sourceStreet) && i.getValue().getHouse() == sourceHouse)
                listOfNames.add(i.getKey());
        }
        return listOfNames;
    }
}