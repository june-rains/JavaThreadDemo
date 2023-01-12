package com.changhao.demo06;

public class UnSafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000, "merry deposit ");
        DrawingMoney you = new DrawingMoney(account, 50, "you");
        DrawingMoney girlFriend = new DrawingMoney(account, 100, "girlFriend");

        new Thread(you).start();
        new Thread(girlFriend).start();
    }
}

class Account {
    int balance;
    String name;

    public Account(int balance, String name) {
        this.balance = balance;
        this.name = name;
    }
}

class DrawingMoney extends Thread {
    Account account;
    int drawingMoney;
    int nowMoney;

    public DrawingMoney(Account account, int drawingMoney, String name) {
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        // synchronized 块状语法,()中锁的是我们线程共同改变的对象
        synchronized (account) {
            if (this.account.balance - this.drawingMoney < 0) {
                System.out.println("not enough money !! you can not withdraw money");
                return;
            }

            // simulation the delay
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            this.account.balance = this.account.balance - this.drawingMoney;
            this.nowMoney = this.nowMoney + this.drawingMoney;
            System.out.println(account.name + "has balance: " + account.balance);
            System.out.println(this.getName() + " now has money " + this.nowMoney);
        }
    }
}
