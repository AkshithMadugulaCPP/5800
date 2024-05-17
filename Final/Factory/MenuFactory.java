package Final.Factory;

import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;

import java.util.ArrayList;
import java.util.List;

public class MenuFactory {
    public static List<Meal> createMenu(String cuisineType) {
        List<Meal> menu = new ArrayList<>();
        switch (cuisineType.toLowerCase()) {
            case "mexican":
                menu.add(new BasicMeal("Taco", 10, 20, 5));
                menu.add(new BasicMeal("Burrito", 15, 30, 10));
                menu.add(new BasicMeal("Quesadilla", 12, 25, 7));
                menu.add(new BasicMeal("Nachos", 8, 20, 3));
                break;
            case "thai":
                menu.add(new BasicMeal("Pad Thai", 12, 40, 8));
                menu.add(new BasicMeal("Green Curry", 15, 35, 7));
                menu.add(new BasicMeal("Tom Yum Soup", 10, 25, 5));
                menu.add(new BasicMeal("Spring Rolls", 5, 15, 2));
                break;
            // Add more cuisines and their menus as needed
        }
        return menu;
    }
}
