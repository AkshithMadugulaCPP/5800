package Final.State;

import Final.Order;

public class DeliveredState implements OrderState {
    public void next(Order order) {
        System.out.println("The order is already delivered.");
    }

    public void prev(Order order) {
        order.setState(new PickedUpState());
    }

    public String getStatus() {
        return "Order Delivered";
    }
}
