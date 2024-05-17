package Final;

import Final.Decorator.Meal;

import java.util.List;
import java.util.Map;

public class Restaurant extends User {
    private Map<String, String> operatingHours;
    private String cuisineType;
    private List<Meal> menu;

    public Restaurant(String name, String address, String county, Map<String, String> operatingHours, String cuisineType) {
        super(name, address, county);
        this.operatingHours = operatingHours;
        this.cuisineType = cuisineType;
    }

    public Map<String, String> getOperatingHours() {
        return operatingHours;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public void setMenu(List<Meal> menu) {
        this.menu = menu;
    }

    public List<Meal> getMenu() {
        return menu;
    }
}


