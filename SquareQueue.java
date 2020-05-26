import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class SquareQueue {



    public static void main(String[] args) {

        BlockingQueue<Integer> requests = new LinkedBlockingQueue<Integer>();
        BlockingQueue<Integer> replies = new LinkedBlockingQueue<Integer>();
        Squarer squarer = new Squarer(requests, replies);

        squarer.start();

        try {


            requests.put(new Integer(42));
            System.out.print(replies.take());
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
