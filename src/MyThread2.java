import java.util.Queue;

public class MyThread2 extends Thread {
    private Queue<Integer> queue;

    public MyThread2(Queue<Integer> queue) {
        this.queue = queue;
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (queue) {
                if (queue.size() > 0)
                    System.out.println(queue.remove() + " silindi");
                else {
                    try {
                        System.out.println("wait statusundadir");
                        queue.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }
}