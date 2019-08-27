package com.concurrent.chap02;

import java.util.concurrent.TimeUnit;
/*Daemon 线程*/
public class DaemonThread1 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " running");
            sleep(5);
            System.out.println(Thread.currentThread().getName() + " done");
        });
        t1.setDaemon(true);
        t1.start();

        sleep(1);

        System.out.println(Thread.currentThread().getName() + " done.");
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
