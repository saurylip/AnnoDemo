package staticProxy;

public class TrainLogProxy implements Runnable {

    private Runnable runnable;

    public TrainLogProxy(Runnable runnable) {
        this.runnable = runnable;
    }

    public void running() {
        System.out.println("Train running start...");
        runnable.running();
        System.out.println("Train running end...");
    }
}
