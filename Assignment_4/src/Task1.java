interface PaymentStrategy {
    void processPayment(double amount);
}


class CreditCardPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " with Credit Card.");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " with PayPal.");
    }
}

class CryptoPayment implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Paid $" + amount + " with Cryptocurrency.");
    }
}


class ShoppingCart {
    private PaymentStrategy paymentMethod;

    public void setPaymentMethod(PaymentStrategy paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void checkout(double amount) {
        if (paymentMethod != null) {
            paymentMethod.processPayment(amount);
        } else {
            System.out.println("No payment method selected.");
        }
    }
}

public class Task1 {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.setPaymentMethod(new CreditCardPayment());
        cart.checkout(100);

        cart.setPaymentMethod(new PayPalPayment());
        cart.checkout(50);

        cart.setPaymentMethod(new CryptoPayment());
        cart.checkout(300);
    }
}
