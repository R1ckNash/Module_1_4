package com.ricknash;

import java.util.concurrent.CountDownLatch;

public class App {
    public static void main(String[] args) {

        CountDownLatch cdl2 = new CountDownLatch(1);
        CountDownLatch cdl3 = new CountDownLatch(1);

        Foo foo = new Foo(cdl2, cdl3);

        Runnable first = () -> foo.first(new MyThread("first"));
        Runnable second = () -> foo.second(new MyThread("second"));
        Runnable third = () -> foo.third(new MyThread("third"));

        Thread a =  new Thread(first);
        Thread b =  new Thread(second);
        Thread c =  new Thread(third);

        c.start();
        a.start();
        b.start();
    }
}
