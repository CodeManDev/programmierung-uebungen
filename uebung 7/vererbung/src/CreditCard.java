public class CreditCard extends PaymentMethod {
    public CreditCard(String holder) {
        super(holder);
    }

    public void payWithCreditCard(double amount) {
        System.out.println(getHolder() + " paid " + amount + " EUR by credit card.");
    }
}
