import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class Squarer {
    private BlockingQueue<Integer> input;
    private BlockingQueue<Integer> output;


    public Squarer(BlockingQueue<Integer> requests, BlockingQueue<Integer> replies) {
        this.input = requests;
        this.output = replies;
    }


    public void start() {
        new Thread(new Runnable() {

            @Override
            public void run() {

                while (! Thread.interrupted()) {
                    try {

                        int x = input.take();
                        int y = x*x;
                        output.put(y);
                    }
                    catch (InterruptedException e) {
                        break;
                    }
                }

            }
        }).start();
    }
}
