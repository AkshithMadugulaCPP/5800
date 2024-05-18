package test.java.Final;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Final.Driver;
import Final.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class UserTest {
    /**
     * Method under test: {@link User#getAddress()}
     */
    @Test
    void testGetAddress() {
        // Arrange, Act and Assert
        Assertions.assertEquals("42 Main St", (new Driver("Name", "42 Main St", "3", "Shift")).getAddress());
    }
}
