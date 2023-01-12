package com.changhao.demo05;

public class TestJoin implements Runnable {

    @Override
    public void run() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i < 1000; i++) {
            System.out.println("线程vip" + i);
        }
    }

    public static void main(String[] args) {
        TestJoin testJoin = new TestJoin();
        Thread t = new Thread(testJoin);
        t.start();

        for (int i = 0; i < 100; i++) {
            if(i == 50) {
                try {
                    t.join();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            System.out.println("main线程" + i);
        }
    }
}
