package test.java.Final.Decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;
import Final.Decorator.ToppingDecorator;
import Final.enums.MenuItem;
import Final.enums.Topping;
import org.junit.jupiter.api.Test;

class ToppingDecoratorTest {
    /**
     * Method under test: {@link ToppingDecorator#getDescription()}
     */
    @Test
    void testGetDescription() {
        // Arrange, Act and Assert
        assertEquals("A savory Mexican wrap, with Cheddar cheese",
                (new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE)).getDescription());
        assertEquals("A savory Mexican wrap, with Cheddar cheese, with Cheddar cheese",
                (new ToppingDecorator(new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE), Topping.CHEESE))
                        .getDescription());
    }

    /**
     * Method under test: {@link ToppingDecorator#getFats()}
     */
    @Test
    void testGetFats() {
        // Arrange, Act and Assert
        assertEquals(20, (new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE)).getFats());
        assertEquals(25,
                (new ToppingDecorator(new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE), Topping.CHEESE))
                        .getFats());
    }

    /**
     * Method under test: {@link ToppingDecorator#getCarbs()}
     */
    @Test
    void testGetCarbs() {
        // Arrange, Act and Assert
        assertEquals(36, (new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE)).getCarbs());
        assertEquals(37,
                (new ToppingDecorator(new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE), Topping.CHEESE))
                        .getCarbs());
    }

    /**
     * Method under test: {@link ToppingDecorator#getProtein()}
     */
    @Test
    void testGetProtein() {
        // Arrange, Act and Assert
        assertEquals(23, (new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE)).getProtein());
        assertEquals(26,
                (new ToppingDecorator(new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE), Topping.CHEESE))
                        .getProtein());
    }

    /**
     * Method under test: {@link ToppingDecorator#ToppingDecorator(Meal, Topping)}
     */
    @Test
    void testNewToppingDecorator() {
        // Arrange and Act
        ToppingDecorator actualToppingDecorator = new ToppingDecorator(new BasicMeal(MenuItem.BURRITO), Topping.CHEESE);

        // Assert
        Meal meal = actualToppingDecorator.decoratedMeal;
        assertTrue(meal instanceof BasicMeal);
        assertEquals("A savory Mexican wrap", meal.getDescription());
        assertEquals("A savory Mexican wrap, with Cheddar cheese", actualToppingDecorator.getDescription());
        assertEquals(15, meal.getFats());
        assertEquals(20, meal.getProtein());
        assertEquals(20, actualToppingDecorator.getFats());
        assertEquals(23, actualToppingDecorator.getProtein());
        assertEquals(35, meal.getCarbs());
        assertEquals(36, actualToppingDecorator.getCarbs());
    }
}
