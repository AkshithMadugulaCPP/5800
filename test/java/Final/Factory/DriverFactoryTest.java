package test.java.Final.Factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import Final.Driver;
import Final.Factory.DriverFactory;
import org.junit.jupiter.api.Test;

class DriverFactoryTest {
    /**
     * Method under test: {@link DriverFactory#createUser(String, String, String)}
     */
    @Test
    void testCreateUser() {
        // Arrange, Act and Assert
        assertThrows(UnsupportedOperationException.class,
                () -> (new DriverFactory()).createUser("Name", "42 Main St", "3"));
    }

    /**
     * Method under test:
     * {@link DriverFactory#createUser(String, String, String, String)}
     */
    @Test
    void testCreateUser2() {
        // Arrange and Act
        Driver actualCreateUserResult = (new DriverFactory()).createUser("Name", "42 Main St", "3", "Shift");

        // Assert
        assertEquals("3", actualCreateUserResult.getOperatingCounty());
        assertEquals("3", actualCreateUserResult.getCounty());
        assertEquals("42 Main St", actualCreateUserResult.getAddress());
        assertEquals("Name", actualCreateUserResult.getName());
        assertEquals("Shift", actualCreateUserResult.getShift());
    }
}
