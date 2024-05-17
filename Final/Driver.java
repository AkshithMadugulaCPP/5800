package Final;

public class Driver extends User {
    private String shift;
    private String operatingCounty;

    public Driver(String name, String address, String operatingCounty, String shift) {
        super(name, address,operatingCounty);
        this.operatingCounty = operatingCounty;
        this.shift = shift;
    }

    public String getShift() {
        return shift;
    }

    public void setShift(String shift) {
        this.shift = shift;
    }

    public String getOperatingCounty() {
        return operatingCounty;
    }

    public void setOperatingCounty(String operatingCounty) {
        this.operatingCounty = operatingCounty;
    }
}


