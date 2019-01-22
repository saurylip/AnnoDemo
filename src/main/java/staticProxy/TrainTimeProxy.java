package staticProxy;

public class TrainTimeProxy implements Runnable {

    private Runnable runnable;

    public TrainTimeProxy(Runnable runnable) {
        this.runnable = runnable;
    }

    public void running() {

        long start = System.currentTimeMillis();

        runnable.running();

        long end = System.currentTimeMillis();

        System.out.println("run time = " + (end - start));
    }
}
