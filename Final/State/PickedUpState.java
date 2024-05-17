package Final.State;

import Final.Order;

public class PickedUpState implements OrderState {
    public void next(Order order) {
        order.setState(new DeliveredState());
    }

    public void prev(Order order) {
        order.setState(new CreatedState());
    }

    public String getStatus() {
        return "Order Picked Up";
    }
}
