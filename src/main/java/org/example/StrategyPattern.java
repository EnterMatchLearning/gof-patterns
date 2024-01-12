package org.example;

interface PaymentStrategy {
    void pay(int amount);
}

class CreditCardStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " with credit card.");
    }
}

class PaypalStrategy implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        System.out.println("Paid " + amount + " with Paypal.");
    }
}

// The shopping cart takes a payment strategy and uses it to pay.
class ShoppingCart {
    private final PaymentStrategy paymentStrategy;

    public ShoppingCart(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void pay(int amount) {
        paymentStrategy.pay(amount);
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart(new CreditCardStrategy());
        cart.pay(100);
        cart = new ShoppingCart(new PaypalStrategy());
        cart.pay(200);
    }
}
