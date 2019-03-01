package com.concurrent.chapter1;

public class Demo {
    public static void main(String[] args) {
        new Thread(ListenerMusic::listen).start();
    }
}
