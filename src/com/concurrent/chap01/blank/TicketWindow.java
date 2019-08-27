package com.concurrent.chap01.blank;

public class TicketWindow {

    public static void main(String[] args) {
//        Blank blank1 = new Blank("一号窗口");
//        blank1.start();
//
//        Blank blank2 = new Blank("二号窗口");
//        blank2.start();
//
//        Blank blank3 = new Blank("三号窗口");
//        blank3.start();
        BlankPlus blankPlus = new BlankPlus();
        new Thread(blankPlus,"一号窗口").start();
        new Thread(blankPlus,"二号窗口").start();
        new Thread(blankPlus,"三号窗口").start();
    }
}
