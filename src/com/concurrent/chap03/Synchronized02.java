package com.concurrent.chap03;

import java.util.concurrent.TimeUnit;

public class Synchronized02 {

    public static void main(String[] args) {
        TaxWindow2 tax2 = new TaxWindow2();
        new Thread(tax2,"一号窗口").start();
        new Thread(tax2,"二号窗口").start();
        new Thread(tax2,"三号窗口").start();
    }
}

class TaxWindow2 implements Runnable{

    private final int MAX = 500;

    private int index = 1;


    @Override
    public void run() {
        while (true){
            if (ticket())
                break;
        }
    }

    private synchronized boolean ticket(){
        // get Filed index
        if (index >= MAX){
            return true;
        }else {
            sleep(1L);
            // index++  => index = index + 1
            // 1. get filed index
            // 2. index + 1
            // 3. set filed index
            System.out.println(Thread.currentThread().getName() + " -> " + (index++));
            return false;
        }
    }

    public void sleep(long mills){
        try {
            Thread.sleep(1L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}