import java.util.ArrayList;

public class Increment extends Thread {

    Integer id, counter = 0;
    boolean running;

    public Increment(int id) {
        this.id = id;
        this.running = true;
    }

    public static void main(String[] args) {

        ArrayList<Increment> threadArrayList = new ArrayList<>();

        int threadAnzahl = 4;
        for (int i = 0; i < threadAnzahl; i++) {
            Increment test = new Increment(i);
            test.start();
            threadArrayList.add(test);
        }

    }

    public void run() {
        while (running) {
            System.out.println("Thread" + id + ":" + counter);
            counter++;
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pauseThread() {
        running = false;
    }

    public void resumeThread() {
        running = true;
    }

}
