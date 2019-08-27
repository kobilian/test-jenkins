package com.concurrent.chap03;

public class StaticLock {
    public static void main(String[] args) {
        new Thread("T1"){
            @Override
            public void run() {
                Static.m1();
            }
        }.start();
    }
}

class Static{
    static {
        synchronized (Static.class){
            System.out.println("static block " + Thread.currentThread().getName());
            try {
                Thread.sleep(10_000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized static void m1(){
        System.out.println("m1 " + Thread.currentThread().getName());
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
