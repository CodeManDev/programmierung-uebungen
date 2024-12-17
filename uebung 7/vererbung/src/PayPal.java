public class PayPal extends PaymentMethod{
    public PayPal(String holder) {
        super(holder);
    }

    public void payWithPayPal(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR using PayPal.");
    }
}
