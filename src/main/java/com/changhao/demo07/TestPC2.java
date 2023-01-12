package com.changhao.demo07;

public class TestPC2 {
    public static void main(String[] args) {
        TV tv = new TV();
        Player player = new Player(tv);
        Watcher watcher = new Watcher(tv);

        player.start();
        watcher.start();
    }
}


class Player extends Thread {
    private TV tv;

    public Player(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            if(i % 2 == 0) {
                this.tv.play("ted speech");
            } else {
                this.tv.play("jj concert");
            }
        }
    }
}

class Watcher extends Thread {
    private TV tv;

    public Watcher(TV tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            this.tv.watch();
        }
    }
}

class TV {
    private String voice;
    // true -> player play, watcher wait
    // false -> watcher watch, player wait
    private boolean flag = true;

    public synchronized void play(String voice) {
        if(!flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("player plays the " + voice);

        // player play over, then need to notify the watcher to watch
        this.notifyAll();
        this.voice = voice;
        this.flag = !this.flag;
    }

    public synchronized void watch() {
        if(flag) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("watcher watches the " + this.voice);

        // watcher watch over, then need to notify the player to play
        this.notifyAll();
        this.flag = !this.flag;
    }

}