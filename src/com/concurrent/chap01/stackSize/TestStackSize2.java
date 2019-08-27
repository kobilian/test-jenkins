package com.concurrent.chap01.stackSize;

public class TestStackSize2 {

    private static int counter;

    public static void main(String[] args) {
        new Thread(null,() -> {
            try {
                add(1);
            }catch (Error e){
                System.out.println(counter);
            }
        },"Test-StackSize",10000).start();
    }

    public static void add(int i){
        counter++;
        add(i);
    }
}
