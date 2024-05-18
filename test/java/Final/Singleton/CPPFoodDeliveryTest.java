package test.java.Final.Singleton;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import Final.Customer;
import Final.Driver;
import Final.Restaurant;

import java.util.ArrayList;
import java.util.HashMap;

import Final.Singleton.CPPFoodDelivery;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

class CPPFoodDeliveryTest {
    /**
     * Method under test: {@link CPPFoodDelivery#getInstance()}
     */
    @Test
    void testGetInstance() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange and Act
        CPPFoodDelivery.getInstance();
    }

    /**
     * Method under test: {@link CPPFoodDelivery#registerDriver(Driver)}
     */
    @Test
    void testRegisterDriver() {
        // Arrange
        CPPFoodDelivery instance = CPPFoodDelivery.getInstance();
        Driver driver = mock(Driver.class);
        when(driver.getShift()).thenReturn("Shift");
        when(driver.getAddress()).thenReturn("42 Main St");
        when(driver.getCounty()).thenReturn("3");
        when(driver.getName()).thenReturn("Name");

        // Act
        instance.registerDriver(driver);

        // Assert
        verify(driver).getShift();
        verify(driver).getAddress();
        verify(driver).getCounty();
        verify(driver).getName();
    }

    /**
     * Method under test: {@link CPPFoodDelivery#registerRestaurant(Restaurant)}
     */
    @Test
    void testRegisterRestaurant() {
        // Arrange
        CPPFoodDelivery instance = CPPFoodDelivery.getInstance();
        Restaurant restaurant = mock(Restaurant.class);
        when(restaurant.getCuisineType()).thenReturn("Cuisine Type");
        when(restaurant.getAddress()).thenReturn("42 Main St");
        when(restaurant.getCounty()).thenReturn("3");
        when(restaurant.getName()).thenReturn("Name");
        when(restaurant.getOperatingHours()).thenReturn(new HashMap<>());

        // Act
        instance.registerRestaurant(restaurant);

        // Assert
        verify(restaurant).getCuisineType();
        verify(restaurant).getOperatingHours();
        verify(restaurant).getAddress();
        verify(restaurant).getCounty();
        verify(restaurant).getName();
    }

    /**
     * Method under test: {@link CPPFoodDelivery#registerCustomer(Customer)}
     */
    @Test
    void testRegisterCustomer() {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        CPPFoodDelivery instance = CPPFoodDelivery.getInstance();

        // Act
        instance.registerCustomer(new Customer("Name", "42 Main St", "3", new ArrayList<>()));
    }


    /**
     * Method under test: {@link CPPFoodDelivery#getCustomers()}
     */
    @Test
    void testGetCustomers() {
        // Arrange, Act and Assert
        assertTrue(CPPFoodDelivery.getInstance().getCustomers().isEmpty());
    }


    /**
     * Method under test: {@link CPPFoodDelivery#getAvailableDriver(String, String)}
     */
    @Test
    void testGetAvailableDriver() {
        // Arrange, Act and Assert
        assertNull(CPPFoodDelivery.getInstance().getAvailableDriver("3", "Current Time"));
    }
}
