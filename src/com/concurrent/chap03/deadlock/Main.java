package com.concurrent.chap03.deadlock;

public class Main {

    public static void main(String[] args) {

        OtherService otherService = new OtherService();
        DeadLock deadLock = new DeadLock(otherService);
        otherService.setDeadLock(deadLock);

        new Thread("DEAD_LOCK"){
            @Override
            public void run() {
                while (true){
                    deadLock.m1();
                }
            }
        }.start();

        new Thread("OTHER_SERVICE"){
            @Override
            public void run() {
                while (true){
                    otherService.s2();
                }
            }
        }.start();
    }

}
