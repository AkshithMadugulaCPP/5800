package Final.Factory;

import Final.Driver;
import Final.User;

public class DriverFactory extends UserFactory {

    public Driver createUser(String name, String address, String county, String shift) {
        return new Driver(name, address, county, shift);
    }

    @Override
    public User createUser(String name, String address, String county) {
        throw new UnsupportedOperationException("Use createUser with shift for Driver");
    }
}
