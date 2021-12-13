package ibf2021.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class TestBankAccount {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

@BeforeEach
public void setUpStreams() {
    System.setOut(new PrintStream(outContent));
    System.setErr(new PrintStream(errContent));
}

@AfterEach
public void restoreStreams() {
    System.setOut(originalOut);
    System.setErr(originalErr);
}
    @Test
    public void testgetBalance(){
        BankAccount testBank1 = new BankAccount("name");
        testBank1.deposit(200);
        float expectedBalance=200;
        float actualBalance=testBank1.getBalance();
        assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testDeposit_NormalCondition(){
        BankAccount testBank1 = new BankAccount("name");
        float expectedBalance= 100;
        testBank1.deposit(100);
        float actualBalance = testBank1.getBalance();
        assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testDeposit_NegativeCondition(){
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount testBank1 = new BankAccount("name");
            testBank1.deposit(-100);
        });
    }
    @Test
    public void testWithdraw_NormalCondition(){
        BankAccount testBank1 = new BankAccount("name");
        testBank1.deposit(100);
        float expectedBalance= 0;
        testBank1.withdraw(100);
        float actualBalance = testBank1.getBalance();
        assertEquals(actualBalance, expectedBalance);
    }
    @Test
    public void testWithdraw_OverDraftCondition(){
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount testBank1 = new BankAccount("name");
            testBank1.withdraw(100);
        });
    }
    @Test
    public void testWithdraw_NegativeCondition(){
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount testBank1 = new BankAccount("name");
            testBank1.withdraw(-100);
        });

    }
    @Test
    public void testTransactionHistory(){
        BankAccount testBank1 = new BankAccount("name");
        testBank1.deposit(100);
        String timestamp= BankAccount.getDateTime();
        String expectedString=String.format("Deposit %.6f at<%s %s>",100.00, timestamp.substring(0,10), timestamp.substring(10) );
        String actualString = testBank1.getTransactHistory().get(0);
        assertEquals(actualString, expectedString);
    }
    @Test
    public void testcloseAccount_NormalCondition(){
        BankAccount testBank1 = new BankAccount("name");
        testBank1.closeAccount();
        
        assertEquals(true, testBank1.getClosedStatus());
    }
    public void testcloseAccount_TwiceCondition(){
        BankAccount testBank1 = new BankAccount("name");
        testBank1.closeAccount();
        testBank1.closeAccount();
        assertEquals("You account is already closed!", outContent.toString().trim());
    }
    public void testcloseAccount_DepositCondition(){
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount testBank1 = new BankAccount("name");
            testBank1.closeAccount();
            testBank1.deposit(100); 
        });
            }
    public void testcloseAccount_WithdrawCondition(){
        assertThrows(IllegalArgumentException.class, () -> {
            BankAccount testBank1 = new BankAccount("name");
            testBank1.closeAccount();
            testBank1.withdraw(100);
        });
    }








    
}
