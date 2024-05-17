package Final;

import Final.Decorator.BasicMeal;
import Final.Decorator.*;
import Final.Factory.*;
import Final.Singleton.CPPFoodDelivery;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
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

        // Customer ready to order
        System.out.println("Customer " + c1.getName() + " is ready to order.");
        List<Restaurant> operatingRestaurants = platform.getOperatingRestaurants("Friday 9:00AM");
        System.out.println("Currently operating restaurants:");
        for (Restaurant restaurant : operatingRestaurants) {
            System.out.println(restaurant.getName() + " (" + restaurant.getCuisineType() + ")");
        }

        // Customer selects restaurant and sees menu
        Restaurant selectedRestaurant = operatingRestaurants.get(0);
        System.out.println("Customer " + c1.getName() + " selected " + selectedRestaurant.getName());
        System.out.println("Menu:");
        for (Meal meal : selectedRestaurant.getMenu()) {
            System.out.println(meal.getDescription() + " - Fats: " + meal.getFats() + ", Carbs: " + meal.getCarbs() + ", Protein: " + meal.getProtein());
        }

        // Customer chooses dietary restrictions and items
        System.out.println("Customer " + c1.getName() + " has dietary restrictions: " + c1.getDietaryRestrictions());
        Meal selectedMeal = selectedRestaurant.getMenu().get(0);
        selectedMeal = new ToppingDecorator(selectedMeal, "Cheese");
        selectedMeal = new ToppingDecorator(selectedMeal, "Guacamole");

        // Create and process an order
        Order order = new Order();
        order.setRestaurant(selectedRestaurant);
        order.setCustomer(c1);
        order.setFoodItems(Arrays.asList(selectedMeal));
        order.setOrderCreationTime(LocalDateTime.now());

        // Process the order through its states
        System.out.println("Order Status: " + order.getStatus());
        order.next();
        System.out.println("Order Status: " + order.getStatus());
        order.next();
        System.out.println("Order Status: " + order.getStatus());
        Driver assignedDriver = platform.getAvailableDriver(selectedRestaurant.getCounty(), "Friday 9:00AM");
        if (assignedDriver != null) {
            order.setDriver(assignedDriver);
            System.out.println("Assigned Driver: " + assignedDriver.getName());
        }
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

