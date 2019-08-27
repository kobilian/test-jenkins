package com.concurrent.chap04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CaptureService {

    private static final LinkedList<Controller> CONTROLLERS= new LinkedList<>();
    private static final int MAX = 5;

    public static void main(String[] args) {

        List<Thread> workers = new ArrayList<>(10);
        List<String> threadNames = Arrays.asList("M1", "M2", "M3", "M4", "M5", "M6", "M7", "M8", "M9", "M10");

        for (String name : threadNames){
            Thread captureThread = createCaptureThread(name);
            captureThread.start();
            workers.add(captureThread);
        }

        workers.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("All of capture thread finished.");
    }

    public static Thread createCaptureThread(String name){
        return new Thread(()->{
            System.out.println("The worker [" + Thread.currentThread().getName() + "] Begin capture data.");
            synchronized (CONTROLLERS){
                while (CONTROLLERS.size() > MAX){
                    try {
                        CONTROLLERS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLLERS.addLast(new Controller());
            }
            System.out.println("The worker [" + Thread.currentThread().getName() + "] is Working");

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROLLERS){
                System.out.println("The worker [" + Thread.currentThread().getName() + "] End capture data");
                CONTROLLERS.removeFirst();
                CONTROLLERS.notifyAll();
            }
        },name);
    }

    private static class Controller{}
}
