package com.concurrent.chapter2;

public class TicketWindowRunnable implements Runnable{

    public static Integer MAX = 500;
    private static Integer index = 1;

    private final Object mutex = new Object();

    @Override
    public void run() {
        synchronized (mutex){
            while (index <= MAX){
                System.out.println(Thread.currentThread() + "---正在处理的任务号---"+ (index++));
            }
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable task = new TicketWindowRunnable();
        Thread t1 = new Thread(task,  "一号窗口");
        Thread t2 = new Thread(task,  "二号窗口");
        Thread t3 = new Thread(task,  "三号窗口");
        Thread t4 = new Thread(task,  "四号窗口");
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }
}
