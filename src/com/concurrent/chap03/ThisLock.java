package com.concurrent.chap03;

import java.util.concurrent.TimeUnit;

public class ThisLock {
    public static void main(String[] args) {
        This thisLock = new This();

        new Thread("T1"){
            @Override
            public void run() {
                thisLock.m1();
            }
        }.start();

        new Thread("T2"){
            @Override
            public void run() {
                thisLock.m2();
            }
        }.start();

        new Thread("T3"){
            @Override
            public void run() {
                thisLock.m3();
            }
        }.start();
    }
}

class This{
    public synchronized void m1(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void m2(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void m3(){
        System.out.println(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
