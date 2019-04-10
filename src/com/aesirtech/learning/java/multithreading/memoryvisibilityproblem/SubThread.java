package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A simple demostration of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:23
 */
public class SubThread implements Runnable {

    /*
     * Define a flag as a shared variable.
     *
     * Shared variable: If a variable has copies in the working memory of multiple threads,
     * then this variable is the shared variable of these threads.
     * Visibility: The modification of shared variable values by one thread can be seen by other threads in time.
     */
    private boolean flag = false;

    public boolean isFlag() {
        return flag;
    }

    @Override
    public void run() {
        try {
            /*
             * SubThread sleep 200 ms and wait for the MainThread to read flag = false before changing its value.
             */
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        flag = true;
        System.out.println("flag=" + isFlag());
    }
}
