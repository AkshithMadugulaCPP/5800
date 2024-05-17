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

    private int currentDriverIndex;

    private CPPFoodDelivery() {
        restaurants = new ArrayList<>();
        customers = new ArrayList<>();
        drivers = new ArrayList<>();
        currentDriverIndex = 0;
    }

    public static CPPFoodDelivery getInstance() {
        if (instance == null) {
            instance = new CPPFoodDelivery();
        }
        return instance;
    }

    public void registerCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer " + customer.getName() + " registered.");
    }

    public void registerRestaurant(Restaurant restaurant) {
        restaurants.add(restaurant);
        System.out.println("Restaurant " + restaurant.getName() + " registered.");
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        System.out.println("Driver " + driver.getName() + " registered.");
    }

    public List<Restaurant> getOperatingRestaurants(String time) {
        List<Restaurant> operatingRestaurants = new ArrayList<>();
        for (Restaurant restaurant : restaurants) {
            String[] hours = restaurant.getOperatingHours().get(time.split(" ")[0]).split(" - ");
            if (isWithinOperatingHours(hours, time.split(" ")[1])) {
                operatingRestaurants.add(restaurant);
            }
        }
        return operatingRestaurants;
    }

    private boolean isWithinOperatingHours(String[] hours, String currentTime) {
        int currentHour = Integer.parseInt(currentTime.split(":")[0]);
        int startHour = Integer.parseInt(hours[0].split("AM")[0].trim().replace("PM", "").replace("AM", ""));
        int endHour = Integer.parseInt(hours[1].split("PM")[0].trim().replace("PM", "").replace("AM", ""));

        if (hours[1].contains("PM") && hours[0].contains("AM")) {
            endHour += 12;
        }

        return currentHour >= startHour && currentHour < endHour;
    }

    public Driver getAvailableDriver(String county, String time) {
        List<Driver> availableDrivers = new ArrayList<>();
        for (Driver driver : drivers) {
            if (driver.getCounty().equals(county) && driver.getShift().equals(getShift(time))) {
                availableDrivers.add(driver);
            }
        }

        if (availableDrivers.size() > 0) {
            Driver assignedDriver = availableDrivers.get(currentDriverIndex % availableDrivers.size());
            currentDriverIndex++;
            return assignedDriver;
        }

        return null;
    }

    private String getShift(String time) {
        int hour = Integer.parseInt(time.split(" ")[1].split(":")[0]);
        if (hour >= 8 && hour < 16) {
            return "1st shift";
        } else if (hour >= 16 && hour < 24) {
            return "2nd shift";
        } else {
            return "3rd shift";
        }
    }
}