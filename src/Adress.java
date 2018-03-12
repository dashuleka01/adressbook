public class Adress {
    private String street;
    private int house;
    private int flat;

    public Adress(String street, int house, int flat) {
        this.street = street;
        this.house = house;
        this.flat = flat;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }

    public int getFlat() {
        return this.flat;
    }
}
