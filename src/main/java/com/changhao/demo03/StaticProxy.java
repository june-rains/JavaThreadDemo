package com.changhao.demo03;

// 静态代理总结：
// 代理对象和真实对象需要实现同一个接口
// 代理对象可以替真实对象处理方法

// 静态代理的好处
// 代理对象可以做很多真实对象做不了的事情
// 真实对象可以专注做自己的事情
public class StaticProxy {

    public static void main(String[] args) {
        // 一般情况
//        You you = new You();
//        you.HappyMarry();

        // 代理情况
        new WeddingCompany(new You()).HappyMarry();

        // 类比Thread类
        // new Thread(() -> System.out.println("我在学习多线程。。。")).start();
    }
}

interface Marry {
    void HappyMarry();
}


class You implements Marry {
    public void HappyMarry() {
        System.out.println("耗子要结婚了，很开心");
    }
}

class WeddingCompany implements Marry {
    // 真实对象，代理需要替这个真实对象执行方法
    private You target;


    public WeddingCompany(You target) {
        this.target = target;
    }

    public void HappyMarry() {
        before();
        this.target.HappyMarry();
        after();
    }

    private void after() {
        System.out.println("婚礼后，收取尾款");
    }

    private void before() {
        System.out.println("婚礼前，布置现场");
    }
}