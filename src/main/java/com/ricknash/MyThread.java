package com.ricknash;

public class MyThread implements Runnable {
    String str;

    MyThread(String str) {
        this.str = str;
    }

    @Override
    public void run() {
        System.out.print(str);
    }
}
