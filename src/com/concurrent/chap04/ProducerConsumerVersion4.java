package com.concurrent.chap04;

public class ProducerConsumerVersion4 {

    private int i = 0;

    private final Object LOCK = new Object();

    private volatile boolean isProduce = false;


    public void produceData() {
        synchronized (LOCK) {
            while (isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("P->" + (i++));
            LOCK.notifyAll();
            isProduce = true;
        }
    }

    public void consumeData() {
        synchronized (LOCK) {
            while (!isProduce) {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("C->" + i);
            LOCK.notifyAll();
            isProduce = false;
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion4 v4 = new ProducerConsumerVersion4();
        new Thread("Produce") {
            @Override
            public void run() {
                while (true)
                    v4.produceData();
            }
        }.start();
        new Thread("Consumer") {
            @Override
            public void run() {
                while (true)
                    v4.consumeData();
            }
        }.start();
    }
}
