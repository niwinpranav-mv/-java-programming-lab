package deliveryapp;

public class Customer extends User {

    private String name;
    private String address;

    public Customer(String name, String address, String username, String password) {
        super(username, password);
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public String getAddress() { return address; }
}
