package com.concurrent.chapter2;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Demo {

    public static void main(String[] args) {

        Demo demo  = new Demo();
        try {
            demo.wait(1000);
            demo.notify();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            long start = System.currentTimeMillis();
//            try {
//                Thread.sleep(1000L);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Thread.interrupted();

            System.out.printf(System.currentTimeMillis() - start +"ms");

        }).start();
    }
}
