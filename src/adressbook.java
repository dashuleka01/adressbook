
import java.util.Map;

public class adressbook {
    private Map<String, adress> book;

    public adressbook(Map<String, adress> book) {
        this.book = book;
    }

    //добавление пары человек-адрес
    public adressbook addPerson(String person, adress ad) {
        this.book.put(person, ad);
        return this;
    }

    //удаление человека
    public adressbook deletePerson(String person) {
        this.book.remove(person);
        return this;
    }

    //изменение адреса
    public adressbook changeAdress(String person, adress ad){
        this.deletePerson(person);
        this.addPerson(person, ad);
        return this;
    }

    //получение адреса
    public adress getAdress(String person){
        return this.book.get(person);
    }

    //получение списка людей по улице

    //получение списка людей по дому
}

class adress {
    private String street;
    private int house;
    private int flat;

    public adress(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}

