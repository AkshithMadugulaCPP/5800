package Final.Decorator;

import Final.enums.Topping;

public class ToppingDecorator extends MealDecorator {
    private Topping topping;

    public ToppingDecorator(Meal decoratedMeal, Topping topping) {
        super(decoratedMeal);
        this.topping = topping;
    }

    public String getDescription() {
        return decoratedMeal.getDescription() + ", with " + topping.getDescription();
    }

    public int getFats() {
        return decoratedMeal.getFats() + topping.getFats();
    }

    public int getCarbs() {
        return decoratedMeal.getCarbs() + topping.getCarbs();
    }

    public int getProtein() {
        return decoratedMeal.getProtein() + topping.getProtein();
    }
}
