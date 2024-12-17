public class CreditCard {

    private String cardHolder;

    public CreditCard(String cardHolder) {
        this.cardHolder = cardHolder;
    }

    public void payWithCreditCard(double amount) {
        System.out.println(this.cardHolder + " paid " + amount + " EUR by credit card.");
    }

}
