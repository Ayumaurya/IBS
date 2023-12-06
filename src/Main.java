import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    int selectedBank, selectedOpr;
    InputStreamReader val;
    BufferedReader buff;

    public Main() {
        if(val == null)
            val = new InputStreamReader(System.in);
        if(buff == null)
            buff = new BufferedReader(val);
    }

    public static void main(String[] args) {
            System.out.print("Welcome to IBS!\nPlease select your Bank\n1. ICICI\n2. SBI\n3. HDFC\n4. PNB\n5. Exit.\n");

            Main obj = new Main();
            try{
                obj.selectedBank = Integer.parseInt(obj.buff.readLine());
            }catch(IOException e){
                e.printStackTrace();
            }
            System.out.print("you selected option "+ obj.selectedBank);
//            boolean x = true;

            RBI mRBI=new RBI();  // Accessing RBI class
            while(true) {
                System.out.print("\n1. Deposit\n2. Withdraw\n3. Open FD\n4. Apply Loan\n5. Apply CC\n6. Exit.\n");
                try{
                    obj.selectedOpr = Integer.parseInt(obj.buff.readLine());
                }catch(IOException e){
                    e.printStackTrace();
                }
                System.out.print("you selected option "+ obj.selectedOpr+"\n");
                if (obj.selectedOpr == 1) {
                    mRBI.depositMoney();
                }
                else if (obj.selectedOpr == 2) {
                    System.out.print("Enter the amount to withdraw: ");
                    mRBI.withdrawMoney();
                }
                else if(obj.selectedOpr == 3){
                    float amount=0;
                    int years=0;
                    System.out.print("Enter FD amount: ");
                    try{
                        amount = Integer.parseInt(obj.buff.readLine());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    System.out.print("\nEnter FD Years: ");
                    try{
                        years = Integer.parseInt(obj.buff.readLine());
                    }catch(IOException e){
                        e.printStackTrace();
                    }

                    mRBI.openFD(amount, years);
                }
                else if(obj.selectedOpr == 4){
                    String loanType = "";
                    float amount=0,ROI = 12;
                    int years=0;
                    System.out.print("Enter Loan amount: ");
                    try{
                        amount = Integer.parseInt(obj.buff.readLine());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    System.out.print("\nEnter years: ");
                    try{
                        years = Integer.parseInt(obj.buff.readLine());
                    }catch(IOException e){
                        e.printStackTrace();
                    }
                    mRBI.applyLoan(loanType, amount, ROI, years);
                }
                else break;
            }
        }
}