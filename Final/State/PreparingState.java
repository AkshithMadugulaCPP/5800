package Final.State;

import Final.Order;

public class PreparingState implements OrderState {
    public void next(Order order) {
        order.setState(new ReadyForPickupState());
    }

    public void prev(Order order) {
        order.setState(new CreatedState());
    }

    public String getStatus() {
        return "Order Preparing";
    }
}
