package com.concurrent.chap04.diffsleepandwait;

/**
 * sleep 不会释放锁
 * wait 会释放锁
 */
public class DifferenceWaitAndSleep2 {

    private static final Object LOCK = new Object();

    public static void m1(){
        synchronized (LOCK){
            try {
                System.out.println(Thread.currentThread().getName() + " inter m1.");
                Thread.sleep(30000_00);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m2(){
        synchronized (LOCK){
            System.out.println(Thread.currentThread().getName() + " inter m1.");
            try {
                LOCK.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
//        new Thread("testSleep1"){
//            @Override
//            public void run() {
//                m1();
//            }
//        }.start();
//
//        new Thread("testSleep2"){
//            @Override
//            public void run() {
//                m1();
//            }
//        }.start();

        new Thread("testWait1"){
            @Override
            public void run() {
                m2();
            }
        }.start();

        new Thread("testWait2"){
            @Override
            public void run() {
                m2();
            }
        }.start();

    }
}
