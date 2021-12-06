package ibf2021.d2;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.Assert.*;


public class TestBankAccount {

    BankAccount testBankWithName = new BankAccount("name only");
    BankAccount testBankWithNameAndBalance= new BankAccount(" name and balance");

    @Test
    public void testgetBalance_nameOnly(){
        float expectedBalance=0;
        float actualBalance=testBankWithName.getBalance();
        Assert.assertEquals(actual, expected);

        assertEquals.
         (expectedBalance,actualBalance);
    }

    @Test
    public void testgetBalance_nameAndBalance(){
        float expectedBalance=200;
        float actualBalance
    }


    @Test
    public void testDeposit(){
        float expectedBalance= 200;
        float actualBalance = 
    }
    
}
