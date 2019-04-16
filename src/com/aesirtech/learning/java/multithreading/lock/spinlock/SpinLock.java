package com.aesirtech.learning.java.multithreading.lock.spinlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of Spin Lock
 * @Author: Aesir
 * @Date: 2019/4/16 23:18
 */
public class SpinLock {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    public void lock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " tries to lock.");
        while (!atomicReference.compareAndSet(null, thread)) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(thread.getName() + " attempt failed, loop waiting...");
        }
        System.out.println(thread.getName() + " locks successfully.");
    }

    public void unlock() {
        Thread thread = Thread.currentThread();
        atomicReference.compareAndSet(thread, null);
        System.out.println(thread.getName() + " unlocked.");
    }
}
