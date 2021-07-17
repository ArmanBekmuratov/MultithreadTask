package com.arman.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    private final Semaphore semaphore1 = new Semaphore(0);
    private final Semaphore semaphore2 = new Semaphore(0);

    public void first(Runnable first) throws InterruptedException  {
        try {
            first.run();
        } finally {
            semaphore1.release();
        }
    }
    public synchronized void second(Runnable second) throws InterruptedException {
        try {
            semaphore1.acquire();
            second.run();
        } finally {
            semaphore2.release();
        }
    }
    public synchronized void third(Runnable third)  throws InterruptedException {
        semaphore2.acquire();
        third.run();
    }
}

