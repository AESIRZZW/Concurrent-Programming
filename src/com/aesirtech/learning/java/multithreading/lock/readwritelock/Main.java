package com.aesirtech.learning.java.multithreading.lock.readwritelock;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of Read-Write Lock
 * @Author: Aesir
 * @Date: 2019/4/17 14:09
 */
public class Main {
    public static void main(String[] args) {
        ReadWriteLockCache ReadWriteLockCache = new ReadWriteLockCache();

        for (int i = 0; i < 5; i++) {
            // Variable used in lambda expression should be final or effectively final.
            final int temp = i + 1;
            new Thread(() -> {
                ReadWriteLockCache.put(String.valueOf(temp), temp);
            }, "Thread Write " + temp).start();
        }

        for (int i = 0; i < 5; i++) {
            final int temp = i + 1;
            new Thread(() -> {
                ReadWriteLockCache.get(String.valueOf(temp));
            }, "Thread Read " + temp).start();
        }
    }
}
