package Final.State;

import Final.Order;

class ReadyForPickupState implements OrderState {
    public void next(Order order) {
        order.setState(new PickedUpState());
    }

    public void prev(Order order) {
        order.setState(new PreparingState());
    }

    public String getStatus() {
        return "Order Ready for Pickup";
    }
}
