package com.changhao.demo01;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class TestThread2 implements Runnable{
    private String url;
    private String name;

    public TestThread2(String url, String name) {
        this.url = url;
        this.name = name;
    }

    // 线程执行体
    public void run() {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println("Downloaded image" + name);
    }

    public static void main(String[] args) {
        TestThread2 t1 = new TestThread2("https://www.apple.com/v/iphone/home/bk/images/meta/iphone__ky2k6x5u6vue_og.png", "1.png");
        TestThread2 t2 = new TestThread2("https://www.cnet.com/a/img/resize/755704844d1e6efc7481dc5c1ebf577eb1e7c733/hub/2017/10/31/312b3b6e-59b7-499a-aea4-9bc5f9721a21/iphone-x-54.jpg?auto=webp&width=768", "2.png");
        TestThread2 t3 = new TestThread2("https://media.wired.com/photos/6149204955f7b3aea723343d/1:1/w_1568,h_1568,c_limit/Gear-Review-Apple_iPhone-13-Pro_Colors_09142021.jpg", "3.png");

//        t1.start();
//        t2.start();
//        t3.start();
        new Thread(t1).start();
        new Thread(t2).start();
        new Thread(t3).start();
    }

}


class WebDownloader {

    public void download(String url, String name) {
        try {
            // 将网络上URL中的内容变成一个文件
            FileUtils.copyURLToFile(new URL(url), new File(name));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IO Exception，download method has problem");
        }

    }
}
