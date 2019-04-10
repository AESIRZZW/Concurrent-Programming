package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem.synchronization;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Synchronized Solution of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:23
 */
public class SubThread implements Runnable {

    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }
}
