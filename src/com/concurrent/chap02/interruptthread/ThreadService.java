package com.concurrent.chap02.interruptthread;

import java.util.concurrent.TimeUnit;

public class ThreadService {

    private Thread executeThread;

    private volatile boolean finished = false;

    public void execute(Runnable task){
        executeThread = new Thread(){
            @Override
            public void run() {
                Thread runner = new Thread(task);
                runner.setDaemon(true);
                runner.start();
                try {
                    // 这里是让执行线程等待 runner 线程执行。避免执行线程启动后还 runner 线程还没有启动就结束了。
                    runner.join();
                    // 如果 runner 线程执行之后，finished = true;
                    // 如果 runner 线程一直处于执行状态，那么执行线程会一直等待 runner 执行结束，finished 就不会为 true。
                    // 只有 runner 线程执行结束，finished 才能为 true。
                    finished = true;
                } catch (InterruptedException e) {}
            }
        };
        executeThread.start();
    }

    public void shutdown(long mills){
        long concurrentTime = System.currentTimeMillis();
        while (!finished){
            // 如果 runner 线程执行超时
            if ((System.currentTimeMillis() - concurrentTime) >= mills){
                System.out.println("任务执行超时，需要打断他");
                executeThread.interrupt();
                break;
            }

            try {
                executeThread.sleep(1L);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断");
                break;
            }
        }
        finished = false;
    }
}