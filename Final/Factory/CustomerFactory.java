package Final.Factory;

import Final.Customer;

import java.util.ArrayList;

public class CustomerFactory extends UserFactory {
    @Override
    public Customer createUser(String name, String address, String county) {
        return new Customer(name, address, county, new ArrayList<>());
    }
}
