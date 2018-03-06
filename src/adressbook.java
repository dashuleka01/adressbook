import java.util.*;

public class AdressBook {

    Map<String, adress> book;

    public AdressBook() {
        this.book = new HashMap<>();
    }

    //добавление пары человек-адрес
    public AdressBook addPerson(String person, adress ad) {
        try {
            this.book.put(person, ad);
        }
        catch (Exception e){
            System.out.println("Please, try another name");
        }
        return this;
    }

    //удаление человека
    public AdressBook deletePerson(String person) {
        try {
            this.book.remove(person);
        }
        catch (Exception e){
            System.out.println("Please, try another name");
        }
        return this;
    }

    //изменение адреса
    public AdressBook changeAdress(String person, adress ad){
        try {
            this.book.replace(person, ad);
        }
        catch (Exception e){
            System.out.println("Please, try another name");
        }
        return this;
    }

    //получение адреса
    public adress getAdress(String person){
        if (!this.book.containsKey(person)){
            System.out.println("Please, try another name");
            throw new IllegalArgumentException();
        }
        return this.book.get(person);
    }

    //получение списка людей по улице
    public Set<String> peopleByStreet(String sourceStreet){
        Set<String> listOfNames = new HashSet<>();
        for (String i:
             this.book.keySet()) {
            if (this.getAdress(i).street == sourceStreet)
                listOfNames.add(i);
        }
        return listOfNames;
    }

    //получение списка людей по дому
    public Set<String> peopleByHouse(String sourceStreet, int sourceHouse) {
        Set<String> listOfNames = this.peopleByStreet(sourceStreet);
        for (String i:
             this.book.keySet()) {
            if (this.getAdress(i).house != sourceHouse)
                listOfNames.remove(i);
        }
        return listOfNames;
    }
}

//дополнительный класс
class adress {
    String street;
    int house;
    int flat;

    public adress(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }
}