package Final.Factory;

import Final.Restaurant;
import Final.User;

import java.util.Map;


public class RestaurantFactory extends UserFactory {
    public Restaurant createUser(String name, String address, String county, Map<String, String> operatingHours, String cuisineType) {
        return new Restaurant(name, address, county, operatingHours, cuisineType);
    }

    @Override
    public User createUser(String name, String address, String county) {
        throw new UnsupportedOperationException("Use createUser with operatingHours and cuisineType for Restaurant");
    }
}