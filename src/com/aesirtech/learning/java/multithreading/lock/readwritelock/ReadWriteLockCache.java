package com.aesirtech.learning.java.multithreading.lock.readwritelock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of Read-Write Lock
 * @Author: Aesir
 * @Date: 2019/4/17 14:10
 */
public class ReadWriteLockCache {
    private volatile Map<String, Object> map = new HashMap<>();
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    public void put(String key, Object value) {
        lock.writeLock().lock();
        try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "\t is writing " + key);
            // Simulated network delay
            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            map.put(key, value);
            System.out.println(thread.getName() + "\t writes successfully");
        } finally {
            lock.writeLock().unlock();
        }
    }

    public void get(String key) {
        lock.readLock().lock();
        try {
            Thread thread = Thread.currentThread();
            System.out.println(thread.getName() + "\t is reading " + key);

            try {
                TimeUnit.MILLISECONDS.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            Object result = map.get(key);
            System.out.println(thread.getName() + "\t reads " + result);
        } finally {
            lock.readLock().unlock();
        }
    }
}
