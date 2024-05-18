package test.java.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.mock;

import Final.Customer;
import Final.Decorator.Meal;
import Final.Driver;
import Final.Order;
import Final.Restaurant;
import Final.State.CreatedState;
import Final.State.DeliveredState;
import Final.State.OrderState;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class OrderTest {
    /**
     * Method under test: {@link Order#next()}
     */
    @Test
    void testNext() {
        // Arrange
        Order order = new Order();

        // Act
        order.next();

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link Order#next()}
     */
    @Test
    void testNext2() {
        // Arrange
        Order order = new Order();
        order.setState(new DeliveredState());

        // Act
        order.next();

        // Assert that nothing has changed
        assertEquals("Order Delivered", order.getStatus());
    }

    /**
     * Method under test: {@link Order#next()}
     */
    @Test
    void testNext3() {
        // Arrange
        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        order.next();

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link Order#prev()}
     */
    @Test
    void testPrev() {
        // Arrange
        Order order = new Order();

        // Act
        order.prev();

        // Assert that nothing has changed
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link Order#prev()}
     */
    @Test
    void testPrev2() {
        // Arrange
        Order order = new Order();
        order.setState(new DeliveredState());

        // Act
        order.prev();

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link Order#prev()}
     */
    @Test
    void testPrev3() {
        // Arrange
        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        order.prev();

        // Assert that nothing has changed
        assertEquals("42 Main St", order.getRestaurant().getAddress());
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link Order#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange
        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act and Assert
        assertEquals("Order Created", order.getStatus());
    }


    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Order#setCustomer(Customer)}
     *   <li>{@link Order#setDriver(Driver)}
     *   <li>{@link Order#setFoodItems(List)}
     *   <li>{@link Order#setOrderCreationTime(LocalDateTime)}
     *   <li>{@link Order#setOrderDeliveredTime(LocalDateTime)}
     *   <li>{@link Order#setOrderPickUpTime(LocalDateTime)}
     *   <li>{@link Order#setRestaurant(Restaurant)}
     *   <li>{@link Order#setState(OrderState)}
     *   <li>{@link Order#getCustomer()}
     *   <li>{@link Order#getDriver()}
     *   <li>{@link Order#getFoodItems()}
     *   <li>{@link Order#getOrderCreationTime()}
     *   <li>{@link Order#getOrderDeliveredTime()}
     *   <li>{@link Order#getOrderPickUpTime()}
     *   <li>{@link Order#getRestaurant()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Order order = new Order();
        Customer customer = new Customer("Name", "42 Main St", "3", new ArrayList<>());

        // Act
        order.setCustomer(customer);
        Driver driver = new Driver("Name", "42 Main St", "3", "Shift");

        order.setDriver(driver);
        ArrayList<Meal> foodItems = new ArrayList<>();
        order.setFoodItems(foodItems);
        LocalDateTime orderCreationTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setOrderCreationTime(orderCreationTime);
        LocalDateTime orderDeliveredTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setOrderDeliveredTime(orderDeliveredTime);
        LocalDateTime orderPickUpTime = LocalDate.of(1970, 1, 1).atStartOfDay();
        order.setOrderPickUpTime(orderPickUpTime);
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", new HashMap<>(), "Cuisine Type");

        order.setRestaurant(restaurant);
        order.setState(new CreatedState());
        Customer actualCustomer = order.getCustomer();
        Driver actualDriver = order.getDriver();
        List<Meal> actualFoodItems = order.getFoodItems();
        LocalDateTime actualOrderCreationTime = order.getOrderCreationTime();
        LocalDateTime actualOrderDeliveredTime = order.getOrderDeliveredTime();
        LocalDateTime actualOrderPickUpTime = order.getOrderPickUpTime();

        // Assert that nothing has changed
        assertSame(customer, actualCustomer);
        assertSame(driver, actualDriver);
        assertSame(restaurant, order.getRestaurant());
        assertSame(foodItems, actualFoodItems);
        assertSame(orderCreationTime, actualOrderCreationTime);
        assertSame(orderDeliveredTime, actualOrderDeliveredTime);
        assertSame(orderPickUpTime, actualOrderPickUpTime);
    }

    /**
     * Method under test: default or parameterless constructor of {@link Order}
     */
    @Test
    void testNewOrder() {
        // Arrange, Act and Assert
        assertEquals("Order Created", (new Order()).getStatus());
    }
}
