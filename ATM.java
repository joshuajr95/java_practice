import javax.swing.*;
import java.util.concurrent.BlockingQueue;

public class ATM implements Runnable {

    private final BlockingQueue<AccountResponse> responseQueue;
    private final BlockingQueue<AccountRequest> requestQueue;


    public ATM(BlockingQueue<AccountRequest> requestQueue, BlockingQueue<AccountResponse> responseQueue) {
        this.requestQueue = requestQueue;
        this.responseQueue = responseQueue;
    }


    @Override
    public void run() {
        try {
            requestQueue.put(new AccountRequest('d', new Float(23.75)));
        }
        catch (InterruptedException e) {
            System.out.print("Transaction was interrupted");
        }

    }

}
