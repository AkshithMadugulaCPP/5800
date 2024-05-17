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

    // Getters and setters for order details
    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setFoodItems(List<Meal> foodItems) {
        this.foodItems = foodItems;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public void setOrderCreationTime(LocalDateTime orderCreationTime) {
        this.orderCreationTime = orderCreationTime;
    }

    public void setOrderPickUpTime(LocalDateTime orderPickUpTime) {
        this.orderPickUpTime = orderPickUpTime;
    }

    public void setOrderDeliveredTime(LocalDateTime orderDeliveredTime) {
        this.orderDeliveredTime = orderDeliveredTime;
    }
}
