package com.changhao.demo01;

// 出现问题： 当多个线程调用同一个资源，会出现并发问题
public class TestThread4 implements Runnable {
    private int ticketNums = 10;

    // 模拟买票
    public void run() {
        while(true) {
            if(ticketNums <= 0) {
                break;
            }
            // 模拟时延
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(Thread.currentThread().getName() + " -->买了第 " + ticketNums-- + "张票");
        }
    }

    public static void main(String[] args) {
        TestThread4 testThread4 = new TestThread4();

        new Thread(testThread4, "小李").start();
        new Thread(testThread4, "小陆").start();
        new Thread(testThread4, "小孙").start();
    }
}
