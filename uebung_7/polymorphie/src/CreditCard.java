public final class CreditCard extends PaymentMethod {
    public CreditCard(String holder) {
        super(holder);
    }

    @Override
    public void processPayment(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR by credit card.");
    }

    @Override
    public void refundPayment(double amount) {
        System.out.println(getHolder() + " received a refund of " + amount + " EUR by credit card.");
    }
}
