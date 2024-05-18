package test.java.Final.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Final.Order;
import Final.Restaurant;

import java.util.HashMap;
import java.util.function.BiFunction;

import Final.State.PreparingState;
import org.junit.jupiter.api.Test;

class PreparingStateTest {
    /**
     * Method under test: {@link PreparingState#next(Order)}
     */
    @Test
    void testNext() {
        // Arrange
        PreparingState preparingState = new PreparingState();
        Order order = new Order();

        // Act
        preparingState.next(order);

        // Assert
        assertEquals("Order Ready for Pickup", order.getStatus());
    }

    /**
     * Method under test: {@link PreparingState#next(Order)}
     */
    @Test
    void testNext2() {
        // Arrange
        PreparingState preparingState = new PreparingState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        preparingState.next(order);

        // Assert
        assertEquals("Order Ready for Pickup", order.getStatus());
    }

    /**
     * Method under test: {@link PreparingState#prev(Order)}
     */
    @Test
    void testPrev() {
        // Arrange
        PreparingState preparingState = new PreparingState();
        Order order = new Order();

        // Act
        preparingState.prev(order);

        // Assert
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link PreparingState#prev(Order)}
     */
    @Test
    void testPrev2() {
        // Arrange
        PreparingState preparingState = new PreparingState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        preparingState.prev(order);

        // Assert
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link PreparingState#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals("Order Preparing", (new PreparingState()).getStatus());
    }
}
