package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demostration of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:22
 */
public class MainThread {

    public static void main(String[] args) {
        SubThread subThread = new SubThread();
        new Thread(subThread).start();

        /*
         * The goal is to stop the main thread when the shared variable flag is changed.
         * Nevertheless, this will never happen.
         *
         * 《Concurrent Programming in Java: Design Principles and Patterns, Second Edition》§2.2.7
         * "Every thread is defined to have a working memory (an abstraction of caches and registers) in which to store values."
         *
         * Two provisions on operate shared variables in JMM:
         * 1. Threads must perform all operations on shared variables in their own memory and cannot read or write directly from main memory.
         * 2. Variables in the working memory of other threads can not be accessed directly between different threads.
         *    The transfer of variable values between threads needs to be completed through main memory.
         *
         * The while loop is a very low-level piece of code with high execution efficiency.
         * This makes it impossible for the main thread to retrieve new data from heap memory.
         */
        while (true) {
            if (subThread.isFlag()) {
                System.out.println("MainThread stops due to flag is changed.");
                break;
            }
        }
    }
}
