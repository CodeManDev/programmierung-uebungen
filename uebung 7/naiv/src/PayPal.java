public class PayPal {

    private String accountHolder;

    public PayPal(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public void payWithPayPal(double amount) {
        System.out.println(this.accountHolder + " paid " + amount + " EUR using PayPal.");
    }

}
