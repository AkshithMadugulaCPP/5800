package Final;

import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;
import Final.Decorator.ToppingDecorator;
import Final.Factory.CustomerFactory;
import Final.Factory.DriverFactory;
import Final.Factory.RestaurantFactory;
import Final.Singleton.CPPFoodDelivery;
import Final.enums.DietaryRestriction;
import Final.enums.MenuItem;
import Final.enums.Topping;

import java.time.LocalDateTime;
import java.util.*;

public class FinalMain {
    public static void main(String[] args) {
        CPPFoodDelivery platform = CPPFoodDelivery.getInstance();

        // Register entities
        registerRestaurants(platform);
        registerCustomers(platform);
        registerDrivers(platform);

        for (int i = 1; i <= 10; i++) {
            System.out.println("------------Customer" + (i) + "---------------");
            processCustomerOrder(platform, i);

        }
    }

    private static void processCustomerOrder(CPPFoodDelivery platform, int customerNumber) {
        Customer customer = platform.getCustomers().get(customerNumber - 1);
        System.out.println("Customer " + customer.getName() + " is ready to order.");

        // Choose dietary restriction
        DietaryRestriction chosenRestriction = chooseDietaryRestriction(customerNumber);
        System.out.println("Customer " + customer.getName() + " chose dietary restriction: " + chosenRestriction);

        // Display currently operating restaurants
        List<Restaurant> operatingRestaurants = platform.getOperatingRestaurants("Friday 9:00AM");
        System.out.println("Currently operating restaurants:");
        for (Restaurant restaurant : operatingRestaurants) {
            System.out.println("\t"+restaurant.getName() + " (" + restaurant.getCuisineType() + ")");
        }

        // Customer selects restaurant and sees menu based on dietary restriction
        Restaurant selectedRestaurant = operatingRestaurants.get(customerNumber%4);
        System.out.println("Customer " + customer.getName() + " selected " + selectedRestaurant.getName());
        System.out.println("Menu for " + chosenRestriction + " diet:");

        List<BasicMeal> selectableMeals = getSelectableMeals(selectedRestaurant, chosenRestriction);
        displayMenu(selectableMeals);

        // Customer chooses items from the menu
        Meal selectedMeal = selectableMeals.get(0); // Just an example, choose meal based on user input or preference
        if (customerNumber%5 == 0) {
            selectedMeal = new ToppingDecorator(selectedMeal, Topping.CHEESE);
            selectedMeal = new ToppingDecorator(selectedMeal, Topping.GUACAMOLE);
        }
        // Create and process an order
        Order order = createOrder(selectedRestaurant, customer, selectedMeal);
        order.displayOrder();
        processOrder(platform, order);
    }

    public static DietaryRestriction chooseDietaryRestriction(int customerNumber) {
        switch (customerNumber % 4) {
            case 0:
                return DietaryRestriction.SPICY;
            case 1:
                return DietaryRestriction.LACTOSE;
            case 2:
                return DietaryRestriction.NUT_ALLERGY;
            case 3:
                return DietaryRestriction.NO_RESTRICTION;
            default:
                return DietaryRestriction.NO_RESTRICTION; // Default to NO_RESTRICTION
        }
    }

    public static List<BasicMeal> getSelectableMeals(Restaurant restaurant, DietaryRestriction chosenRestriction) {
        List<BasicMeal> selectableMeals = new ArrayList<>();
        for (BasicMeal meal : restaurant.getMenu()) {
            if (meal.isMealCompatibleWithDiet(chosenRestriction)) {
                selectableMeals.add(meal);
            }
        }
        return selectableMeals;
    }

    private static void displayMenu(List<BasicMeal> meals) {
        for (BasicMeal meal : meals) {
            System.out.println(meal.getDescription() + " - Fats: " + meal.getFats() + ", Carbs: " + meal.getCarbs() + ", Protein: " + meal.getProtein());
        }
    }

    private static void registerRestaurants(CPPFoodDelivery platform) {
        RestaurantFactory restaurantFactory = new RestaurantFactory();
        platform.registerRestaurant(restaurantFactory.createUser("Mexican Delight", "123 LA St", "LA County", getOperatingHours(), "Mexican"));
        platform.registerRestaurant(restaurantFactory.createUser("Thai Spice", "456 OC St", "Orange County", getOperatingHours(), "Thai"));
        platform.registerRestaurant(restaurantFactory.createUser("Indian house", "789 SB St", "San Bernardino County", getOperatingHours(), "Indian"));
        platform.registerRestaurant(restaurantFactory.createUser("American Grill", "101 LA St", "LA County", getOperatingHours(), "American"));
    }

    private static void registerCustomers(CPPFoodDelivery platform) {
        CustomerFactory customerFactory = new CustomerFactory();
        platform.registerCustomer(customerFactory.createUser("Ram", "202 LA Ave", "LA County"));
        platform.registerCustomer(customerFactory.createUser("Ruchitha", "303 Main St", "Orange County"));
        platform.registerCustomer(customerFactory.createUser("Akshith", "404 Elm St", "San Bernardino County"));
        platform.registerCustomer(customerFactory.createUser("Lahari", "505 Oak St", "LA County"));
        platform.registerCustomer(customerFactory.createUser("Sravani", "606 Pine St", "Orange County"));
        platform.registerCustomer(customerFactory.createUser("Gande", "707 Maple St", "San Bernardino County"));
        platform.registerCustomer(customerFactory.createUser("Madugula", "808 Cedar St", "LA County"));
        platform.registerCustomer(customerFactory.createUser("Sandepudi", "909 Birch St", "Orange County"));
        platform.registerCustomer(customerFactory.createUser("Bakkareddy Gari", "1010 Walnut St", "San Bernardino County"));
        platform.registerCustomer(customerFactory.createUser("Vikram", "1111 Cherry St", "LA County"));
    }

    private static void registerDrivers(CPPFoodDelivery platform) {
        DriverFactory driverFactory = new DriverFactory();
        platform.registerDriver(driverFactory.createUser("Driver A", "102 LA St", "LA County", "1st shift"));
        platform.registerDriver(driverFactory.createUser("Driver B", "203 OC St", "Orange County", "2nd shift"));
        platform.registerDriver(driverFactory.createUser("Driver C", "304 SB St", "San Bernardino County", "3rd shift"));
        platform.registerDriver(driverFactory.createUser("Driver D", "405 LA St", "LA County", "1st shift"));
        platform.registerDriver(driverFactory.createUser("Driver E", "506 OC St", "Orange County", "2nd shift"));
        platform.registerDriver(driverFactory.createUser("Driver F", "607 SB St", "San Bernardino County", "3rd shift"));
        platform.registerDriver(driverFactory.createUser("Driver G", "708 LA St", "LA County", "1st shift"));
        platform.registerDriver(driverFactory.createUser("Driver H", "809 OC St", "Orange County", "2nd shift"));
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

    public static Order createOrder(Restaurant restaurant, Customer customer, Meal meal) {
        Order order = new Order();
        order.setRestaurant(restaurant);
        order.setCustomer(customer);
        order.setFoodItems(Arrays.asList(meal));
        order.setOrderCreationTime(LocalDateTime.now());
        return order;
    }

    public static void processOrder(CPPFoodDelivery platform, Order order) {
        order.next();
        System.out.println("Order Status: " + order.getStatus());
        order.next();
        Driver assignedDriver = platform.getAvailableDriver(order.getRestaurant().getCounty(), "Friday 9:00AM");
        if (assignedDriver != null) {
            order.setDriver(assignedDriver);
            System.out.println("Assigned Driver: " + assignedDriver.getName());
        }
        System.out.println("Order Status: " + order.getStatus());
    }

}

