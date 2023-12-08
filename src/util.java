import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class util{

    int selectedOpr = 0;
    boolean flag = false;
    InputStreamReader val;
    BufferedReader buff;
    public util() {
        if (val == null)
            val = new InputStreamReader(System.in);
        if (buff == null)
            buff = new BufferedReader(val);
    }

    public void cont(){
        System.out.println("Do you want to continue:\n1. Yes\n2. No");
        try {
            int x = Integer.parseInt(buff.readLine());
            if(x==1)
                flag = true;
            else if(x==2)
                flag = true;
            else
                System.out.println("Invalid Input!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void operations(RBI b, Customer c){
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
                    cont();
                    break;
                case 2:
                    b.withdraw(c);
                    cont();
                    break;
                case 3:
                    b.openFD(c);
                    cont();
                    break;
                case 4:
                    b.applyLoan(c);
                    cont();
                    break;
                case 5:
                    b.applyCC(c);
                    cont();
                    break;
                default:
                    return ;
            }
        }while (flag);
    }

}