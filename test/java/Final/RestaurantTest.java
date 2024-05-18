package test.java.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import Final.Restaurant;
import org.junit.jupiter.api.Test;

class RestaurantTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Restaurant#getCuisineType()}
     *   <li>{@link Restaurant#getMenu()}
     *   <li>{@link Restaurant#getOperatingHours()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        HashMap<String, String> operatingHours = new HashMap<>();
        Restaurant restaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        // Act
        String actualCuisineType = restaurant.getCuisineType();
        restaurant.getMenu();

        // Assert
        assertEquals("Cuisine Type", actualCuisineType);
        assertSame(operatingHours, restaurant.getOperatingHours());
    }

    /**
     * Method under test:
     * {@link Restaurant#Restaurant(String, String, String, Map, String)}
     */
    @Test
    void testNewRestaurant() {
        // Arrange and Act
        Restaurant actualRestaurant = new Restaurant("Name", "42 Main St", "3", new HashMap<>(), "Cuisine Type");

        // Assert
        assertEquals("3", actualRestaurant.getCounty());
        assertEquals("42 Main St", actualRestaurant.getAddress());
        assertEquals("Cuisine Type", actualRestaurant.getCuisineType());
        assertEquals("Name", actualRestaurant.getName());
        assertTrue(actualRestaurant.getMenu().isEmpty());
        assertTrue(actualRestaurant.getOperatingHours().isEmpty());
    }

    /**
     * Method under test:
     * {@link Restaurant#Restaurant(String, String, String, Map, String)}
     */
    @Test
    void testNewRestaurant2() {
        // Arrange
        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("foo", mock(BiFunction.class));

        // Act
        Restaurant actualRestaurant = new Restaurant("Name", "42 Main St", "3", operatingHours, "Cuisine Type");

        // Assert
        assertEquals("3", actualRestaurant.getCounty());
        assertEquals("42 Main St", actualRestaurant.getAddress());
        assertEquals("Cuisine Type", actualRestaurant.getCuisineType());
        assertEquals("Name", actualRestaurant.getName());
        assertTrue(actualRestaurant.getMenu().isEmpty());
        assertTrue(actualRestaurant.getOperatingHours().isEmpty());
    }
}
