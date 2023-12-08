public interface RBI{
    void deposit(Customer c);
    void withdraw(Customer c);
    void openFD(Customer c);
    void applyLoan(Customer c);
    void applyCC(Customer c);
    void validateAadhar();
}