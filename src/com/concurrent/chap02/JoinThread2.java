package com.concurrent.chap02;

/*
join: 当前线程等待他的子线程执行结束后再执行
current thread wait the child thread to die

*/
public class JoinThread2 {
    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            task();
        },"MyThread1");


        Thread t2 = new Thread(() -> {
            task();
        },"MyThread2");

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        System.out.println("all of task finish done .");
        task();
    }

    public static void task(){
        for (int i = 0; i < 1000; i++){
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }
}
