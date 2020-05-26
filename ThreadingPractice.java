public class ThreadingPractice {

    public static void main(String[] args) throws InterruptedException {

        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.print("This is the second thread. Current value: " + i + "\n");
                    try {
                        Thread.sleep(400);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        for (int i = 0; i < 10; i++) {
            System.out.print("Current value: " + i + "\n");
            Thread.sleep(500);
        }
    }
}
