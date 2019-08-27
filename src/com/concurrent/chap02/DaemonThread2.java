package com.concurrent.chap02;

import java.util.concurrent.TimeUnit;
/*Daemon 线程*/
public class DaemonThread2 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            Thread inner = new Thread(() -> {
                while (true){
                    sleep(1);
                    System.out.println("health checking...");
                }

            });

            inner.setDaemon(true);
            inner.start();
            sleep(10L);
            System.out.println("outer thread is finished. ");
        });
        t1.start();
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
