package com.changhao.demo05;

public class TestDaemon {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();

        Thread thread = new Thread(god);
        thread.setDaemon(true);
        thread.start();

        new Thread(you).start();
    }
}


class God implements Runnable {
    @Override
    public void run() {
        while(true) {
            System.out.println("上帝守护着你");
        }
    }
}

class You implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 36500; i++) {
            System.out.println("你的一生都在努力有意义的活着");
        }
        System.out.println("GoodBye, World");
    }
}