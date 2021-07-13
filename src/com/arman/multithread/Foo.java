package com.arman.multithread;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Foo {
    private boolean onePrinted = false;
    private boolean twoPrinted = false;

    public synchronized void first(Runnable first)  {
      first.run();
      onePrinted = true;
      notifyAll();
    }
    public synchronized void second(Runnable second) throws InterruptedException {
        while (!onePrinted) {
            wait();
        }
        second.run();
        twoPrinted = true;
        notifyAll();
    }
    public synchronized void third(Runnable third)  throws InterruptedException {
        while (!twoPrinted) {
            wait();
        }
        third.run();
    }
}

