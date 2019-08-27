package com.concurrent.chap01.template;

public class TestTemplateMethod {
    public static void main(String[] args) {
       TemplateMethod method = new TemplateMethod() {
           @Override
           protected void warpPrint(String message) {
               System.out.println("***" + message + "***");
           }
       };
       method.printMessage("aha");
    }
}
