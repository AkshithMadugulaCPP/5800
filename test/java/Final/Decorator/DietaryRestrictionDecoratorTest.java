package test.java.Final.Decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Final.Decorator.BasicMeal;
import Final.Decorator.DietaryRestrictionDecorator;
import Final.Decorator.Meal;
import Final.enums.MenuItem;
import org.junit.jupiter.api.Test;

class DietaryRestrictionDecoratorTest {
    /**
     * Method under test: {@link DietaryRestrictionDecorator#getDescription()}
     */
    @Test
    void testGetDescription() {
        // Arrange, Act and Assert
        assertEquals("A savory Mexican wrap, Restriction",
                (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getDescription());
        assertEquals("A savory Mexican wrap, Restriction, Restriction",
                (new DietaryRestrictionDecorator(
                        new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction"), "Restriction"))
                        .getDescription());
    }

    /**
     * Method under test: {@link DietaryRestrictionDecorator#getFats()}
     */
    @Test
    void testGetFats() {
        // Arrange, Act and Assert
        assertEquals(15, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getFats());
        assertEquals(15, (new DietaryRestrictionDecorator(
                new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction"), "Restriction")).getFats());
    }

    /**
     * Method under test: {@link DietaryRestrictionDecorator#getCarbs()}
     */
    @Test
    void testGetCarbs() {
        // Arrange, Act and Assert
        assertEquals(35, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getCarbs());
        assertEquals(35,
                (new DietaryRestrictionDecorator(
                        new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction"), "Restriction"))
                        .getCarbs());
    }


    /**
     * Method under test: {@link DietaryRestrictionDecorator#getProtein()}
     */
    @Test
    void testGetProtein() {
        // Arrange, Act and Assert
        assertEquals(20, (new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction")).getProtein());
        assertEquals(20,
                (new DietaryRestrictionDecorator(
                        new DietaryRestrictionDecorator(new BasicMeal(MenuItem.BURRITO), "Restriction"), "Restriction"))
                        .getProtein());
    }


    /**
     * Method under test:
     * {@link DietaryRestrictionDecorator#DietaryRestrictionDecorator(Meal, String)}
     */
    @Test
    void testNewDietaryRestrictionDecorator() {
        // Arrange and Act
        DietaryRestrictionDecorator actualDietaryRestrictionDecorator = new DietaryRestrictionDecorator(
                new BasicMeal(MenuItem.BURRITO), "Restriction");

        // Assert
        Meal meal = actualDietaryRestrictionDecorator.decoratedMeal;
        assertTrue(meal instanceof BasicMeal);
        assertEquals("A savory Mexican wrap", meal.getDescription());
        assertEquals("A savory Mexican wrap, Restriction", actualDietaryRestrictionDecorator.getDescription());
        assertEquals(15, actualDietaryRestrictionDecorator.getFats());
        assertEquals(15, meal.getFats());
        assertEquals(20, actualDietaryRestrictionDecorator.getProtein());
        assertEquals(20, meal.getProtein());
        assertEquals(35, actualDietaryRestrictionDecorator.getCarbs());
        assertEquals(35, meal.getCarbs());
    }
}
