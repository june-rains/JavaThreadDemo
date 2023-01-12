package com.changhao.demo02;

import com.changhao.demo01.TestThread2;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.*;

public class TestCallable implements Callable<Boolean> {

    private String url;
    private String name;

    public TestCallable(String url, String name) {
        this.url = url;
        this.name = name;
    }

    public Boolean call() throws Exception {
        WebDownloader webDownloader = new WebDownloader();
        webDownloader.download(url, name);
        System.out.println("Downloaded image" + name);
        return true;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TestCallable t1 = new TestCallable("https://www.apple.com/v/iphone/home/bk/images/meta/iphone__ky2k6x5u6vue_og.png", "1.png");
        TestCallable t2 = new TestCallable("https://www.cnet.com/a/img/resize/755704844d1e6efc7481dc5c1ebf577eb1e7c733/hub/2017/10/31/312b3b6e-59b7-499a-aea4-9bc5f9721a21/iphone-x-54.jpg?auto=webp&width=768", "2.png");
        TestCallable t3 = new TestCallable("https://media.wired.com/photos/6149204955f7b3aea723343d/1:1/w_1568,h_1568,c_limit/Gear-Review-Apple_iPhone-13-Pro_Colors_09142021.jpg", "3.png");

        // 创建服务
        ExecutorService ser = Executors.newFixedThreadPool(3);

        // 提交服务
        Future<Boolean> r1 = ser.submit(t1);
        Future<Boolean> r2 = ser.submit(t2);
        Future<Boolean> r3 = ser.submit(t3);

        // 获取线程执行结果
        boolean rs1 = r1.get();
        boolean rs2 = r2.get();
        boolean rs3 = r3.get();

        // 打印执行结果
        System.out.println(rs1);
        System.out.println(rs2);
        System.out.println(rs3);

        // 关闭服务
        ser.shutdownNow();

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
