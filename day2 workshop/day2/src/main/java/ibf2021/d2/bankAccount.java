package ibf2021.d2;

import java.util.ArrayList;
import java.util.List;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime; 

public class bankAccount {

    private final String accountName;
    private float accountBalance;
    private final String accountNum=getAlphaNumericString(10);
    private List<String> transactHistory=new ArrayList<>();
    private boolean accountClosedStatus=false;
    private String accountOpeningDate;
    private  String accountClosingDate;


    private bankAccount(final String name){
        this.accountName=name;
        this.accountBalance=0;
        this.accountOpeningDate=getDateTime();
    }
    private bankAccount(final String name, float balance){
        this.accountName=name;
        this.accountBalance=balance;
        this.accountOpeningDate=getDateTime();
    }


    public static void main( String[] args ){
        bankAccount myBank=new bankAccount("Firdaus");
        bankAccount myBank2=new bankAccount("Firdy");


        myBank.deposit(100);
        myBank.deposit(200);  
        myBank.viewTransactions();

    }


    public void deposit(float value) throws IllegalArgumentException{
        if ((value<0)){
            throw new IllegalArgumentException("Value cannot be less than 0.");
        }
        else if(getClosedStatus()){
            throw new IllegalArgumentException("Account closed");
        }
        else{
        String printout= setBalance(value, "deposit");
        setTransactHistory(printout);
        }
    }
    public void withdraw(float value){
        if ((value<0)){
            throw new IllegalArgumentException("Value cannot be less than 0.");
        }
        else if ((value>getBalance())){
            throw new IllegalArgumentException("Value more than account balance.");
        }
        else if(getClosedStatus()){
            throw new IllegalArgumentException("Account closed");
        }
        else{
            setTransactHistory(setBalance(value, "withdraw"));
            }

    }
    public void closeAccount(){
        boolean closed=getClosedStatus();
        String accnum= getAccountNum();
        String accname=getName();

        if(closed==true){
            System.out.println("You account is already closed!");
        }
        else{
            setClosedStatus();
            System.out.println(setClosingDate(accnum,accname));
        }

    }
    public void viewTransactions(){
        List<String> transactions= getTransactHistory();

        for(int i=0; i<transactions.size();i++){
            System.err.println(transactions.get(i));
        }
}


    private static String getAlphaNumericString(int n){
        String createdNum="";
        String AlphaNumericString = "0123456789";

        for(int i=0;i<n;i++){
            int randomIndex=(int) (AlphaNumericString.length()*Math.random());
            createdNum=createdNum+AlphaNumericString.charAt(randomIndex);
        }
        return createdNum;

    }
    private static String getDateTime(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
        LocalDateTime now = LocalDateTime.now();  
        String currentDateTime=dtf.format(now);
        return currentDateTime;
    }


    private float getBalance(){
        return this.accountBalance;
    }
    private String getName(){
        return this.accountName;

    }
    private String getAccountNum(){
        return this.accountNum;

    }
    private List<String> getTransactHistory(){
        return this.transactHistory;

    }
    private String getCreationDate(){
        return this.accountOpeningDate;

    }
    private String getClosingDate(){
        return accountClosingDate;

    }
    private boolean getClosedStatus(){

        return this.accountClosedStatus;

    }
    private String setBalance(float value, String transactType){

        if(transactType.equals("deposit")){
        this.accountBalance+=value;
        String timestamp = getDateTime();
        timestamp=String.format("Deposit %f at<%s %s>", value,timestamp.substring(0,10), timestamp.substring(10));
        return timestamp;
        }
        else{
            this.accountBalance-=value;
            String timestamp = getDateTime();
            timestamp=String.format("Withdraw %f at<%s %s>", value,timestamp.substring(0,10), timestamp.substring(10));
            return timestamp;

        }

    }
    private void setTransactHistory(String input){
        this.transactHistory.add(input);
    }
    private void setClosedStatus(){
        this.accountClosedStatus=true;
        
    }
    private String setClosingDate(String num, String name ){
        String timestamp = getDateTime();
        timestamp=String.format("Account Number %s for %s closed at<%s %s>", num, name,timestamp.substring(0,10), timestamp.substring(10));
        return timestamp;
    }


}


