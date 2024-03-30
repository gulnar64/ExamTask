import java.util.Queue;

public class MyThread1 extends Thread{
    private Queue<Integer> queue;
    public MyThread1(Queue<Integer> queue) {
        this.queue = queue;
    }
    public void run() {
        int i = 0;
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (queue) {
                queue.add(i);
                queue.notify();
            }
            System.out.println(i + " elave olundu");
            i++;
        }
    }
}
