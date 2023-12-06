import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class RBI {
    float balance=1000;
    float ROI = 6;
    InputStreamReader val;
    BufferedReader buff;
    public RBI() {
        if(val == null)
            val = new InputStreamReader(System.in);
        if(buff == null)
            buff = new BufferedReader(val);
    }
    public void depositMoney() {
        try{
            System.out.print("\nEnter Deposit Amount: ");
             balance += Float.parseFloat(buff.readLine());
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void withdrawMoney(){
        int x=0;
        float mWithdraw=0;
        try{
            System.out.print("\nEnter Withdraw Amount: ");
            mWithdraw = Float.parseFloat(buff.readLine());
        }catch(IOException e) {
            e.printStackTrace();
        }
        if(mWithdraw>0) {
            if (balance - mWithdraw > 1000) {
                x+=1;
                if(x>2){
                    System.out.print("\nWithdraw Successful!\n Your Current Balance is: " + balance + "\nAdditional charges of 0.01% applied.");
                    balance = balance - (mWithdraw + mWithdraw*.01f);
                }
                else balance -= mWithdraw;
                System.out.print("\nWithdraw Successful!\n Your Current Balance is: " + balance + "\n");
            }
            else {
                float amount = balance - 1001;
                System.out.print("\nWithdraw Unsuccessful!\n Your can withdraw upto: " + amount + "\n");
            }
        }
        else{
            System.out.print("\nPlease enter valid amount.\n");
        }

    }
    public void openFD(float amount, int years) {
        float val = amount;
        for(int i=1; i<years; i++){
            val += amount * ROI/100;
            System.out.print("Your Interest for year "+i+" is: "+ val+"\n");
        }
        System.out.print("Your Final Amount after "+ years + " years will be: "+ val);
    }
    public void applyLoan(String loanType, float amount, float ROI, int years) {
        float interest = amount*(float)Math.pow(1+ROI/100, years);
        System.out.print("Your interest on loan of amount "+ amount + "for "+ years+" years will be: "+ interest);
    }
    public void applyCreditCard() {}
    public float getBalance() {
        return balance;
    }
}