
import java.util.Map;

public class AdressBook {

    Map<String, adress> book;

    public AdressBook() {
        this.book = book;
    }

    //добавление пары человек-адрес
    public AdressBook addPerson(String person, adress ad) {
        this.book.put(person, ad);
        return this;
    }

    //удаление человека
    public AdressBook deletePerson(String person) {
        this.book.remove(person);
        return this;
    }

    //изменение адреса
    public AdressBook changeAdress(String person, adress ad){
        this.book.replace(person, ad);
        return this;
    }

    //получение адреса
    public adress getAdress(String person){
        return this.book.get(person);
    }

    //получение списка людей по улице


    //получение списка людей по дому






    public static void main(String[] args) {
        adress adress1 = new adress("Nevskiy", 54, 10);
        AdressBook book1 = new AdressBook();
        book1.addPerson("Sasha", adress1);
        adress adress2 = new adress("Moskovskiy", 12, 32);
        book1.addPerson("Masha", adress2);
    }
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