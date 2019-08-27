package com.concurrent.chap04;

/**
 * 在多个 producer 和 consumer 下会发生问题
 */
public class ProducerConsumerVersion2 {

    private int i = 1;

    private final Object LOCK = new Object();

    private volatile boolean isProduce = true;

    public void produceData(){
        synchronized (LOCK){
            if (isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("P-> " + (i++));
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consumeData(){
        synchronized (LOCK){
            if (isProduce){
                System.out.println("C-> " + i);
                LOCK.notify();
                isProduce = false;
            }else {
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion2 v2 = new ProducerConsumerVersion2();

        new Thread("PRODUCE"){
            @Override
            public void run() {
                while (true)
                    v2.produceData();
            }
        }.start();

        new Thread("CONSUMER"){
            @Override
            public void run() {
                while (true)
                    v2.consumeData();
            }
        }.start();
    }
}
