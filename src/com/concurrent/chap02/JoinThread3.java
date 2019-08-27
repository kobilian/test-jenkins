package com.concurrent.chap02;

import java.util.concurrent.TimeUnit;
/*
Join
    Thread.currentThread().join();
    当前线程等待当前线程运行结束： 当前线程结束了吗？ 没有，他正在等待当前线程结束。
*/
public class JoinThread3 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            task();
        });

        t1.start();
        t1.join();

        System.out.println("all task die");
        task2();


    }

    public static void task(){
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int i = 10/0;
    }

    public static void task2(){
        for (int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }

}
