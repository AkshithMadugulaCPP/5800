package test.java.Final.Decorator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import Final.Decorator.BasicMeal;
import Final.enums.DietaryRestriction;
import Final.enums.MenuItem;
import org.junit.jupiter.api.Test;

class BasicMealTest {
    /**
     * Method under test: {@link BasicMeal#getDescription()}
     */
    @Test
    void testGetDescription() {
        // Arrange, Act and Assert
        assertEquals("A savory Mexican wrap", (new BasicMeal(MenuItem.BURRITO)).getDescription());
    }

    /**
     * Method under test: {@link BasicMeal#getFats()}
     */
    @Test
    void testGetFats() {
        // Arrange, Act and Assert
        assertEquals(15, (new BasicMeal(MenuItem.BURRITO)).getFats());
    }

    /**
     * Method under test: {@link BasicMeal#getCarbs()}
     */
    @Test
    void testGetCarbs() {
        // Arrange, Act and Assert
        assertEquals(35, (new BasicMeal(MenuItem.BURRITO)).getCarbs());
    }

    /**
     * Method under test: {@link BasicMeal#getProtein()}
     */
    @Test
    void testGetProtein() {
        // Arrange, Act and Assert
        assertEquals(20, (new BasicMeal(MenuItem.BURRITO)).getProtein());
    }

    /**
     * Method under test:
     * {@link BasicMeal#isMealCompatibleWithDiet(DietaryRestriction)}
     */
    @Test
    void testIsMealCompatibleWithDiet() {
        // Arrange, Act and Assert
        assertTrue((new BasicMeal(MenuItem.BURRITO)).isMealCompatibleWithDiet(DietaryRestriction.NUT_ALLERGY));
        assertFalse((new BasicMeal(MenuItem.TACOS)).isMealCompatibleWithDiet(DietaryRestriction.NUT_ALLERGY));
        assertTrue((new BasicMeal(MenuItem.BURRITO)).isMealCompatibleWithDiet(DietaryRestriction.SPICY));
        assertTrue((new BasicMeal(MenuItem.BURRITO)).isMealCompatibleWithDiet(DietaryRestriction.LACTOSE));
        assertTrue((new BasicMeal(MenuItem.BURRITO)).isMealCompatibleWithDiet(DietaryRestriction.NO_RESTRICTION));
    }

    /**
     * Method under test: {@link BasicMeal#BasicMeal(MenuItem)}
     */
    @Test
    void testNewBasicMeal() {
        // Arrange and Act
        BasicMeal actualBasicMeal = new BasicMeal(MenuItem.BURRITO);

        // Assert
        assertEquals("A savory Mexican wrap", actualBasicMeal.getDescription());
        assertEquals(15, actualBasicMeal.getFats());
        assertEquals(20, actualBasicMeal.getProtein());
        assertEquals(35, actualBasicMeal.getCarbs());
    }
}
