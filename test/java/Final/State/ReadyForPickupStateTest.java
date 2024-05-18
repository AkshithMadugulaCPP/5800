package test.java.Final.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Final.Order;
import Final.Restaurant;

import java.util.HashMap;
import java.util.function.BiFunction;

import Final.State.ReadyForPickupState;
import org.junit.jupiter.api.Test;

class ReadyForPickupStateTest {
    /**
     * Method under test: {@link ReadyForPickupState#next(Order)}
     */
    @Test
    void testNext() {
        // Arrange
        ReadyForPickupState readyForPickupState = new ReadyForPickupState();
        Order order = new Order();

        // Act
        readyForPickupState.next(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link ReadyForPickupState#next(Order)}
     */
    @Test
    void testNext2() {
        // Arrange
        ReadyForPickupState readyForPickupState = new ReadyForPickupState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        readyForPickupState.next(order);

        // Assert
        assertEquals("Order Picked Up", order.getStatus());
    }

    /**
     * Method under test: {@link ReadyForPickupState#prev(Order)}
     */
    @Test
    void testPrev() {
        // Arrange
        ReadyForPickupState readyForPickupState = new ReadyForPickupState();
        Order order = new Order();

        // Act
        readyForPickupState.prev(order);

        // Assert
        assertEquals("Order Preparing", order.getStatus());
    }

    /**
     * Method under test: {@link ReadyForPickupState#prev(Order)}
     */
    @Test
    void testPrev2() {
        // Arrange
        ReadyForPickupState readyForPickupState = new ReadyForPickupState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        readyForPickupState.prev(order);

        // Assert
        assertEquals("Order Preparing", order.getStatus());
    }

    /**
     * Method under test: {@link ReadyForPickupState#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals("Order Ready for Pickup", (new ReadyForPickupState()).getStatus());
    }
}
