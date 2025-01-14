import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<PaymentMethod> paymentMethods = List.of(new CreditCard("Alice"), new PayPal("Alice"), new GooglePay("Alice"));

        for (PaymentMethod paymentMethod : paymentMethods) {
            paymentMethod.processPayment(100.0);
            paymentMethod.refundPayment(50.0);
        }
    }
}