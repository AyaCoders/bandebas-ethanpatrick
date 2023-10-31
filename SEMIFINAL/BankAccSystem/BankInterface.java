import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


public class BankInterface {
    public static void main(String[] args) {

        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();

        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        Scanner in = new Scanner(System.in);

        System.out.print("Enter Bank Account ID: ");
        int accountID = in.nextInt();
        in.nextLine(); // flush unnecessary character
        
        System.out.print("Enter Bank Account Name: ");
        String accountName = in.nextLine();
        System.out.print("Enter Intitial Balance: ");
        double balance = in.nextDouble();

        BankAccount newAccount = new BankAccount(accountID, accountName, balance);
        
        int userChoice = 0;
        double withdrawn = 0;
        double deposited = 0;
        do {
            System.out.print("\n========== B A N K  S Y S T E M ==========\n" +
                             "Account ID: " + newAccount.getAccountID() + "\t\tDate: " + currentDate.format(dateFormatter) + 
                             "\nAccount Name: " + newAccount.getAccountName() + "\tTime: " + currentTime.format(timeFormatter) +
                             "\n\n[1] Deposit\t\t[2] Withdraw\n[3] Display Balance\t[0] Exit\nChoice: ");
            
            userChoice = in.nextInt();
            switch(userChoice) {
                case 1:
                    System.out.print("Enter Amount: ");
                    double depositAmount = in.nextDouble();
                    deposited += depositAmount;
                    newAccount.deposit(depositAmount);
                break;

                case 2: 
                    System.out.print("Enter Amount: ");
                    double withdrawAmount = in.nextDouble();

                    if (withdrawAmount <= newAccount.getBalance()) {
                        withdrawn += withdrawAmount;
                    }

                    newAccount.withdraw(withdrawAmount);
                break;

                case 3:
                    newAccount.displayBalance();
                break;
            }

        } while(userChoice != 0);
        System.out.println("\n======== B A N K  R E C E I P T ========\n" + 
                           "Account ID: " + newAccount.getAccountID() + "\t\tDate: " + currentDate.format(dateFormatter) + 
                           "\nAccount Name: " + newAccount.getAccountName() + "\tTime: " + currentTime.format(timeFormatter) +
                           "\n\n\tMoney in Account: " + newAccount.getBalance() + "\n\tWithdrawn: " + withdrawn +
                           "\n\tDeposited: " + deposited + "\n\n    !! E N J O Y  Y O U R  D A Y !!");
    }
}