package com.changhao.demo05;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestSleep3 {

    public static void main(String[] args) {
        Date startTime = new Date(System.currentTimeMillis());

        while(true) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println(new SimpleDateFormat("HH:mm:ss").format(startTime));
            startTime = new Date(System.currentTimeMillis());
        }

    }
}
