package test.java.Final;

import Final.*;
import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;
import Final.Decorator.ToppingDecorator;
import Final.Factory.CustomerFactory;
import Final.Factory.DriverFactory;
import Final.Factory.RestaurantFactory;
import Final.Singleton.CPPFoodDelivery;
import Final.enums.DietaryRestriction;
import Final.enums.MenuItem;
import Final.enums.Topping;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDateTime;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FinalMainTest {

    @Mock
    private CPPFoodDelivery mockPlatform;

    @Mock
    private Customer mockCustomer;

    @Mock
    private Restaurant mockRestaurant;

    @Mock
    private Order mockOrder;

    @InjectMocks
    private FinalMain finalMain;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockPlatform = mock(CPPFoodDelivery.class);
        mockCustomer = mock(Customer.class);
        mockRestaurant = mock(Restaurant.class);
        mockOrder = mock(Order.class);
    }

    @Test
    void testChooseDietaryRestriction() {
        assertEquals(DietaryRestriction.SPICY, FinalMain.chooseDietaryRestriction(0));
        assertEquals(DietaryRestriction.LACTOSE, FinalMain.chooseDietaryRestriction(1));
        assertEquals(DietaryRestriction.NUT_ALLERGY, FinalMain.chooseDietaryRestriction(2));
        assertEquals(DietaryRestriction.NO_RESTRICTION, FinalMain.chooseDietaryRestriction(3));
    }

    @Test
    void testGetSelectableMeals() {
        List<BasicMeal> meals = Arrays.asList(
                new BasicMeal(MenuItem.BURRITO),
                new BasicMeal(MenuItem.TACOS)
        );
        when(mockRestaurant.getMenu()).thenReturn(meals);

        List<BasicMeal> result = FinalMain.getSelectableMeals(mockRestaurant, DietaryRestriction.NO_RESTRICTION);
        assertEquals(2, result.size());
    }

    @Test
    void testCreateOrder() {
        Meal mockMeal = mock(Meal.class);
        when(mockCustomer.getName()).thenReturn("John Doe");
        when(mockRestaurant.getName()).thenReturn("Test Restaurant");

        Order order = FinalMain.createOrder(mockRestaurant, mockCustomer, mockMeal);
        assertNotNull(order);
        assertEquals(mockRestaurant, order.getRestaurant());
        assertEquals(mockCustomer, order.getCustomer());
        assertTrue(order.getFoodItems().contains(mockMeal));
    }

}
