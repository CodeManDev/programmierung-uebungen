public class GooglePay extends PaymentMethod {
    public GooglePay(String holder) {
        super(holder);
    }

    public void payWithGooglePay(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR using Google Pay.");
    }
}
