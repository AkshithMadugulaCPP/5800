package Final;

import Final.Decorator.Meal;
import Final.State.CreatedState;
import Final.State.OrderState;

import java.time.LocalDateTime;
import java.util.List;

public class Order {
    private OrderState state;
    private Restaurant restaurant;
    private Customer customer;
    private List<Meal> foodItems;
    private Driver driver;
    private LocalDateTime orderCreationTime;
    private LocalDateTime orderPickUpTime;
    private LocalDateTime orderDeliveredTime;

    public Order() {
        state = new CreatedState();
    }

    public void setState(OrderState state) {
        this.state = state;
    }

    public void next() {
        state.next(this);
    }

    public void prev() {
        state.prev(this);
    }

    public String getStatus() {
        return state.getStatus();
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Meal> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<Meal> foodItems) {
        this.foodItems = foodItems;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public LocalDateTime getOrderCreationTime() {
        return orderCreationTime;
    }

    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public LocalDateTime getOrderPickUpTime() {
        return orderPickUpTime;
    }

    public void setOrderPickUpTime(LocalDateTime orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public LocalDateTime getOrderDeliveredTime() {
        return orderDeliveredTime;
    }

    public void setOrderDeliveredTime(LocalDateTime orderDeliveredTime) {
        this.orderDeliveredTime = orderDeliveredTime;
    }

    public String displayOrder() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n").append("Order Details: ").append("\n");
        sb.append("Restaurant: ").append(restaurant.getName()).append("\n");
        sb.append("Customer: ").append(customer.getName()).append("\n");
        sb.append("Food Items:\n");
        for (Meal meal : foodItems) {
            sb.append("- ").append(meal.getDescription()).append("\n");
        }
        if (driver != null) {
            sb.append("Driver: ").append(driver.getName()).append("\n");
        }
        sb.append("Order Creation Time: ").append(orderCreationTime).append("\n");
        System.out.println(sb);
        return sb.toString();

    }
}
