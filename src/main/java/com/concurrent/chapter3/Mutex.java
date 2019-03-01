package com.concurrent.chapter3;

import java.util.concurrent.TimeUnit;

public class Mutex {

    public final static Mutex mutex = new Mutex();

    public void accessResources() {
        synchronized (mutex) {
            try {
                System.out.println(Thread.currentThread().getName());
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        Mutex mutex = new Mutex();

        for (int i = 0; i < 5; i++) {
            new Thread(mutex::accessResources){}.start();
        }

    }
}
