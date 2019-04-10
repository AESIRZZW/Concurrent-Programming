package com.aesirtech.learning.java.multithreading.memoryvisibilityproblem.volatilesolution;

/**
 * @ProjectName: Concurrent Programming
 * @Description: A Volatile Solution of Memory-Visibility-Problem.
 * @Author: Aesir
 * @Date: 2019/4/10 19:23
 */
public class SubThread implements Runnable {

    /*
     * Volatile keywords solve Memory-Visibility-Problems by adding memory barriers and prohibiting reordering optimization.
     * When a write operation is performed on a Volatile variable, a store barrier instruction is added after the write operation;
     * When a read operation is performed on a Volatile variable, a load barrier instruction is added before the read operation.
     *
     * Threads write volatile variables course:
     * 1. Change the value of volatile variable copy in thread working memory;
     * 2. Refresh the value of the changed copy from thread working memory to main memory.
     * Threads read volatile variables course:
     * 1. Copy the latest volatile variable from main memory to thread working memory.
     * 2. Read a copy of volatile variable from working memory.
     *
     * Instruction reordering:
     * The order of code writing is different from that of actual execution.
     * Instruction reordering is an optimization made by a compiler or processor to improve program performance.
     * 1. Reordering of compiler optimization (compiler optimization)
     * 2. Instruction level parallel reordering (processor optimization)
     * 3. Reordering of memory systems (processor optimization)
     * Reordering does not cause memory visibility problems for single threads (because of as-if-series semantics)
     * But can cause memory visibility problems when programs are interleaved in multi-threads.
     *
     * As-if-series semantics
     * Regardless of reordering, the results of program execution should be consistent
     * Java compilers, runtime and processors guarantee that Java follows as-if-series semantics in a single thread.
     *
     * Volatile is a lightweight solution to Memory-Visibility-Problem.
     * It does not block thread execution and thus is more efficient (or less costly).
     * However, it only solves the problem of memory visibility, without guaranteeing the atomicity of the operation (synchronized guarantees both).
     *
     * Volatile applications:
     * The safe use of volatile variables in multithreading must satisfy two conditions at the same time:
     * 1. Writing a variable does not depend on its current value, such as number++(but boolean can,it's only true or false).
     * 2. The variable is not included in the invariant with other variables, if there are multiple volatile variables,
     *    each volatile variable must be independent of other volatile variables.
     */
    private volatile boolean flag = false;

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
