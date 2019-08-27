package com.concurrent.chap01;

import java.util.concurrent.TimeUnit;

/**
 * start() 方法
 *
 *      start() 方法实际调用的 start0()
 *      start0() 调用了 run() 方法。
 *      这里使用的是 类模板设计模式
 *
 *
 * 当调用 start() 方法时，此时有两个线程，一个是调用 start() 方法的线程，另一个是 start() 启动的线程。
 * 线程的生命周期为： New    Runnable    Running     Blocked     Terminated
 */
public class T1 {

    public static void main(String[] args) {
        new Thread("ReadData-Thread"){
            @Override
            public void run() {
                readDataFromDB();
            }
        }.start();

        new Thread("WriteDate-Thread"){
            @Override
            public void run() {
                writeDataToFile();
            }
        }.start();
    }

    public static void readDataFromDB(){
        println("Begin read data from db");
        sleep(1L);
        println("Read data done and start handle it");
        sleep(2L);
        println("The data handle done and successful.");
    }

    public static void writeDataToFile(){
        println("Begin write data to file");
        sleep(3L);
        println("write data done and start handle it");
        sleep(4L);
        println("The data handle done and successful");
    }

    public static void println(String message){
        System.out.println(message);
    }

    public static void sleep(long time){
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
