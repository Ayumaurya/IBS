import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class util{

    int selectedOpr = 0;
    boolean flag = false;
    InputStreamReader val;
    BufferedReader buff;

    int selectedBank;
    ArrayList<String> bankOptions = new ArrayList<String>(Arrays.asList("ICICI", "HDFC", "SBI", "AXIS", "Show Customer Counts"));

//    HDFC mHDFC=null;
//    SBI mSBI=null;
//    ICICI mICICI=null;
//    AXIS mAXIS=null;
//    Main m = new Main();
    public util() {
        if (val == null)
            val = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(val);
    }

    public void cont(HDFC mHDFC, SBI mSBI, ICICI mICICI, AXIS mAXIS){
        System.out.println("Do you want to continue:\n1. Yes\n2. No");
        try {
            int x = Integer.parseInt(buff.readLine());
            if(x==1)
                flag = true;
            else if(x==2)
                bankPage(mHDFC, mSBI, mICICI, mAXIS);  // accessing bankoptions
            else
                System.out.println("Invalid Input!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void operations(RBI b, Customer c, HDFC mHDFC, SBI mSBI, ICICI mICICI, AXIS mAXIS){
        do{
            System.out.print("\n1. Deposit\n2. Withdraw\n3. Open FD\n4. Apply Loan\n5. Apply CC\n6. Exit.\n");
            try {
                selectedOpr = Integer.parseInt(buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("you selected option " + selectedOpr + "\n");
            switch (selectedOpr) {
                case 1:
                    b.deposit(c);
                    cont( mHDFC,  mSBI,  mICICI,  mAXIS);
                    break;
                case 2:
                    b.withdraw(c);
                    cont( mHDFC,  mSBI,  mICICI,  mAXIS);
                    break;
                case 3:
                    b.openFD(c);
                    cont( mHDFC,  mSBI,  mICICI,  mAXIS);
                    break;
                case 4:
                    b.applyLoan(c);
                    cont( mHDFC,  mSBI,  mICICI,  mAXIS);
                    break;
                case 5:
                    b.applyCC(c);
                    cont( mHDFC,  mSBI,  mICICI,  mAXIS);
                    break;
                default:
                    bankPage(mHDFC, mSBI, mICICI, mAXIS);
            }
        }while (flag);
    }


    public void bankPage(HDFC mHDFC, SBI mSBI, ICICI mICICI, AXIS mAXIS){
        System.out.print("Welcome to IBS!\n");
        for (int i = 0; i < bankOptions.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". " + bankOptions.get(i));
        }

        try {
            selectedBank = Integer.parseInt(buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("you selected option " + selectedBank+"\n");

//        RBI objBank = null;  // Accessing RBI class
        switch (selectedBank) {
            case 1:
                mICICI.validateAadhar(mHDFC, mSBI, mICICI, mAXIS);
                break;
            case 2:
                mHDFC.validateAadhar(mHDFC, mSBI, mICICI, mAXIS);
                break;
            case 3:
                mSBI.validateAadhar(mHDFC, mSBI, mICICI, mAXIS);
                break;
            case 4:
                mAXIS.validateAadhar(mHDFC, mSBI, mICICI, mAXIS);
                break;
            case 5:
                System.out.println("ICICI: "+mICICI.bankCustomer.size()+".\n"+"SBI: "+mSBI.bankCustomer.size()+".\n"+"AXIS: "+mAXIS.bankCustomer.size()+".\n"+"HDFC: "+mHDFC.bankCustomer.size()+".\n");
                break;
            default:
                System.out.println("Invalid Input!");
        }
    }

}