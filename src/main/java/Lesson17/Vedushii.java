package Lesson17;

import org.apache.log4j.Logger;

public class Vedushii {
    public static final Logger LOGGER= Logger.getLogger(Vedushii.class);
    // volatile -программа будет проверять значение переменной ,если она вдруг менялась.
    public static void main(String[] args) {
        LOGGER.debug("Concert is starting");
        System.out.println("Concert is starting");
        Singer1 singer1 = new Singer1(2);

        singer1.setDaemon(true);
        Singer2 singer2 = new Singer2();
        singer2.setDaemon(true);
        Singer3 singer3 = new Singer3();
        singer1.start();
        singer2.start();
        singer3.start();
        singer1.setName("Kirkorov");
        singer2.setName("Leps");
        singer3.setName("Lolita");

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        LOGGER.debug("THE END");
        System.out.println("THE END");
        }

    }

