package com.concurrent.chap01.template;

public class SimilarTemplateMethod {

    public void start(){
        run();
    }

    public void run() {
    }

    public static void main(String[] args) {
       new SimilarTemplateMethod(){
            @Override
            public void run() {
                //TODO
            }
        }.start();
    }
}
