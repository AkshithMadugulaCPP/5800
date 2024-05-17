package Final.State;

import Final.Order;

public class CreatedState implements OrderState {
    public void next(Order order) {
        order.setState(new PickedUpState());
    }

    public void prev(Order order) {
        System.out.println("The order is in its initial state.");
    }

    public String getStatus() {
        return "Order Created";
    }
}
