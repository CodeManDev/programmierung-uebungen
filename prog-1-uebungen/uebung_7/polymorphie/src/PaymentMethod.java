public abstract class PaymentMethod {

    private String holder;

    public PaymentMethod(String holder) {
        this.holder = holder;
    }

    public abstract void processPayment(double amount);

    public abstract void refundPayment(double amount);

    public String getHolder() {
        return holder;
    }
}
