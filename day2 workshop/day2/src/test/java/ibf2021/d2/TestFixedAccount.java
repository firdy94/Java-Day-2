package ibf2021.d2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.annotation.Repeatable;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestFixedAccount {


    FixedDepositAccount testBank1 = new FixedDepositAccount("name1", 200);
    FixedDepositAccount testBank2= new FixedDepositAccount("name2", 200,3);
    FixedDepositAccount testBank3= new FixedDepositAccount("name3", 200,3,6);

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @BeforeClass
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @AfterMethod
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }



    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInterestChange_cons1(){
        testBank1.setInterest(4);
        testBank1.setInterest(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInterestChange_cons2(){
        testBank2.setInterest(4);
        testBank2.setInterest(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testInterestChange_cons3(){
        testBank3.setInterest(4);
        testBank3.setInterest(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDurationChange_cons1(){
        testBank1.setDuration(4);
        testBank1.setDuration(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDurationChange_cons2(){
        testBank2.setDuration(4);
        testBank2.setDuration(5);
    }
    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDurationChange_cons3(){
        testBank3.setDuration(4);
        testBank3.setDuration(5);
    }
    @Test
    public void testDeposit_cons1(){
        testBank1.deposit(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testDeposit_cons2(){
        testBank2.deposit(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testDeposit_cons3(){
        testBank3.deposit(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testWithdraw_cons1(){
        testBank1.withdraw(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testWithdraw_cons2(){
        testBank2.withdraw(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testWithdraw_cons3(){
        testBank3.withdraw(100);
        Assert.assertEquals(outContent.toString().trim(), "No operation");
    }
}
