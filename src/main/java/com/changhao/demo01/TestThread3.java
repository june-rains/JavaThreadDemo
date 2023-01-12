package com.changhao.demo01;

// 实现线程方法2：实现Runnable接口类，然后重写run方法，然后new一个Thread类对象，用代理的方式传入我们这个实现类，最后调用start方法即可
public class TestThread3 implements Runnable{
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("我在写代码 " + i);
        }
    }

    public static void main(String[] args) {
        // 创建一个实现runnable接口的实体类对象
        TestThread3 testThread3 = new TestThread3();

        // 创建一个Thread类，并将我们上面刚创建的对象丢入
        Thread t = new Thread(testThread3);

        t.start();


        for (int i = 0; i < 200; i++) {
            System.out.println("我在学习多线程 " + i);
        }
    }
}
