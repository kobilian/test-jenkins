package com.concurrent.chap01.blank;

public class BlankPlus implements Runnable{

    private String name;

    private static final int MAX = 50;

    private int index = 1;

    @Override
    public void run() {
        while (index < MAX){
            System.out.println("请第" + (index++) + "号顾客到" + Thread.currentThread().getName() + "办理");
        }
    }
}
