package com.concurrent.chap02;

import java.util.concurrent.TimeUnit;

public class InterruptThread01 {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true){}
        });

        t1.start();

        sleep(3L);
        System.out.println(t1.isInterrupted());
        t1.interrupt();
        System.out.println(t1.isInterrupted());
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
