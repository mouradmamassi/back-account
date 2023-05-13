package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class AccountTest {

    Account account;

    @Before
    public void init(){
        account = new Account();
    }
    @Test
    public void depositTest(){
        //arrange
        Operation operation1 = new Operation(12.3, LocalDate.of(2023, 05, 12));
        //act
        account.deposit(operation1);
        //assert
        Assert.assertEquals(1, account.getOperations().size());
    }

    @Test
    public void getOperationsTest(){

        //arrange
        Operation operation1 = new Operation(12.3, LocalDate.of(2023, 05, 12));
        Operation operation2 = new Operation(14.7, LocalDate.of(2023, 05, 12));
        Operation operation3 = new Operation(177.7, LocalDate.of(2023, 04, 12));
        Operation operation4 = new Operation(155.7, LocalDate.of(2023, 06, 12));

        //act
        account.deposit(operation1);
        account.deposit(operation2);
        account.deposit(operation3);
        account.deposit(operation4);
        List<Operation> operationsListBySpecificDate = account.getOperationsBySpecificDate(LocalDate.of(2023, 05, 12));
        List<Operation> operationsListBefore = account.getOperationsBeforeDate(LocalDate.of(2023, 05, 12));
        List<Operation> operationsListAfter = account.getOperationsAfterDate(LocalDate.of(2023, 05, 12));

        //assert
        Assert.assertEquals(2, operationsListBySpecificDate.size());
        Assert.assertEquals(1, operationsListBefore.size());
        Assert.assertEquals(1, operationsListAfter.size());
    }

    @Test
    public void getBalance(){

        //arrange
        Operation operation1 = new Operation(12.3, LocalDate.of(2023, 05, 12));
        Operation operation2 = new Operation(14.7, LocalDate.of(2023, 05, 12));
        Operation operation3 = new Operation(177.7, LocalDate.of(2023, 04, 12));
        Operation operation4 = new Operation(155.7, LocalDate.of(2023, 06, 12));

        //act
        account.deposit(operation1);
        account.deposit(operation2);
        account.deposit(operation3);
        account.deposit(operation4);
        double balance = account.getBalance();


        //assert
        Assert.assertEquals("Account balance was not correct.", 360.4, balance, 0);
    }

    @Test
    public void showHistory() {
        //arrange
        Operation operation1 = new Operation(12.3, LocalDate.of(2023, 05, 12));
        Operation operation2 = new Operation(14.7, LocalDate.of(2023, 03, 12));
        Operation operation3 = new Operation(177.7, LocalDate.of(2023, 04, 12));
        Operation operation4 = new Operation(155.7, LocalDate.of(2023, 06, 12));

        //act
        account.deposit(operation1);
        account.deposit(operation2);
        account.deposit(operation3);
        account.deposit(operation4);

        //assert
        Assert.assertEquals("amount = 155,70$ - date = 2023-06-12 - balance = 360,40$\n" +
                ",amount = 12,30$ - date = 2023-05-12 - balance = 204,70$\n" +
                ",amount = 177,70$ - date = 2023-04-12 - balance = 192,40$\n" +
                ",amount = 14,70$ - date = 2023-03-12 - balance = 14,70$\n", account.showHistory());
    }
}
