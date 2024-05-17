package Final.Decorator;

import Final.enums.DietaryRestriction;
import Final.enums.MenuItem;

public class BasicMeal implements Meal {
    private MenuItem menuItem;

    public BasicMeal(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public String getDescription() {
        return menuItem.getDescription();
    }

    public int getFats() {
        return menuItem.getFats();
    }

    public int getCarbs() {
        return menuItem.getCarbs();
    }

    public int getProtein() {
        return menuItem.getProtein();
    }

    public boolean isMealCompatibleWithDiet(DietaryRestriction diet) {
        for (String restriction : this.menuItem.getDietRestrictions()) {
            if (restriction.equalsIgnoreCase(diet.toString())){
                return false; // Diet present in restrictions, so not compatible
            }
        }
        return true;

    }
}

