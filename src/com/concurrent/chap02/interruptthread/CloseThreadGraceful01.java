package com.concurrent.chap02.interruptthread;

import java.util.concurrent.TimeUnit;

public class CloseThreadGraceful01 {
    public static void main(String[] args) {

        Worker worker = new Worker();
        Thread t1 = new Thread(worker);
        t1.start();

        try {
            TimeUnit.SECONDS.sleep(2L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker.shutdown();

    }
}

class Worker implements Runnable{
    private volatile boolean start = true;

    @Override
    public void run() {
        while (start){

        }
    }

    public void shutdown(){
        this.start = false;
    }
}