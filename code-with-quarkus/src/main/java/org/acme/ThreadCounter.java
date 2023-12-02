package org.acme;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadCounter {
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        AtomicInteger counter = new AtomicInteger();
        Runnable task = () -> {
            if (counter.incrementAndGet() % 1000 == 0) {
                System.out.println("Cantidad de threads iniciados hasta ahora: " + counter.get() 
                        + ", thread id: " + Thread.currentThread());
            }
            lock.lock();
        };
        
        while(true) {
//            Thread thread = new Thread(task);
            Thread thread = Thread.ofVirtual().unstarted(task);
            thread.start();
        }
    }
    
}
