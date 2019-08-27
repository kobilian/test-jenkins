package com.concurrent.chap02;

import java.util.stream.IntStream;

/*join*/
public class JoinThread1 {

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++){
                System.out.println(Thread.currentThread().getName() + " -> " + i);
            }
        },"myThread");

        t1.start();
        //t1.join();

        for (int i = 0; i < 1000; i++){
            System.out.println(Thread.currentThread().getName() + " -> " + i);
        }
    }

}
