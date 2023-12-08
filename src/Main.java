import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    ArrayList<String> bankOptions = new ArrayList<String>(Arrays.asList("ICICI", "HDFC", "SBI", "AXIS"));
    ArrayList<String> operationOptions = new ArrayList<String>(Arrays.asList("Deposit", "Withdraw", "Open FD", "Apply Loan", "Apply CC"));

    int selectedBank;
    InputStreamReader val;
    BufferedReader buff;




    public Main() {
        if (val == null)
            val = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(val);
    }



    public static void main(String[] args) {
        Main obj = new Main();
        HDFC mHDFC = new HDFC();
        ICICI mICICI = new ICICI();
        SBI mSBI = new SBI();
        AXIS mAXIS = new AXIS();
        System.out.print("Welcome to IBS!\n");
        for (int i = 0; i < obj.bankOptions.size(); i++) {
            System.out.println(Integer.toString(i + 1) + ". " + obj.bankOptions.get(i));
        }

        try {
            obj.selectedBank = Integer.parseInt(obj.buff.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("you selected option " + obj.selectedBank);

//        RBI objBank = null;  // Accessing RBI class
        switch (obj.selectedBank) {
            case 1:
                mICICI.validateAadhar();
                break;
            case 2:
                mHDFC.validateAadhar();
                break;
            case 3:
                mSBI.validateAadhar();
                break;
            case 4:
                mAXIS.validateAadhar();
                break;
            default:
                System.out.println("Invalid Input!");
        }

    }
}