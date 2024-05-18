package test.java.Final.State;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import Final.Order;
import Final.Restaurant;

import java.util.HashMap;
import java.util.function.BiFunction;

import Final.State.PickedUpState;
import org.junit.jupiter.api.Test;

class PickedUpStateTest {
    /**
     * Method under test: {@link PickedUpState#next(Order)}
     */
    @Test
    void testNext() {
        // Arrange
        PickedUpState pickedUpState = new PickedUpState();
        Order order = new Order();

        // Act
        pickedUpState.next(order);

        // Assert
        assertEquals("Order Delivered", order.getStatus());
    }

    /**
     * Method under test: {@link PickedUpState#next(Order)}
     */
    @Test
    void testNext2() {
        // Arrange
        PickedUpState pickedUpState = new PickedUpState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        pickedUpState.next(order);

        // Assert
        assertEquals("Order Delivered", order.getStatus());
    }

    /**
     * Method under test: {@link PickedUpState#prev(Order)}
     */
    @Test
    void testPrev() {
        // Arrange
        PickedUpState pickedUpState = new PickedUpState();
        Order order = new Order();

        // Act
        pickedUpState.prev(order);

        // Assert
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link PickedUpState#prev(Order)}
     */
    @Test
    void testPrev2() {
        // Arrange
        PickedUpState pickedUpState = new PickedUpState();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        Order order = new Order();
        order.setRestaurant(restaurant);

        // Act
        pickedUpState.prev(order);

        // Assert
        assertEquals("Order Created", order.getStatus());
    }

    /**
     * Method under test: {@link PickedUpState#getStatus()}
     */
    @Test
    void testGetStatus() {
        // Arrange, Act and Assert
        assertEquals("Order Picked Up", (new PickedUpState()).getStatus());
    }
}
