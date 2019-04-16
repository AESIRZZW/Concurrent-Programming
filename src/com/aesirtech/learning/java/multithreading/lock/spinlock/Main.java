package com.aesirtech.learning.java.multithreading.lock.spinlock;

import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of Spin Lock
 * @Author: Aesir
 * @Date: 2019/4/16 23:38
 */
public class Main {
    public static void main(String[] args) {
        SpinLock spinLock = new SpinLock();

        new Thread(() -> {
            spinLock.lock();
            try {
                System.out.println("Thread A is working.");
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        }, "Thread A").start();

        // Main thread sleeps for one second to ensure that thread A gets the lock before thread B.
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> {
            spinLock.lock();
            try {
                System.out.println("Thread B is working.");
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            spinLock.unlock();
        }, "Thread B").start();
    }
}
