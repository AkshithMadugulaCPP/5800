package test.java.Final.Decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Final.Decorator.BasicMeal;
import Final.Decorator.DietaryRestrictionDecorator;
import Final.Decorator.MealDecorator;
import Final.enums.MenuItem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MealDecoratorTest {
    /**
     * Method under test: {@link MealDecorator#getDescription()}
     */
    @Test
    void testGetDescription() {
        // Arrange, Act and Assert
        Assertions.assertEquals("A savory Mexican wrap, Restriction",
                (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getDescription());
    }

    /**
     * Method under test: {@link MealDecorator#getFats()}
     */
    @Test
    void testGetFats() {
        // Arrange, Act and Assert
        assertEquals(15, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getFats());
    }

    /**
     * Method under test: {@link MealDecorator#getCarbs()}
     */
    @Test
    void testGetCarbs() {
        // Arrange, Act and Assert
        assertEquals(35, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getCarbs());
    }

    /**
     * Method under test: {@link MealDecorator#getProtein()}
     */
    @Test
    void testGetProtein() {
        // Arrange, Act and Assert
        assertEquals(20, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getProtein());
    }
}
