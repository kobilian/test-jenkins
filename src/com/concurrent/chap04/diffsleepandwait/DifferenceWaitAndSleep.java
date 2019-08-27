package com.concurrent.chap04.diffsleepandwait;

public class DifferenceWaitAndSleep {

    public static final Object LOCK = new Object();

    public static void m1(){
        try {
            Thread.sleep(100_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // 执行 m2 会报错，wait 依赖 synchronized
    public static void m2(){
        try {
            LOCK.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void m3(){
        synchronized (LOCK) {
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread("sleep"){
            @Override
            public void run() {
                m1();
            }
        }.start();

        /*
        new Thread("wait"){
            @Override
            public void run() {
                m2();
            }
        }.start();
        */
        new Thread("wait"){
            @Override
            public void run() {
                m3();
            }
        }.start();
    }
}
