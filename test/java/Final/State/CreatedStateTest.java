package test.java.Final.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Final.Order;
import Final.Restaurant;

import java.util.HashMap;
import java.util.function.BiFunction;

import Final.State.CreatedState;
import org.junit.jupiter.api.Test;

class CreatedStateTest {
    /**
     * Method under test: {@link CreatedState#next(Order)}
     */
    @Test
    void testNext() {
        // Arrange
        CreatedState createdState = new CreatedState();
        Order order = new Order();

        // Act
        createdState.next(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link CreatedState#next(Order)}
     */
    @Test
    void testNext2() {
        // Arrange
        CreatedState createdState = new CreatedState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        createdState.next(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link CreatedState#prev(Order)}
     */
    @Test
    void testPrev() {
        // Arrange
        CreatedState createdState = new CreatedState();
        Order order = new Order();

        // Act
        createdState.prev(order);

        // Assert that nothing has changed
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link CreatedState#prev(Order)}
     */
    @Test
    void testPrev2() {
        // Arrange
        CreatedState createdState = new CreatedState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("The order is in its initial state.", "42 Main St", "3", operatingHours,
                "The order is in its initial state.");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        createdState.prev(order);

        // Assert that nothing has changed
        assertEquals("42 Main St", order.getRestaurant().getAddress());
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link CreatedState#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals("Order Created", (new CreatedState()).getStatus());
    }
}
