import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AdressBook {

    private Map<String, Adress> book;

    public AdressBook() {
        this.book = new HashMap<>();
    }

    //добавление пары человек-адрес
    public AdressBook addPerson(String person, Adress ad) {
        if (this.book.putIfAbsent(person, ad) != null)
            throw new IllegalArgumentException();
        return this;
    }

    //удаление человека
    public AdressBook deletePerson(String person) {
        if (this.book.remove(person) == null)
            throw new IllegalArgumentException();
        return this;
    }

    //изменение адреса
    public AdressBook changeAdress(String person, Adress ad) {
        if (this.book.replace(person, ad) == null)
            throw new IllegalArgumentException();
        return this;
    }

    //получение адреса
    public Adress getAdress(String person) {
        Adress res = this.book.get(person);
        if (res == null) throw new IllegalArgumentException();
        else return res;
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