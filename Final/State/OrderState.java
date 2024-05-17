package Final.State;

import Final.Order;

public interface OrderState {
    void next(Order order);
    void prev(Order order);
    String getStatus();
}
