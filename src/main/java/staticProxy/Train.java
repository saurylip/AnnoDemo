package staticProxy;

import java.util.Random;

public class Train implements Runnable {

    public void running() {
        System.out.println("Train is running......");

        int ranTime = new Random().nextInt(1000);
        try {
            Thread.sleep(ranTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
