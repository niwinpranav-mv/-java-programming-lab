package deliveryapp;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private Customer customer;
    private Driver driver;
    private List<Item> items = new ArrayList<>();

    public Order(Customer customer, Driver driver) {
        this.customer = customer;
        this.driver = driver;
    }

    public void addItem(Item item) {
        items.add(item);
    }

    public double getTotal() {
        double total = 0;
        for (Item i : items) total += i.price;
        return total;
    }

    public Customer getCustomer() { return customer; }
    public Driver getDriver() { return driver; }
}
