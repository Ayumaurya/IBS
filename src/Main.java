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

    int selectedBank, selectedOpr;
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

        RBI objBank = null;  // Accessing RBI class
        switch (obj.selectedBank) {
            case 1:
                objBank = new ICICI();
                break;
            case 2:
                objBank = new HDFC();
                break;
            case 3:
                objBank = new SBI();
                break;
            case 4:
                objBank = new AXIS();
                break;
            default:
                System.out.println("Invalid Input!");
        }
        while (true) {
            System.out.print("\n1. Deposit\n2. Withdraw\n3. Open FD\n4. Apply Loan\n5. Apply CC\n6. Exit.\n");
            try {
                obj.selectedOpr = Integer.parseInt(obj.buff.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.print("you selected option " + obj.selectedOpr + "\n");
            switch (obj.selectedOpr) {
                case 1:
                    objBank.deposit();
                    break;
                case 2:
                    objBank.withdraw();
                    break;
                case 3:
                    objBank.openFD();
                    break;
                case 4:
                    objBank.applyLoan();
                    break;
                case 5:
                    objBank.applyCC();
                    break;
                default:
                    return ;
            }
        }
    }
}