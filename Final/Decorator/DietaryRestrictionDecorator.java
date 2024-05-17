package Final.Decorator;

class DietaryRestrictionDecorator extends MealDecorator {
    private String restriction;

    public DietaryRestrictionDecorator(Meal decoratedMeal, String restriction) {
        super(decoratedMeal);
        this.restriction = restriction;
    }

    public String getDescription() {
        return decoratedMeal.getDescription() + ", " + restriction;
    }

    // Adjust nutritional values based on restriction
    public int getFats() {
        // Implement adjustment logic
        return decoratedMeal.getFats();
    }

    public int getCarbs() {
        // Implement adjustment logic
        return decoratedMeal.getCarbs();
    }

    public int getProtein() {
        // Implement adjustment logic
        return decoratedMeal.getProtein();
    }
}
