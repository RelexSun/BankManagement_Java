import java.util.UUID;

public class SaveAccount implements Account{
    private UUID accountNumber;
    private String userName;
    private String dob;
    private String gender;
    private String phoneNumber;
    private double balance = 0;
    private double amount;
    private double rate = 0.05;

    public SaveAccount(UUID accountNumber, String userName, String dob, String gender, String phoneNumber) {
        this.accountNumber = accountNumber;
        this.userName = userName;
        this.dob = dob;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public UUID getAccountNumber() {
        return this.accountNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getUserName() {
        return userName;
    }

    public void deposit(double amount) {
        if (this.balance >= 200) {
            this.balance *= this.rate;
        }
        this.balance += amount;
        System.out.println("Deposit Successfully!");
    }

    public boolean withDraw(double amount) {
            this.balance -= amount;
            return true;
    }
}
