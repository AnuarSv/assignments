interface OrderState {
    void payOrder(Order order);
    void shipOrder(Order order);
    void deliverOrder(Order order);
    void cancelOrder(Order order);
}

class NewOrderState implements OrderState {
    public void payOrder(Order order) {
        System.out.println("Order paid.");
        order.setState(new PaidOrderState());
    }

    public void shipOrder(Order order) {
        System.out.println("Order can't be shipped before payment.");
    }

    public void deliverOrder(Order order) {
        System.out.println("Order can't be delivered before payment.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order cancelled.");
        order.setState(new CancelledOrderState());
    }
}

class PaidOrderState implements OrderState {
    public void payOrder(Order order) {
        System.out.println("Order is already paid.");
    }

    public void shipOrder(Order order) {
        System.out.println("Order shipped.");
        order.setState(new ShippedOrderState());
    }

    public void deliverOrder(Order order) {
        System.out.println("Order can't be delivered before shipment.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order can't be cancelled after payment.");
    }
}

class ShippedOrderState implements OrderState {
    public void payOrder(Order order) {
        System.out.println("Order is already paid.");
    }

    public void shipOrder(Order order) {
        System.out.println("Order is already shipped.");
    }

    public void deliverOrder(Order order) {
        System.out.println("Order delivered.");
        order.setState(new DeliveredOrderState());
    }

    public void cancelOrder(Order order) {
        System.out.println("Order can't be cancelled after shipment.");
    }
}

class DeliveredOrderState implements OrderState {
    public void payOrder(Order order) {
        System.out.println("Order is already paid.");
    }

    public void shipOrder(Order order) {
        System.out.println("Order is already delivered.");
    }

    public void deliverOrder(Order order) {
        System.out.println("Order is already delivered.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order can't be cancelled after delivery.");
    }
}

class CancelledOrderState implements OrderState {
    public void payOrder(Order order) {
        System.out.println("Order is cancelled and can't be paid.");
    }

    public void shipOrder(Order order) {
        System.out.println("Order is cancelled and can't be shipped.");
    }

    public void deliverOrder(Order order) {
        System.out.println("Order is cancelled and can't be delivered.");
    }

    public void cancelOrder(Order order) {
        System.out.println("Order is already cancelled.");
    }
}

class Order {
    private OrderState state = new NewOrderState();

    public void setState(OrderState state) {
        this.state = state;
    }

    public void payOrder() {
        state.payOrder(this);
    }

    public void shipOrder() {
        state.shipOrder(this);
    }

    public void deliverOrder() {
        state.deliverOrder(this);
    }

    public void cancelOrder() {
        state.cancelOrder(this);
    }
}

public class Task4 {
    public static void main(String[] args) {
        Order order = new Order();

        order.payOrder();
        order.shipOrder();
        order.deliverOrder();
    }
}
