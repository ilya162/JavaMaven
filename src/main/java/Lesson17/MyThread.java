package Lesson17;

public class MyThread extends Thread {
    @Override
    public void run() {
        while (true){
            Thread.currentThread().setName("My thread");
            for (int i = 100; i < 110; i++) {
                System.out.println(i+" "+ Thread.currentThread().getName());
                try {
                    Thread.sleep(200);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
        }

