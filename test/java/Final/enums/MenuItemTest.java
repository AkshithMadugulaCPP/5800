package test.java.Final.enums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Final.enums.MenuItem;
import org.junit.jupiter.api.Test;

class MenuItemTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link MenuItem#getCarbs()}
     *   <li>{@link MenuItem#getDescription()}
     *   <li>{@link MenuItem#getDietRestrictions()}
     *   <li>{@link MenuItem#getFats()}
     *   <li>{@link MenuItem#getName()}
     *   <li>{@link MenuItem#getProtein()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange
        MenuItem valueOfResult = MenuItem.valueOf("BURRITO");

        // Act
        int actualCarbs = valueOfResult.getCarbs();
        String actualDescription = valueOfResult.getDescription();
        valueOfResult.getDietRestrictions();
        int actualFats = valueOfResult.getFats();
        String actualName = valueOfResult.getName();

        // Assert
        assertEquals("A savory Mexican wrap", actualDescription);
        assertEquals("Burrito", actualName);
        assertEquals(15, actualFats);
        assertEquals(20, valueOfResult.getProtein());
        assertEquals(35, actualCarbs);
    }
}
