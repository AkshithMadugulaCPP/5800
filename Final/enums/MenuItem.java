package Final.enums;

import java.util.ArrayList;
import java.util.List;

public enum MenuItem {
    // Mexican Cuisine
    BURRITO("Burrito", "A savory Mexican wrap", 15, 35, 20, new String[]{""}),
    TACOS("Tacos", "Authentic Mexican tacos", 12, 30, 18, new String[]{"NUT_ALLERGY"}),
    QUESADILLA("Quesadilla", "Cheesy Mexican delight", 18, 25, 22, new String[]{"NUT_ALLERGY", "LACTOSE"}),
    ENCHILADAS("Enchiladas", "Spicy Mexican dish", 20, 30, 25, new String[]{"NUT_ALLERGY", "SPICY"}),

    // Thai Cuisine
    PAD_THAI("Pad Thai", "Classic Thai stir-fried noodles", 12, 35, 20, new String[]{"NUT_ALLERGY"}),
    GREEN_CURRY("Green Curry", "Traditional Thai curry", 20, 25, 15, new String[]{"NUT_ALLERGY", "SPICY"}),
    TOM_YUM_SOUP("Tom Yum Soup", "Spicy Thai soup", 10, 15, 8, new String[]{"", "SPICY"}),
    SPRING_ROLLS("Spring Rolls", "Crispy Thai appetizers", 8, 20, 10, new String[]{""}),

    // Indian Cuisine
    SAMOSA("Samosa", "Popular Indian appetizer", 10, 15, 5, new String[]{"NUT_ALLERGY", "SPICY"}),
    BUTTER_CHICKEN("Butter Chicken", "Rich Indian chicken curry", 25, 20, 30, new String[]{"SPICY"}),
    PANEER_TIKKA("Paneer Tikka", "Spicy Indian cottage cheese skewers", 15, 10, 18, new String[]{"LACTOSE"}),
    MASALA_DOSA("Masala Dosa", "Crispy Indian pancake with potato filling", 8, 30, 10, new String[]{""}),

    // American Cuisine
    BURGER("Burger", "Classic American beef burger", 20, 30, 25, new String[]{"LACTOSE"}),
    FRIES("Fries", "Crispy American French fries", 10, 40, 5, new String[]{""}),
    HOT_DOG("Hot Dog", "All-American hot dog", 15, 25, 10, new String[]{"SPICY"}),
    STEAK("Steak", "Juicy American steak", 30, 10, 40, new String[]{"LACTOSE"});


    private final String name;
    private final String description;
    private final int fats;
    private final int carbs;
    private final int protein;
    private final String[] dietRestrictions;

    MenuItem(String name, String description, int fats, int carbs, int protein, String[] dietRestrictions) {
        this.name = name;
        this.description = description;
        this.fats = fats;
        this.carbs = carbs;
        this.protein = protein;
        this.dietRestrictions = dietRestrictions;
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

    public String[] getDietRestrictions() {
        return dietRestrictions;
    }
}