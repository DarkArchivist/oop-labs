package common.bank;

public class BankAccount {

    private final String owner;
    private double amount;
    private double limit;

    private final String bank;
    private final String bankAddress;

    public BankAccount(String owner, double amount, double limit, String bank, String bankAddress) {
        this.owner = owner;
        this.amount = amount;
        this.limit = limit;
        this.bank = bank;
        this.bankAddress = bankAddress;
    }

    public void transfer(BankAccount target, double amount) {
        this.withdraw(amount);
        target.amount += amount;
    }

    public void deposit(double amount) {
        this.amount += amount;
    }

    public void withdraw(double amount) {
        if (this.amount < amount) {
            throw new RuntimeException("Insufficient funds");
        }
        this.amount -= amount;
    }

    public String getOwner() {
        return owner;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public double getLimit() {
        return limit;
    }

    public void setLimit(double limit) {
        this.limit = limit;
    }

    public String getBank() {
        return bank;
    }

    public String getBankAddress() {
        return bankAddress;
    }
}
