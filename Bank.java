import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Bank {

    public static void main(String[] args) {
        BlockingQueue<AccountRequest> accountRequestQueue = new LinkedBlockingQueue<AccountRequest>();
        BlockingQueue<AccountResponse> accountResponseQueue = new LinkedBlockingQueue<AccountResponse>();

        ATM atm1 = new ATM(accountRequestQueue, accountResponseQueue);
        ATM atm2 = new ATM(accountRequestQueue, accountResponseQueue);


        BankAccount account = new BankAccount(accountRequestQueue, accountResponseQueue);

        new Thread(atm1).start();
        new Thread(atm2).start();

        while (true) {
            AccountRequest request;

            try {
                request = accountRequestQueue.take();
                if (request.getType() == 'd') {
                    System.out.print("Previous Balance: $" + account.getBalance() + "\n");
                    account.deposit(request.getAmount());
                    System.out.print("Current Balance: $" + account.getBalance() + "\n");
                }
                else if (request.getType() == 'w') {
                    System.out.print("Previous Balance: $" + account.getBalance() + "\n");
                    account.withdraw(request.getAmount());
                    System.out.print("Current Balance: $" + account.getBalance() + "\n");
                }
                else {
                    System.out.print("incorrect account request");
                }
            }
            catch (InterruptedException e) {
                System.out.print("thread interrupted");
            }

        }


    }

}
