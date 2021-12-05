package ibf2021.d2;

import java.io.Console;
import java.util.Scanner;

public class FixedDepositAccount extends bankAccount {

    private float interest=(float) 0.03;
    private int duration=6;
    private int durationChange=0;
    private int interestChange = 0;
    private final float accountBalance;


    public FixedDepositAccount(String name, final float balance){
        super(name,balance);
        this.accountBalance=balance;
        
    }
    public FixedDepositAccount(String name, final float balance,Float interest){
        super(name,balance);
        this.interest=interest;
        this.accountBalance=balance;
    }
    public FixedDepositAccount(String name, final float balance,Float interest, Integer duration){
        super(name,balance);
        this.interest=interest;
        this.duration=duration;
        this.accountBalance=balance;
    }

    public static void main(String[] args) {
        FixedDepositAccount myFD =new FixedDepositAccount("Firdaus", 200);

        System.out.println(myFD.getBalance());
        
        myFD.deposit(400);
        myFD.withdraw(100);
        System.out.println(myFD.getBalance());
        myFD.setInterest(3);
        myFD.setDuration(6);
        System.out.println(myFD.getBalance());
        myFD.setInterest(4);
        myFD.setDuration(12);
        System.out.println(myFD.getBalance());
        myFD.setInterest(5);
        myFD.setDuration(18);
        System.out.println(myFD.getBalance());
    
    }

    @Override
    public void deposit(float value){
        System.out.println("No operation");
    }
    @Override
    public void withdraw(float value){
        System.out.println("No operation");
    }
    @Override
    public float getBalance(){
        return this.accountBalance*(1+getInterest());
    }

    public float getInterest() {
        return this.interest;
    }
    public void setInterest(float interest) throws IllegalArgumentException {
        interest=interest/100;
        if (getInterestChange()>=1){
            throw new IllegalArgumentException("Maximum number of changes reached.");
        }
        else if(getInterest()==interest){
            System.out.print("Current interest rate is set to this value plase enter a different value: ");
            Scanner myScan= new Scanner(System.in);
            float newInterest=myScan.nextFloat();
            myScan.close();
            setInterest(newInterest);
        }
        else{
            this.interest = interest;
            setInterestChange(1);        }
    }
    public int getDuration() {
        return this.duration;
    }
    public void setDuration(int duration) throws IllegalArgumentException {
        if (getDurationChange()>=1){
            throw new IllegalArgumentException("Maximum number of changes reached.");
        }
        else if(getDuration()==duration){
            System.out.print("Current duration is set to this value plase enter a different value: ");
            Scanner myScan2= new Scanner(System.in);
            int newDuration=myScan2.nextInt();
            myScan2.close();
            setDuration(newDuration);
        }
        else{
            this.duration = duration;
            setDurationChange(1);
        }
    }
    private int getDurationChange() {
        return this.durationChange;
    }
    private void setDurationChange(int durationChange) {
        this.durationChange = durationChange;
    }
    private int getInterestChange() {
        return this.interestChange;
    }
    private void setInterestChange(int interestChange) {
        this.interestChange = interestChange;
    }

    
}

