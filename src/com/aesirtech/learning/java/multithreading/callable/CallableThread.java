package com.aesirtech.learning.java.multithreading.callable;

import java.util.concurrent.Callable;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Simple Demonstration of Callable Interface
 * @Author: Aesir
 * @Date: 2019/4/13 21:34
 */
public class CallableThread implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("Calling in progress");
        return "Call success.";
    }
}


/* Notes:
 *
 * Different between interface Callable and Runnable:
 * 1. Callable has a return value while Runnable does not.
 * 2. Callable throws an exception while Runnable does not.
 */