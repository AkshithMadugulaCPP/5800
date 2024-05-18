package Final.Decorator;

public abstract class MealDecorator implements Meal {
    public Meal decoratedMeal;

    public MealDecorator(Meal decoratedMeal) {
        this.decoratedMeal = decoratedMeal;
    }

    public String getDescription() {
        return decoratedMeal.getDescription();
    }

    public int getFats() {
        return decoratedMeal.getFats();
    }

    public int getCarbs() {
        return decoratedMeal.getCarbs();
    }

    public int getProtein() {
        return decoratedMeal.getProtein();
    }
}
