import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AXIS implements RBI {
//    Customer customerobj = new Customer();

    HashMap<String, Customer> bankCustomer = new HashMap<>();

//    HDFC b = new HDFC();  THROWS ERROR

    util u = new util();
    float balance = 0.0f;

    int withdrawCount = 0;

    String bankID = "_AXIS";

    InputStreamReader val;
    BufferedReader buff;
    public AXIS() {
        if(val == null)
            val = new InputStreamReader(System.in);
        if(buff == null)
            buff = new BufferedReader(val);
    }



    @Override
    public void validateAadhar(HDFC mHDFC, SBI mSBI, ICICI mICICI, AXIS b){
        String aadhar = "";
        System.out.print("Welcome to AXIS.\n Please enter last 4-digit of your aadhar number:\n");
        try {
            aadhar = buff.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }


        if(bankCustomer.containsKey(aadhar+bankID)){
            Customer c = bankCustomer.get(aadhar+bankID);
            u.operations(b,c, mHDFC, mSBI, mICICI, b);
        }
        else{
            Customer c = new Customer(aadhar);
            bankCustomer.put(aadhar+bankID, c);
            u.operations(b,c, mHDFC, mSBI, mICICI, b);
        }


    }
    @Override
    public void deposit(Customer c) {
        System.out.println("Please enter amount: ");
        float amt=0;
        try{
            amt = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        c.balance += amt;
        System.out.print("Amount deposited successfully!\n Your current balance is: " + c.balance +"\n");
    }

    @Override
    public void withdraw(Customer c) {
        System.out.println("Please enter amount: ");
        float amt=0;
        try{
            amt = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        if(amt > 0){
            if(withdrawCount<3){
                if(c.balance-amt>1000){
                    c.balance -= amt;
                    System.out.print("Operation successful!\n Your current balance is: " + c.balance +"\n");
                }
                else System.out.print("Operation unsuccessful!\n Insufficient Balance.\n");
            }
            else{
                if(c.balance-(amt+amt*.01)>1000){
                    c.balance -= (amt*.01);
                    System.out.print("Withdraw successful!\n Your current balance is: " + c.balance +"\n");
                }
                else System.out.print("Operation unsuccessful!\n Insufficient Balance.\n");
            }
        }
        else{
            System.out.print("Invalid Input!\n");
        }
    }

    @Override
    public void openFD(Customer c) {
        float amt=0, ROI=6;
        int years=0;
        System.out.println("Please enter amount: ");
        try{
            amt = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        System.out.println("Please enter years: ");
        try{
            years = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        for(int i=1; i<years; i++){
            amt += amt * ROI/100;
            System.out.print("Your Interest for year "+i+" will be: "+ amt+".\n");
        }
        System.out.print("Your Final Amount after "+ years + " years will be: "+ val+".\n");
    }

    @Override
    public void applyLoan(Customer c) {
        HashMap<String, Float> loanTypes = new HashMap<>();
        loanTypes.put("HOME", 6f);
        loanTypes.put("EDUCATION", 3f);
        loanTypes.put("PERSONAL", 8f);
        loanTypes.put("CAR", 9f);
        ArrayList<String> loanTypeArray = new ArrayList<>();
        System.out.println("Please select loan type: ");
        loanTypes.forEach((key, value)->{
            loanTypeArray.add(key);
        });
        for(Integer i=1; i<=loanTypeArray.size(); i++){
            System.out.print(Integer.toString(i)+". "+loanTypeArray.get(i-1));
        }
        float amt=0, ROI=12;
        int years=0, loanType=0;
        try{
            loanType = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        if(loanType>0 && loanType<loanTypes.size()) {
            System.out.println("You selected " + loanTypeArray.get(loanType - 1) + " Loan.\nPlease enter amount: ");
            try {
                amt = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            if (amt < c.balance * 2) {
                System.out.print("Sorry! You are not eligible for loan.\n");
            } else {
                System.out.println("Please enter years: ");
                try {
                    years = Integer.parseInt(buff.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                float interest = amt * (float) Math.pow(1 + loanTypes.get(loanTypeArray.get(loanType - 1)) / 100, years);
                System.out.print("Your interest on loan of amount " + amt + "for " + years + " years will be: " + interest + ".\n");
            }
        }
        else System.out.println("Invalid Input!");
    }

    @Override
    public void applyCC(Customer c) {
        float amt=0, ROI=12;
        int years=0;
        System.out.println("Please enter amount: ");
        try{
            amt = Integer.parseInt(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
        if(amt < c.balance*2) {
            System.out.print("Sorry! You are not eligible for Credit Card.\n");
        }
        else System.out.print("congratulations! You are eligible for Credit Card.\n");
    }
}
