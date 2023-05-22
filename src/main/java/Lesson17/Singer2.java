package Lesson17;

import static Lesson17.Vedushii.LOGGER;

public class Singer2 extends Thread{
    @Override
    public void run() {
        while(true){
            synchronized (Monitors.MICROFON){
                try {
                    Monitors.MICROFON.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            for (int i = 0;i<3;i++){

                try {
                    LOGGER.debug("Poet Leps");
                    System.out.println("----------NA-Na-Na");
                    Thread.sleep(250);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            synchronized (Monitors.MICROFON){
                Monitors.MICROFON.notify();
            }
        }
    }
}
