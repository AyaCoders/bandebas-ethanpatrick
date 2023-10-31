class BankAccount {
    private static int accountID;
    private static String accountName;
    private static double balance;

    BankAccount (int accountID, String accountName, double balance) {
        this.accountID = accountID;
        this.accountName = accountName;
        this.balance = balance;
    }

    public static void deposit (double amount) {
        balance += amount;
    }

    public static void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("\n\tCan't withdraw..." +
                               "\n\tAccount Balance: " + balance);
            return;
        }

        balance -= amount;
    }

    public static void displayBalance () {
        System.out.printf("\n\tCurrent Balance: %.2f\n", balance);
    }

    public static int getAccountID () {
        return accountID;
    }

    public static String getAccountName () {
        return accountName;
    }

    public static double getBalance() {
        return balance;
    }
}