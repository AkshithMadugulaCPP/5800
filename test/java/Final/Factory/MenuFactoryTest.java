package test.java.Final.Factory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Final.Decorator.BasicMeal;

import java.util.List;

import Final.Factory.MenuFactory;
import org.junit.jupiter.api.Test;

class MenuFactoryTest {
    /**
     * Method under test: {@link MenuFactory#createMenu(String)}
     */
    @Test
    void testCreateMenu() {
        // Arrange and Act
        List<BasicMeal> actualCreateMenuResult = MenuFactory.createMenu("Cuisine Type");

        // Assert
        assertTrue(actualCreateMenuResult.isEmpty());
    }

    /**
     * Method under test: {@link MenuFactory#createMenu(String)}
     */
    @Test
    void testCreateMenu2() {
        // Arrange and Act
        List<BasicMeal> actualCreateMenuResult = MenuFactory.createMenu("american");

        // Assert
        assertEquals(4, actualCreateMenuResult.size());
        assertEquals(10, actualCreateMenuResult.get(3).getCarbs());
        assertEquals(25, actualCreateMenuResult.get(2).getCarbs());
        assertEquals(30, actualCreateMenuResult.get(0).getCarbs());
        assertEquals(40, actualCreateMenuResult.get(1).getCarbs());
    }

    /**
     * Method under test: {@link MenuFactory#createMenu(String)}
     */
    @Test
    void testCreateMenu3() {
        // Arrange and Act
        List<BasicMeal> actualCreateMenuResult = MenuFactory.createMenu("indian");

        // Assert
        assertEquals(4, actualCreateMenuResult.size());
        assertEquals(10, actualCreateMenuResult.get(2).getCarbs());
        assertEquals(15, actualCreateMenuResult.get(0).getCarbs());
        assertEquals(20, actualCreateMenuResult.get(1).getCarbs());
        assertEquals(30, actualCreateMenuResult.get(3).getCarbs());
    }

    /**
     * Method under test: {@link MenuFactory#createMenu(String)}
     */
    @Test
    void testCreateMenu4() {
        // Arrange and Act
        List<BasicMeal> actualCreateMenuResult = MenuFactory.createMenu("mexican");

        // Assert
        assertEquals(4, actualCreateMenuResult.size());
        assertEquals(25, actualCreateMenuResult.get(2).getCarbs());
        assertEquals(30, actualCreateMenuResult.get(0).getCarbs());
        assertEquals(30, actualCreateMenuResult.get(3).getCarbs());
        assertEquals(40, actualCreateMenuResult.get(1).getCarbs());
    }

    /**
     * Method under test: {@link MenuFactory#createMenu(String)}
     */
    @Test
    void testCreateMenu5() {
        // Arrange and Act
        List<BasicMeal> actualCreateMenuResult = MenuFactory.createMenu("thai");

        // Assert
        assertEquals(4, actualCreateMenuResult.size());
        assertEquals(15, actualCreateMenuResult.get(2).getCarbs());
        assertEquals(20, actualCreateMenuResult.get(3).getCarbs());
        assertEquals(25, actualCreateMenuResult.get(1).getCarbs());
        assertEquals(35, actualCreateMenuResult.get(0).getCarbs());
    }
}
