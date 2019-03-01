package com.concurrent.chapter3;

public class DeadLock {

    private final static  DeadLock readLock = new DeadLock();
    private final static  DeadLock writeLock = new DeadLock();


    public  void read(){
        synchronized (readLock){
            synchronized (writeLock){
                System.out.println(Thread.currentThread().getName()+"read running...");
            }
        }

    }

    public  void write(){
        synchronized (writeLock){
            synchronized (readLock){
                System.out.println(Thread.currentThread().getName()+"write running...");
            }
        }

    }

    public static void main(String[] args) {
        DeadLock deadLock = new DeadLock();
//        new Thread(deadLock::read){}.start();
//        new Thread(deadLock::write){}.start();
        new Thread(()->{
            while (true){
                deadLock.read();
            }
        }){}.start();

        new Thread(()->{
            while (true){
                deadLock.write();
            }
        }){}.start();
    }
}
