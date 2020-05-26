import java.util.concurrent.BlockingQueue;

public class BankAccount {

    private String owner;
    private Float balance;

    private final BlockingQueue<AccountRequest> inputQueue;
    private final BlockingQueue<AccountResponse> outputQueue;

    //private final BlockingQueue<> administratorQueue;

    /**
     * Constructor for bank account object
     * @param inputQueue        BlockingQueue: queue from which input requests are made
     * @param outputQueue
     */
    public BankAccount(BlockingQueue<AccountRequest> inputQueue, BlockingQueue<AccountResponse> outputQueue) {
        this.inputQueue = inputQueue;
        this.outputQueue = outputQueue;
        this.balance = new Float(0);
    }


    /**
     * Deposit given amount into the bank account
     * @param depositAmount     Float: amount to be deposited
     */
    public void deposit(Float depositAmount) {
        if (depositAmount <= 0) {
            throw new IllegalArgumentException();
        }
        this.balance += depositAmount;
    }




    /**
     * Withdraw given amount from the bank account
     * @param withdrawalAmount      Float: amount to be withdrawn
     */
    public void withdraw(Float withdrawalAmount) {
        if (withdrawalAmount <= this.balance && withdrawalAmount > 0) {
            this.balance -= withdrawalAmount;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    public Float getBalance() {
        return new Float(this.balance);
    }

    public String getOwner() {
        return new String(this.owner);
    }
}
