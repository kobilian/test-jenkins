package com.concurrent.chap05;

public class CatchExceptionOfRunMethod {

    private static final int A = 10;
    private static final int B = 0;

    public static void main(String[] args) {
        Thread t1 = new Thread(() ->{
            try {
                Thread.sleep(10_00);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            int result = A / B;
            System.out.println(result);

        },"ThreadA");

        t1.setUncaughtExceptionHandler((thread,e) -> {
            System.out.println(thread.getName() + " throws Exception: " + e);
        } );
        t1.start();
       // Runtime.getRuntime().addShutdownHook(new Thread(() ->{}));
    }
}
