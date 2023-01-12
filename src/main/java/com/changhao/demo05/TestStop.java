package com.changhao.demo05;

public class TestStop implements Runnable {

    private boolean flag = true;

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        int i = 0;
        while(flag) {
            System.out.println("Running.... Thread " + i++);
        }
    }

    public void stop() {
        this.flag = false;
    }


    public static void main(String[] args) {
        TestStop testStop = new TestStop();
        new Thread(testStop, "stop").start();


        for (int i = 0; i < 1000; i++) {
            System.out.println("In the main thread" + i);

            if(i == 900) {
                testStop.stop();
                System.out.println("Thread stopped");
            }
        }
    }
}
