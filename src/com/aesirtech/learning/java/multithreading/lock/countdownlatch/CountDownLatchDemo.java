package com.aesirtech.learning.java.multithreading.lock.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of CountDownLatch
 * @Author: Aesir
 * @Date: 2019/4/17 15:57
 */
public class CountDownLatchDemo {
    public static void main(String[] args) {
        /*
         * The function of CountDownLatch is similar to the countdown of rocket launching.
         */
        CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + " started.");
                try {
                    TimeUnit.SECONDS.sleep(new Random().nextInt(10) + 1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " ready to exit.");
                countDownLatch.countDown();
            }, "SubThread " + (i + 1)).start();
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("All subthreads are finished, MainThread ready to exit.");
    }

}
