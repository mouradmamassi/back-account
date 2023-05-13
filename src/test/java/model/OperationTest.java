package model;

import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;

public class OperationTest {


    @Test
    public void getBalanceTest(){
        //arrange && act
        Operation operation = new Operation(12.3, LocalDate.of(2023, 05, 12));
        //assert
        Assert.assertEquals("amount = 12,30$ - date = 2023-05-12", operation.toString());
    }


}
