package com.changhao.demo05;

public class TestState {
    public static void main(String[] args) {
        Thread thread = new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("/////////");
        });

        // NEW
        Thread.State state = thread.getState();
        System.out.println(state);

        // RUN
        thread.start();
        state = thread.getState();
        System.out.println(state);

        while(state != Thread.State.TERMINATED) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //TIMED_WAITING -> TERMINATED
            state = thread.getState();
            System.out.println(state);
        }

    }
}
