package com.changhao.demo05;

public class TestSleep implements Runnable {
    private static int ticketNums = 10;

    @Override
    public void run() {
        while(ticketNums > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName() + "抢到了第" + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestSleep testSleep = new TestSleep();
        new Thread(testSleep, "小李").start();
        new Thread(testSleep, "小孙").start();
        new Thread(testSleep,"小储").start();

    }
}
