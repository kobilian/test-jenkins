package com.test;

public class Test02 {

    private volatile boolean isFinished = false;

    public Thread create(Runnable task){
        return new Thread(() ->{
            Thread thread = new Thread(task);
            thread.setDaemon(true);
            thread.start();
            try {
                thread.join();
                isFinished = true;
            } catch (InterruptedException e) {}

        }){};
    }

    public void shutDown(long mills){
        long currentTime = System.currentTimeMillis();
        
    }

}
