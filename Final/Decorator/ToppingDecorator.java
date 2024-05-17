package Final.Decorator;

public class ToppingDecorator extends MealDecorator {
    private String topping;

    public ToppingDecorator(Meal decoratedMeal, String topping) {
        super(decoratedMeal);
        this.topping = topping;
    }

    public String getDescription() {
        return decoratedMeal.getDescription() + ", with " + topping;
    }

    public int getFats() {
        return decoratedMeal.getFats() + 2; // Example value
    }

    public int getCarbs() {
        return decoratedMeal.getCarbs() + 3; // Example value
    }

    public int getProtein() {
        return decoratedMeal.getProtein() + 1; // Example value
    }
}
