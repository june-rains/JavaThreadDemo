package com.changhao.demo06;

public class UnSafeBuyTickets {
    public static void main(String[] args) {
        BuyTickets buyTickets = new BuyTickets();

        new Thread(buyTickets, "Changhao ").start();
        new Thread(buyTickets, "Yunpeng ").start();
        new Thread(buyTickets, "Ruiqi ").start();
    }
}


class BuyTickets implements Runnable {

    private int ticketNums = 1000;
    boolean flag = true;
    @Override

    public void run() {
        while(flag) {
            buy();
        }
    }
    // synchronized方法 默认锁的是这个对象this
    public synchronized void buy() {
        if (ticketNums <= 0) {
            flag = false;
            return;
        }
        System.out.println(Thread.currentThread().getName() + "get ticket " + ticketNums--);
    }
}
