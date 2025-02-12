import java.util.Scanner;

public class AccountBalanceApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Initialize accounts
        CheckingAccount checking = new CheckingAccount(2500.00, 0.00);
        SavingsAccount savings = new SavingsAccount(5000.00, 0.012);

        System.out.println("Bank Application");
        System.out.printf("\nStarting Balances\nChecking: $%.2f\nSavings:  $%.2f\n", checking.getBalance(), savings.getBalance());

        // Process transactions
        boolean keepGoing = true;
        while (keepGoing) {
            System.out.print("\nWithdrawal OR Deposit (w or d): ");
            char transType = sc.next().toLowerCase().charAt(0);

            System.out.print("Checking OR Savings? (c or s): ");
            char accountType = sc.next().toLowerCase().charAt(0);

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            if (accountType == 'c') {
                if (transType == 'w') checking.withdraw(amount);
                else checking.deposit(amount);
            } else {
                if (transType == 'w') savings.withdraw(amount);
                else savings.deposit(amount);
            }

            System.out.print("\nWould you still like to continue (y or n): ");
            keepGoing = sc.next().toLowerCase().charAt(0) == 'n';
        }

        // Apply monthly fees and interest
        checking.applyMonthlyFee();
        savings.applyInterest();

        System.out.println("\nMonthly Payments and Fees");
        System.out.printf("Checking fee:              $%.2f\n", checking.getMonthlyFee());
        System.out.printf("Savings interest payment:  $%.2f\n", savings.calculateInterest());

        // Display final balances
        System.out.println("\nTotal Balance:");
        System.out.printf("Checking: $%.2f\nSavings:  $%.2f\n", checking.getBalance(), savings.getBalance());

        sc.close();
    }
}
