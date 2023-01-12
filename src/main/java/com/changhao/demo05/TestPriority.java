package com.changhao.demo05;

public class TestPriority {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());

        Thread t1 = new Thread(new MyPriority());
        Thread t2 = new Thread(new MyPriority());
        Thread t3 = new Thread(new MyPriority());
        Thread t4 = new Thread(new MyPriority());
        Thread t5 = new Thread(new MyPriority());


        // 先设置优先级，然后再开始跑
        t1.start();

        t2.setPriority(1);
        t2.start();

        t3.setPriority(Thread.MAX_PRIORITY);
        t3.start();

//        t4.setPriority(-1);
//        t4.start();
//
//        t5.setPriority(11);
//        t5.start();
    }
}


class MyPriority implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
    }
}
