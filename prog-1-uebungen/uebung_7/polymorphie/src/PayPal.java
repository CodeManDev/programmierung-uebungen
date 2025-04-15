public final class PayPal extends PaymentMethod {
    public PayPal(String holder) {
        super(holder);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR using PayPal.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println(getHolder() + " received a refund of " + amount + " EUR via PayPal.");
    }
}
