package com.ricknash;

import java.util.concurrent.CountDownLatch;

public class Foo {

    CountDownLatch cdlForSecond;
    CountDownLatch cdlForThird;

    public Foo(CountDownLatch cdl2, CountDownLatch cdl3) {
        this.cdlForSecond = cdl2;
        this.cdlForThird = cdl3;
    }

    public void first(Runnable r) {
        r.run();
        cdlForSecond.countDown();
    }

    public void second(Runnable r) {
        try {
            cdlForSecond.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        r.run();
        cdlForThird.countDown();
    }

    public void third(Runnable r) {
        try {
            cdlForThird.await();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        r.run();
    }
}