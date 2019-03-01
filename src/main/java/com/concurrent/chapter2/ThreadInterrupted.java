package com.concurrent.chapter2;

import java.util.concurrent.TimeUnit;

public class ThreadInterrupted {

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            try {
                TimeUnit.MINUTES.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.printf("I am interrupted");
            }
        });
        t.start();
        TimeUnit.SECONDS.sleep(2);

        t.interrupt();

    }
}
