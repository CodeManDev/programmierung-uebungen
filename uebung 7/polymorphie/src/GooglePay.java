public final class GooglePay extends PaymentMethod {
    public GooglePay(String holder) {
        super(holder);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR using Google Pay.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println(getHolder() + " received a refund of " + amount + " EUR via Google Pay.");
    }
}
