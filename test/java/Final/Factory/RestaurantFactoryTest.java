package test.java.Final.Factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import Final.Factory.RestaurantFactory;
import Final.Restaurant;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

import org.junit.jupiter.api.Test;

class RestaurantFactoryTest {
    /**
     * Method under test:
     * {@link RestaurantFactory#createUser(String, String, String)}
     */
    @Test
    void testCreateUser() {
        // Arrange, Act and Assert
        assertThrows(UnsupportedOperationException.class,
                () -> (new RestaurantFactory()).createUser("Name", "42 Main St", "3"));
    }

    /**
     * Method under test:
     * {@link RestaurantFactory#createUser(String, String, String, Map, String)}
     */
    @Test
    void testCreateUser2() {
        // Arrange
        RestaurantFactory restaurantFactory = new RestaurantFactory();

        // Act
        Restaurant actualCreateUserResult = restaurantFactory.createUser("Name", "42 Main St", "3", new HashMap<>(),
                "Cuisine Type");

        // Assert
        assertEquals("3", actualCreateUserResult.getCounty());
        assertEquals("42 Main St", actualCreateUserResult.getAddress());
        assertEquals("Cuisine Type", actualCreateUserResult.getCuisineType());
        assertEquals("Name", actualCreateUserResult.getName());
        assertTrue(actualCreateUserResult.getMenu().isEmpty());
        assertTrue(actualCreateUserResult.getOperatingHours().isEmpty());
    }

    /**
     * Method under test:
     * {@link RestaurantFactory#createUser(String, String, String, Map, String)}
     */
    @Test
    void testCreateUser3() {
        // Arrange
        RestaurantFactory restaurantFactory = new RestaurantFactory();

        HashMap<String, String> operatingHours = new HashMap<>();
        operatingHours.computeIfPresent("Invalid cuisine type", mock(BiFunction.class));

        // Act
        Restaurant actualCreateUserResult = restaurantFactory.createUser("Name", "42 Main St", "3", operatingHours,
                "Cuisine Type");

        // Assert
        assertEquals("3", actualCreateUserResult.getCounty());
        assertEquals("42 Main St", actualCreateUserResult.getAddress());
        assertEquals("Cuisine Type", actualCreateUserResult.getCuisineType());
        assertEquals("Name", actualCreateUserResult.getName());
        assertTrue(actualCreateUserResult.getMenu().isEmpty());
        assertTrue(actualCreateUserResult.getOperatingHours().isEmpty());
    }
}
