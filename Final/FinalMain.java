package Final;

import Final.Decorator.BasicMeal;
import Final.Factory.CustomerFactory;
import Final.Factory.DriverFactory;
import Final.Factory.RestaurantFactory;
import Final.Singleton.CPPFoodDelivery;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FinalMain {
    public static void main(String[] args) {
        CPPFoodDelivery platform = CPPFoodDelivery.getInstance();

        // Register Restaurants
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        Restaurant r1 = restaurantFactory.createUser("Mexican Delight", "123 LA St", "LA County", getOperatingHours(), "Mexican");
        Restaurant r2 = restaurantFactory.createUser("Thai Spice", "456 OC St", "Orange County", getOperatingHours(), "Thai");
        platform.registerRestaurant(r1);
        platform.registerRestaurant(r2);

        // Register Customers
        CustomerFactory customerFactory = new CustomerFactory();
        Customer c1 = customerFactory.createUser("Alice", "789 LA Ave", "LA County");
        Customer c2 = customerFactory.createUser("Bob", "321 OC Blvd", "Orange County");
        platform.registerCustomer(c1);
        platform.registerCustomer(c2);

        // Register Drivers
        DriverFactory driverFactory = new DriverFactory();
        Driver d1 = driverFactory.createUser("Driver A", "102 LA St", "LA County", "1st shift");
        Driver d2 = driverFactory.createUser("Driver B", "203 OC St", "Orange County", "2nd shift");
        platform.registerDriver(d1);
        platform.registerDriver(d2);

        // Create and process an order
        Order order = new Order();
        order.setRestaurant(r1);
        order.setCustomer(c1);
        order.setFoodItems(Arrays.asList(new BasicMeal("Taco", 10, 20, 5)));

        // Process the order through its states
        System.out.println("Order Status: " + order.getStatus());
        order.next();
        System.out.println("Order Status: " + order.getStatus());
        order.next();
        System.out.println("Order Status: " + order.getStatus());
    }

    private static Map<String, String> getOperatingHours() {
        Map<String, String> hours = new HashMap<>();
        hours.put("Monday", "8AM - 8PM");
        hours.put("Tuesday", "8AM - 8PM");
        hours.put("Wednesday", "8AM - 8PM");
        hours.put("Thursday", "8AM - 8PM");
        hours.put("Friday", "8AM - 10PM");
        hours.put("Saturday", "8AM - 10PM");
        hours.put("Sunday", "8AM - 8PM");
        return hours;
    }
}

