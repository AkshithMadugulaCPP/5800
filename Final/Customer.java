package Final;

import java.util.List;

public class Customer extends User {
    private List<String> dietaryRestrictions;

    public Customer(String name, String address, String county, List<String> dietaryRestrictions) {
        super(name, address, county);
        this.dietaryRestrictions = dietaryRestrictions;
    }

    public List<String> getDietaryRestrictions() {
        return dietaryRestrictions;
    }
}

