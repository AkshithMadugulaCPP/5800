package Final.Singleton;

import Final.Customer;
import Final.Driver;
import Final.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class CPPFoodDelivery {
    private static CPPFoodDelivery instance;
    private List<Restaurant> restaurants;
    private List<Customer> customers;
    private List<Driver> drivers;

    private CPPFoodDelivery() {
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        drivers = new ArrayList<>();
    }

    public static CPPFoodDelivery getInstance() {
        if (instance == null) {
            instance = new CPPFoodDelivery();
        }
        return instance;
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    // Other methods for order creation and processing
}
