package com.concurrent.chap03.deadlock;

public class OtherService {

    private final Object LOCK = new Object();
    private DeadLock deadLock;

    public void setDeadLock(DeadLock deadLock){
        this.deadLock = deadLock;
    }

    public void s1(){
        synchronized (LOCK){
            System.out.println("s1");
        }
    }

    public void s2(){
        synchronized (LOCK){
            System.out.println("s2");
            deadLock.m2();
        }
    }

}
