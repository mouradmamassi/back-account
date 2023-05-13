import model.Account;
import model.Operation;

import java.time.LocalDate;

public class AccountMain {

    public static void main(String [] args){

        Account account = new Account();
        //create operations
        Operation operation1 = new Operation(234.45, LocalDate.of(2023, 01, 12));
        Operation operation2 = new Operation(2.54, LocalDate.of(2023, 05, 12));
        Operation operation3 = new Operation(23.25, LocalDate.of(2023, 04, 12));
        Operation operation4 = new Operation(24.5, LocalDate.of(2023, 03, 12));

        //make deposit
        account.deposit(operation1);
        account.deposit(operation2);
        account.deposit(operation3);
        account.deposit(operation4);

        // get balance
        System.out.printf("Account balance : %.2f$\n", account.getBalance());
        //show history of operations
        System.out.println(account.showHistory());
    }
}
