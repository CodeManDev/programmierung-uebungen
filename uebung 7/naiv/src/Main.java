import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        CreditCard creditCard = new CreditCard("Alice");
        creditCard.payWithCreditCard(100.0);

        PayPal payPal = new PayPal("Alice");
        payPal.payWithPayPal(100.0);

        List<Object> paymentMethods = List.of(creditCard, payPal);

        for (Object paymentMethod : paymentMethods) {
            if (paymentMethod instanceof CreditCard cc) {
                cc.payWithCreditCard(100.0);
            } else if (paymentMethod instanceof PayPal pp) {
                pp.payWithPayPal(100.0);
            }
        }
    }
}