package ibf2021.d2;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.lang.annotation.Repeatable;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestFixedAccount {



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
    public void testInterestChange(){
        assertThrows(IllegalArgumentException.class, () -> {
            FixedDepositAccount testBank1 = new FixedDepositAccount("name1", 200);
            testBank1.setInterest(4);
            testBank1.setInterest(5);
        });
        
    }
    @Test
    public void testDurationChange_(){
        assertThrows(IllegalArgumentException.class, () -> {
            FixedDepositAccount testBank1 = new FixedDepositAccount("name1", 200);
            testBank1.setDuration(4);
            testBank1.setDuration(5);
        });
    }
    @Test
    public void testDeposit(){
        FixedDepositAccount testBank1 = new FixedDepositAccount("name1", 200);
        testBank1.deposit(100);
        assertEquals(outContent.toString().trim(), "No operation");
    }
    @Test
    public void testWithdraw(){
        FixedDepositAccount testBank1 = new FixedDepositAccount("name1", 200);
        testBank1.withdraw(100);
        assertEquals(outContent.toString().trim(), "No operation");
    }
}
