package com.aesirtech.learning.java.multithreading.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @ProjectName: Concurrent Programming
 * @Description:
 * @Author: Aesir
 * @Date: 2019/4/13 21:32
 */
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        /*
         * Class FutureTask implements interface Runnable and has a constructor method with interface Callable as parameter,
         * which is adapter design pattern.
         */
        FutureTask<String> futureTask = new FutureTask<>(new CallableThread());

        /*
         * So we can continue to use the previous constructor: Thread thread = new Thread(Runnable runnable, String name).
         */
        Thread thread = new Thread(futureTask, "CallableThread");
        thread.start();
        System.out.println("We can get the return value from Callable interface in this way. \n" + futureTask.get());
        System.out.println("A FutureTask will only be executed once unless another FutureTask is created. \n" + futureTask.get());
    }
}



