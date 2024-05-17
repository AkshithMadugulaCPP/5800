package Final.Decorator;

public class BasicMeal implements Meal {
    private String description;
    private int fats;
    private int carbs;
    private int protein;

    public BasicMeal(String description, int fats, int carbs, int protein) {
        this.description = description;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
    }

    public String getDescription() {
        return description;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbs() {
        return carbs;
    }

    public int getProtein() {
        return protein;
    }
}
