package Final;

public class Driver extends User {
    private String shift;

    public Driver(String name, String address, String county, String shift) {
        super(name, address, county);
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }
}

