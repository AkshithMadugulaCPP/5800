package test.java.Final.Factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Final.Customer;
import Final.Factory.CustomerFactory;
import org.junit.jupiter.api.Test;

class CustomerFactoryTest {
    /**
     * Method under test: {@link CustomerFactory#createUser(String, String, String)}
     */
    @Test
    void testCreateUser() {
        // Arrange and Act
        Customer actualCreateUserResult = (new CustomerFactory()).createUser("Name", "42 Main St", "3");

        // Assert
        assertEquals("3", actualCreateUserResult.getCounty());
        assertEquals("42 Main St", actualCreateUserResult.getAddress());
        assertEquals("Name", actualCreateUserResult.getName());
        assertTrue(actualCreateUserResult.getDietaryRestrictions().isEmpty());
    }
}
