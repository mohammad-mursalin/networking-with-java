class ControlledThread implements Runnable {

    private Thread thread;
    private boolean paused = false;
    private boolean stopped = false;

    public ControlledThread(String name) {
        thread = new Thread(this, name);
        thread.start();
    }

    @Override
    public void run() {
        try {
            int i = 1;
            while (i++ < 20) {
                synchronized (this) {
                    while (paused)
                        wait();

                    if (stopped)
                        break;
                }
                Thread.sleep(200); // just to slow down execution
            }
        } catch (InterruptedException e) {
            System.out.println("Thread interrupted");
        }
    }

    synchronized void pauseThread() {
        paused = true;
    }

    synchronized void resumeThread() {
        paused = false;
        notify();
    }

    synchronized void stopThread() {
        stopped = true;
        paused = false;
        notify();
    }
}

public class ThreadControlDemo {

    public static void main(String[] args) {
        try {
            ControlledThread ct = new ControlledThread("Worker");

            System.out.println("Thread started");
            Thread.sleep(2000);

            ct.pauseThread();
            System.out.println("Thread paused");
            Thread.sleep(2000);

            ct.resumeThread();
            System.out.println("Thread resumed");
            Thread.sleep(2000);

            ct.stopThread();
            System.out.println("Thread stopped");

        } catch (InterruptedException e) {
            System.out.println("Main thread interrupted");
        }
    }
}
