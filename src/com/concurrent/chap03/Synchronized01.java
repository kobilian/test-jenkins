package com.concurrent.chap03;

public class Synchronized01 {
    public static void main(String[] args) {
        TaxWindow taxWindow = new TaxWindow();
        new Thread(taxWindow,"一号窗口").start();
        new Thread(taxWindow,"二号窗口").start();
        new Thread(taxWindow,"三号窗口").start();
    }
}

class TaxWindow implements Runnable{

    private static final int MAX = 500;

    private int index;

    private static final Object MONITOR = new Object();

    @Override
    public void run() {
        synchronized (MONITOR){
            while (true){
                if (index > MAX)
                    break;
                try {
                    Thread.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " -> " + (index++));
            }
        }
    }
}