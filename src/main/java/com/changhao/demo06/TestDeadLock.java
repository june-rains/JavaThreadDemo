package com.changhao.demo06;

public class TestDeadLock {
    public static void main(String[] args) {
        MakeUp g1 = new MakeUp(0, "grey girl ");
        MakeUp g2 = new MakeUp(1, "white girl ");

        g1.start();
        g2.start();
    }
}

class Mirror {

}

class Lipstick {

}


class MakeUp extends Thread {

    // use static to ensure that it will only have one mirror and one lipstick
    static Mirror mirror = new Mirror();
    static Lipstick lipstick = new Lipstick();

    private int choice;
    private String girlName;

    public MakeUp(int choice, String girlName) {
        this.choice = choice;
        this.girlName = girlName;
    }


    @Override
    public void run() {
        try {
            makeup();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void makeup() throws InterruptedException {
        if(choice == 0) {
            synchronized (mirror) {
                System.out.println(this.girlName + "get mirror lock");
                Thread.sleep(1000);
            }
            synchronized (lipstick) {
                System.out.println(this.girlName + "get lipstick lock");
            }
        } else {
            synchronized (lipstick) {
                System.out.println(this.girlName + "get lipstick lock");
                Thread.sleep(2000);
            }
            synchronized (mirror) {
                System.out.println(this.girlName + "get mirror lock");
            }
        }
    }
}
