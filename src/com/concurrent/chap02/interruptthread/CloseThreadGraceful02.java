package com.concurrent.chap02.interruptthread;

import java.util.concurrent.TimeUnit;

public class CloseThreadGraceful02 {

    public static void main(String[] args) {
        Worker2 worker2 = new Worker2();
        worker2.start();

        try {
            TimeUnit.SECONDS.sleep(3L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        worker2.interrupt();
    }

}

class Worker2 extends Thread{

    @Override
    public void run() {
        while (true){
            if (this.isInterrupted())
                break;
            // TODO
        }
    }
}
