package ibf2021.d2;

import org.testng.Assert;
import org.testng.annotations.*;


public class TestBankAccount {

    
    BankAccount testBank1 = new BankAccount("name only");

    BankAccount testBank2= new BankAccount(" name and balance",0);

    @BeforeTest
    public void createObjects(){
        testBank1.deposit(100);
        testBank2.deposit(100);
    }
    @Test
    public void testgetBalance_nameOnly(){
        float expectedBalance=200;
        float actualBalance=testBank1.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testgetBalance_nameAndBalance(){
        float expectedBalance=200;
        float actualBalance=testBank2.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testDeposit_nameOnly_NormalCondition(){
        float expectedBalance= 200;
        testBank1.deposit(100);
        float actualBalance = testBank1.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testDeposit_nameandBalance_NormalCondition(){
        float expectedBalance= 200;
        testBank2.deposit(100);
        float actualBalance = testBank2.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testWithdraw_nameOnly_NormalCondition(){
        float expectedBalance= 100;
        testBank1.withdraw(100);
        float actualBalance = testBank1.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
        testBank1.deposit(100);
    }
   @Test
    public void testWithdraw_nameAndBalance_NormalCondition(){
        float expectedBalance= 100;
        testBank2.withdraw(100);
        float actualBalance = testBank2.getBalance();
        Assert.assertEquals(actualBalance, expectedBalance);
        testBank2.deposit(100);
    }
    @Test
    public void testTransactionHistory_nameOnly(){
        String timestamp= testBank1.getDateTime();
        String expectedString=String.format("Deposit %.6f at<%s %s>",100.00, timestamp.substring(0,10), timestamp.substring(10) );
        String actualString = testBank1.getTransactHistory().get(0);
        Assert.assertEquals(actualString, expectedString);
    }
    @Test
    public void testTransactionHistory_nameAndBalance(){
        String timestamp= testBank2.getDateTime();
        String expectedString=String.format("Deposit %.6f at<%s %s>",100.00, timestamp.substring(0,10), timestamp.substring(10) );
        String actualString = testBank2.getTransactHistory().get(0);
        Assert.assertEquals(actualString, expectedString);
    }






    
}
