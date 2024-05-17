package Final.enums;

public enum Topping {
    CHEESE("Cheese", "Cheddar cheese", 5, 1, 3),
    BACON("Bacon", "Crispy bacon", 8, 0, 5),
    GUACAMOLE("Guacamole", "Fresh guacamole", 4, 2, 1);

    private final String name;
    private final String description;
    private final int fats;
    private final int carbs;
    private final int protein;

    Topping(String name, String description, int fats, int carbs, int protein) {
        this.name = name;
        this.description = description;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
    }

    public String getName() {
        return name;
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

