package Final.Singleton;

import Final.Customer;
import Final.Driver;
import Final.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class CPPFoodDelivery {
    private static CPPFoodDelivery instance;
    private List<Customer> customers;
    private List<Restaurant> restaurants;
    private List<Driver> drivers;

    private CPPFoodDelivery() {
        customers = new ArrayList<>();
        restaurants = new ArrayList<>();
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
        System.out.println("Registered Customer: " + customer.getName());
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Registered Restaurant: " + restaurant.getName());
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Registered Driver: " + driver.getName());
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public List<Restaurant> getOperatingRestaurants(String currentTime) {
        // For simplicity, return all restaurants in this demo
        return restaurants;
    }

    public Driver getAvailableDriver(String county, String currentTime) {
        // Implement logic to find an available driver based on shift and county
        for (Driver driver : drivers) {
            if (driver.getOperatingCounty().equals(county)) {
                return driver;
            }
        }
        return null;
    }
}
