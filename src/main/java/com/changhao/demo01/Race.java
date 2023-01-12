package com.changhao.demo01;

// 模拟龟兔赛跑
public class Race implements Runnable{
    private String winner;

    public void run() {
        for (int i = 0; i <= 100; i++) {

            // 模拟兔子睡觉，时延, 每次线程是兔子的时候，并且走的步数是10的倍数, 除0以外, 我们让他睡觉
            if(Thread.currentThread().getName().equals("兔子") && i % 10 == 0 && i != 0) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }


            if(isOver(i)) {
                break;
            }

            System.out.println(Thread.currentThread().getName() + "--> 跑了 " + i + "步");
        }
    }

    public boolean isOver(int steps) {
        if(winner != null) {
            return true;
        } else {
            if(steps >= 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner is" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Race race = new Race();

        new Thread(race, "兔子").start();
        new Thread(race, "乌龟").start();
    }
}
