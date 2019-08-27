package com.concurrent.chap02.interruptthread;

import java.util.concurrent.TimeUnit;

public class CloseThreadForce {

    public static void main(String[] args) {

        ThreadService service = new ThreadService();
        long begin = System.currentTimeMillis();
        service.execute(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        service.shutdown(5000L);
        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

}
