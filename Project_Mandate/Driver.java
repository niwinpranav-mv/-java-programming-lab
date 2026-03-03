package deliveryapp;

public class Driver {
    private String name;
    private String vehicle;

    public Driver(String name, String vehicle) {
        this.name = name;
        this.vehicle = vehicle;
    }

    public String getName() { return name; }
    public String getVehicle() { return vehicle; }
}
