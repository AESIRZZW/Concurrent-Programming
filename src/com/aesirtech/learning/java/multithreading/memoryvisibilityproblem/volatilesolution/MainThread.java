package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem.volatilesolution;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Volatile Solution of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:22
 */
public class MainThread {

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        new Thread(subThread).start();

        while (true) {
            if (subThread.isFlag()) {
                System.out.println("MainThread stops due to flag is changed.");
                break;
            }
        }
    }
}
