package com.concurrent.chap04;

/**
 * 在多个 producer 和 consumer 下会导致线程假死的情况
 *      原因：持有同一把锁的锁哥线程 notify 可并不分你是 produce 还是 consumer
 *
 * 生产者消费者为什么要用 while 而不适用 if
 */
public class ProducerConsumerVersion3 {

    private int i = 1;

    private final Object LOCK = new Object();

    // 不要看这个干扰项
    private volatile boolean isProduce = false;

    public void produce(){
        synchronized (LOCK){
            if (isProduce){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println("P -> " + (i++));
                LOCK.notify();
                isProduce = true;
            }
        }
    }

    public void consume(){
        synchronized (LOCK){
            if (isProduce){
                System.out.println("C -> " + i);
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

        ProducerConsumerVersion3 v3 = new ProducerConsumerVersion3();
        new Thread("Produce"){
            @Override
            public void run() {
                while (true)
                    v3.produce();
            }
        }.start();

        new Thread("Consumer"){
            @Override
            public void run() {
                while (true)
                    v3.consume();
            }
        }.start();

    }

}
