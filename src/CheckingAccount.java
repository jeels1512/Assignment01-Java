public class CheckingAccount extends Account {
    private double monthlyFee;

    public CheckingAccount(double balance, double fee) {
        super(balance);
        this.monthlyFee = fee;
    }

    public void applyMonthlyFee() {
        balance -= monthlyFee;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }
}
