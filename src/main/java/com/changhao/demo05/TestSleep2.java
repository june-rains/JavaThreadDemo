package com.changhao.demo05;

public class TestSleep2 {

    public static void main(String[] args) {
        TestSleep2 testSleep2 = new TestSleep2();
        try {
            testSleep2.tenDown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void tenDown() throws InterruptedException {
        int i = 10;
        while(i > 0) {
            Thread.sleep(1000);
            System.out.println(i--);
        }
    }
}
