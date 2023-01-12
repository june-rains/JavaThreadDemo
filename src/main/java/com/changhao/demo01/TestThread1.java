package com.changhao.demo01;

// 实现线程方法1： 继承Thread类，并且重写run()方法，然后调用start方法开启线程

// 总结：线程开启不一定立即执行，由CPU调度来分配执行
public class TestThread1 extends Thread {
    @Override
    public void run() {
        // run 线程
        for (int i = 0; i < 20; i++) {
            System.out.println("I am writing code" + i);
        }
    }

    public static void main(String[] args) {
        // main 线程

        // 创建线程对象
        TestThread1 testThread1 = new TestThread1();

        // 调用start method，这时候会同时执行run线程和main线程，打印结果会交叉出现
        testThread1.start();

        for (int i = 0; i < 2000; i++) {
            System.out.println("I am learning Java Thread" + i);
        }
    }
}
