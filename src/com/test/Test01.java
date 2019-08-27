package com.test;

public class Test01 {

    private int i = 0;

    private volatile boolean isProduce = true;

    private final Object LOCK = new Object();

    private void produceData(){
        synchronized (LOCK){
            while (isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Produce -> " + (++i));
            LOCK.notifyAll();
            isProduce = true;
        }
    }

    private void consumeData(){
        synchronized (LOCK){
            while (!isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Consume -> " + (i));
            LOCK.notifyAll();
            isProduce=false;
        }
    }

    public static void main(String[] args) {
        Test01 t1 = new Test01();
        new Thread(() -> {
            while (true){
                t1.produceData();
            }
        },"Producer").start();

        new Thread(()->{
            while (true){
                t1.consumeData();
            }
        },"Consumer").start();
    }



}
