package model;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.time.LocalDate;
import java.util.List;

public class OperationTest {


    @Test
    public void getBalanceTest(){
        //arrange && act
        Operation operation = new Operation(12.3, LocalDate.of(2023, 05, 12));
        //assert
        Assert.assertEquals("Account balance was not correct.", 12.3, operation.getBalance(), 0);
        Assert.assertEquals("amount = 12,30$ - date = 2023-05-12 - balance = 12,30$\n", operation.toString());
    }


}
