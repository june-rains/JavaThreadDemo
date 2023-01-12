package com.changhao.demo07;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestThreadPool {
    public static void main(String[] args) {
        // 创建服务
        ExecutorService service = Executors.newFixedThreadPool(10);
        MyThread mythread = new MyThread();
        // 执行服务
        service.execute(mythread);
        service.execute(mythread);
        service.execute(mythread);
        service.execute(mythread);

        // 停止服务
        service.shutdown();
    }
}

class MyThread implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
