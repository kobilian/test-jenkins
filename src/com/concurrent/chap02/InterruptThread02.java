package com.concurrent.chap02;

import java.util.concurrent.TimeUnit;

public class InterruptThread02 {


    public static void main(String[] args) {

        Thread main = Thread.currentThread();

        Thread t1 = new Thread(() -> {
            while (true){

            }
        });

        Thread t2 = new Thread(() ->{
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            main.interrupt();
        });

        t1.start();
        t2.start();
        try {
            t1.join();
        } catch (InterruptedException e) {
            System.out.println("main thread is interrupted");
        }

    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
