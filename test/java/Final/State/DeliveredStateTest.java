package test.java.Final.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Final.Order;
import Final.Restaurant;

import java.util.HashMap;
import java.util.function.BiFunction;

import Final.State.DeliveredState;
import org.junit.jupiter.api.Test;

class DeliveredStateTest {
    /**
     * Method under test: {@link DeliveredState#next(Order)}
     */
    @Test
    void testNext() {
        // Arrange
        DeliveredState deliveredState = new DeliveredState();
        Order order = new Order();

        // Act
        deliveredState.next(order);

        // Assert that nothing has changed
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link DeliveredState#next(Order)}
     */
    @Test
    void testNext2() {
        // Arrange
        DeliveredState deliveredState = new DeliveredState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("The order is already delivered.", "42 Main St", "3", operatingHours,
                "The order is already delivered.");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        deliveredState.next(order);

        // Assert that nothing has changed
        assertEquals("42 Main St", order.getRestaurant().getAddress());
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link DeliveredState#prev(Order)}
     */
    @Test
    void testPrev() {
        // Arrange
        DeliveredState deliveredState = new DeliveredState();
        Order order = new Order();

        // Act
        deliveredState.prev(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link DeliveredState#prev(Order)}
     */
    @Test
    void testPrev2() {
        // Arrange
        DeliveredState deliveredState = new DeliveredState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        deliveredState.prev(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link DeliveredState#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals("Order Delivered", (new DeliveredState()).getStatus());
    }
}
