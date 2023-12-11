import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Object;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main implements Runnable {
    Main obj=null;

    ArrayList<String> bankOptions = new ArrayList<String>(Arrays.asList("ICICI", "HDFC", "SBI", "AXIS"));
//    ArrayList<String> operationOptions = new ArrayList<String>(Arrays.asList("Deposit", "Withdraw", "Open FD", "Apply Loan", "Apply CC"));

    int selectedBank;
    InputStreamReader val;
    BufferedReader buff;

    HDFC mHDFC = new HDFC();
    SBI mSBI = new SBI();
    ICICI mICICI = new ICICI();
    AXIS mAXIS = new AXIS();


    public Main() {
        if (val == null)
            val = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(val);
    }


    util u = new util();
    public static void main(String[] args) {
        Main obj1=new Main();
        obj1.obj=obj1.getInstance(obj1);
        Thread t1=new Thread(obj1);
        t1.start();

    }
    public Main getInstance(Main obj){return obj;}


    @Override
    public void run() {
        while(true){
            obj.u.bankPage(obj.mHDFC, obj.mSBI, obj.mICICI, obj.mAXIS);
        }
    }
}