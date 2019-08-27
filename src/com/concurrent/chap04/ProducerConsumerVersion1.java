package com.concurrent.chap04;

public class ProducerConsumerVersion1 {

    private int i = 1;

    private final Object LOCK = new Object();

    public void produceData(){
        synchronized (LOCK){
            System.out.println("P-> " + (i++));
        }
    }

    public void consumerData(){
        synchronized (LOCK){
            System.out.println("C -> " + i);
        }
    }

    public static void main(String[] args) {
        ProducerConsumerVersion1 pc = new ProducerConsumerVersion1();
        new Thread("Produce"){
            @Override
            public void run() {
                while (true)
                    pc.produceData();
            }
        }.start();

        new Thread("Consume"){
            @Override
            public void run() {
                while (true)
                    pc.consumerData();
            }
        }.start();
    }

}
