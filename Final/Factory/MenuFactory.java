package Final.Factory;

import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;
import Final.enums.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    public static List<BasicMeal> createMenu(String cuisineType) {
        List<BasicMeal> menu = new ArrayList<>();
        switch (cuisineType.toLowerCase()) {
            case "mexican":
                menu.add(new BasicMeal(MenuItem.BURGER));
                menu.add(new BasicMeal(MenuItem.FRIES));
                menu.add(new BasicMeal(MenuItem.HOT_DOG));
                menu.add(new BasicMeal(MenuItem.TACOS));
                break;
            case "thai":
                menu.add(new BasicMeal(MenuItem.PAD_THAI));
                menu.add(new BasicMeal(MenuItem.GREEN_CURRY));
                menu.add(new BasicMeal(MenuItem.TOM_YUM_SOUP));
                menu.add(new BasicMeal(MenuItem.SPRING_ROLLS));
                break;
            case "american":
                menu.add(new BasicMeal(MenuItem.BURGER));
                menu.add(new BasicMeal(MenuItem.FRIES));
                menu.add(new BasicMeal(MenuItem.HOT_DOG));
                menu.add(new BasicMeal(MenuItem.STEAK));
                break;
            case "indian":
                menu.add(new BasicMeal(MenuItem.SAMOSA));
                menu.add(new BasicMeal(MenuItem.BUTTER_CHICKEN));
                menu.add(new BasicMeal(MenuItem.PANEER_TIKKA));
                menu.add(new BasicMeal(MenuItem.MASALA_DOSA));
                break;
            default:
                System.out.println("Invalid cuisine type");
                break;
        }
        return menu;
    }

}

