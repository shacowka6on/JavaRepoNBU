public class Money {
    private double amount;
    private String currency;

    public Money(double amount, String currency) {
        this.amount = amount;
        this.currency = currency;
    }

    public double getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void add(Money money) {
        if (this.currency.equals(money.getCurrency())) {
            this.amount += money.getAmount();
        } else {
            System.out.println("Currency mismatch!");
        }
    }

    public void subtract(Money money) {
        if (this.currency.equals(money.getCurrency())) {
            if (this.amount >= money.getAmount()) {
                this.amount -= money.getAmount();
            } else {
                System.out.println("Insufficient funds!");
            }
        } else {
            System.out.println("Currency mismatch!");
        }
    }

    @Override
    public String toString() {
        return String.format("%.2f %s", amount, currency);
    }
}
