package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem.synchronization;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Synchronized Solution of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:22
 */
public class MainThread {

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        new Thread(subThread).start();

        while (true) {
            /*
             * Two provisions on synchronized in JVM:
             * Before a thread unlocks, it must refresh the latest values of shared variables to main memory.
             * When a thread locks, the values of shared variables in working memory are cleared so that the latest values need to be re-read from memory when using shared variables.
             * (note: locking and unlocking need to be the same lock).
             *
             * However, synchronization can lead to serious efficiency problems,
             * there is no doubt that this solution is too heavy.
             */
            synchronized (subThread) {
                if (subThread.isFlag()) {
                    System.out.println("MainThread stops due to flag is changed.");
                    break;
                }
            }
        }
    }
}
