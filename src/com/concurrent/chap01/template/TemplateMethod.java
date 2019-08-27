package com.concurrent.chap01.template;

/**
 * 模板方法设计模式的几点约束：
 *      1. 模板方法对应的类必须为 abstract
 *      2. 模板方法必须声明为 final，用于禁止子类复写
 */
public abstract class TemplateMethod {

    public final void printMessage(String message){
        System.out.println("##########");
        warpPrint(message);
        System.out.println("##########");
    }

    protected abstract void warpPrint(String message);
}
