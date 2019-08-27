package com.concurrent.chap01.stackSize;

public class TestStackSize1 {

    private static int counter;

    public static void add(int i){
        counter++;
        add(i);
    }

    public static void main(String[] args) {
        try{
            add(1);
        }catch (Error e){
            System.out.println(counter);
        }
    }

}
