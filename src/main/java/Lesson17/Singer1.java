package Lesson17;

import static Lesson17.Vedushii.LOGGER;

public class Singer1 extends Thread {


    private int count = 5;

    public Singer1() {

    }

    public Singer1(int count) {
        this.count = count;
    }

    @Override
    public void run() {
        int j = 0;
        while (j < count) {
            for (int i = 0; i < 3; i++) {
                LOGGER.debug("Poet Kirkorov");
                System.out.println("La-La-La---------");
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MICROFON) {
                Monitors.MICROFON.notify();
            }
            synchronized (Monitors.MICROFON) {
                try {
                    Monitors.MICROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            j++;
        }
    }
}

