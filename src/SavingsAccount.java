public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(double balance, double rate) {
        super(balance);
        this.interestRate = rate;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        balance += calculateInterest();
    }
}
