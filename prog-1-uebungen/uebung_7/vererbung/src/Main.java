import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CreditCard creditCard = new CreditCard("Alice");
        creditCard.payWithCreditCard(100.0);

        PayPal payPal = new PayPal("Alice");
        payPal.payWithPayPal(100.0);

        GooglePay googlePay = new GooglePay("Alice");
        googlePay.payWithGooglePay(100.0);

        List<PaymentMethod> paymentMethods = List.of(creditCard, payPal, googlePay);

        for (PaymentMethod paymentMethod : paymentMethods) {
            if (paymentMethod instanceof CreditCard cc) {
                cc.payWithCreditCard(100.0);
            } else if (paymentMethod instanceof PayPal pp) {
                pp.payWithPayPal(100.0);
            } else if (paymentMethod instanceof GooglePay gp) {
                gp.payWithGooglePay(100.0);
            }
        }
    }
}