package Final;

import Final.Decorator.BasicMeal;
import Final.Decorator.Meal;
import Final.Factory.MenuFactory;
import java.util.List;
import java.util.Map;

public class Restaurant extends User {
    private Map<String, String> operatingHours;
    private String cuisineType;
    private List<BasicMeal> menu;

    public Restaurant(String name, String address, String county, Map<String, String> operatingHours, String cuisineType) {
        super(name, address, county);
        this.operatingHours = operatingHours;
        this.cuisineType = cuisineType;
        this.menu = MenuFactory.createMenu(cuisineType);
    }

    public Map<String, String> getOperatingHours() {
        return operatingHours;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public List<BasicMeal> getMenu() {
        return menu;
    }
}
