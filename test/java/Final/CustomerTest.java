package test.java.Final;

import static org.junit.jupiter.api.Assertions.assertSame;

import java.util.ArrayList;
import java.util.List;

import Final.Customer;
import org.junit.jupiter.api.Test;

class CustomerTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Customer#Customer(String, String, String, List)}
     *   <li>{@link Customer#getDietaryRestrictions()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        ArrayList<String> dietaryRestrictions = new ArrayList<>();

        // Act and Assert
        assertSame(dietaryRestrictions,
                (new Customer("Name", "42 Main St", "3", dietaryRestrictions)).getDietaryRestrictions());
    }
}
