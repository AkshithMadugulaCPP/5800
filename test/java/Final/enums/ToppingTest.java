package test.java.Final.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Final.enums.Topping;
import org.junit.jupiter.api.Test;

class ToppingTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link Topping#getCarbs()}
     *   <li>{@link Topping#getDescription()}
     *   <li>{@link Topping#getFats()}
     *   <li>{@link Topping#getName()}
     *   <li>{@link Topping#getProtein()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        Topping valueOfResult = Topping.valueOf("CHEESE");

        // Act
        int actualCarbs = valueOfResult.getCarbs();
        String actualDescription = valueOfResult.getDescription();
        int actualFats = valueOfResult.getFats();
        String actualName = valueOfResult.getName();

        // Assert
        assertEquals("Cheddar cheese", actualDescription);
        assertEquals("Cheese", actualName);
        assertEquals(1, actualCarbs);
        assertEquals(3, valueOfResult.getProtein());
        assertEquals(5, actualFats);
    }
}
