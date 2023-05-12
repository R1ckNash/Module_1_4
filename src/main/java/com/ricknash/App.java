package com.ricknash;

import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {

        CountDownLatch cdl2 = new CountDownLatch(1);
        CountDownLatch cdl3 = new CountDownLatch(1);

        Foo foo = new Foo(cdl2, cdl3);

        Runnable firstTask = () -> foo.first(new MyThread("first"));
        Runnable secondTask = () -> foo.second(new MyThread("second"));
        Runnable thirdTask = () -> foo.third(new MyThread("third"));


        new Thread(thirdTask).start();
        new Thread(firstTask).start();
        new Thread(secondTask).start();
    }
}
