package com.concurrent.chap01.blank;

public class Blank extends Thread {

    private final String name;

    private /*static*/ final int MAX = 50;

    private /*static*/ int index = 1;

    public Blank(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index < MAX){
            System.out.println("请第" + (index++) + "号顾客到" + name + "办理!!!");
        }
    }
}

