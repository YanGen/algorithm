package com.muhuan.algorithm.leetcode.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author muhuan
 * @date 2020/11/29 15:22
 * @description ...
 */
public class LockSupportTest {
    static Lock lock = new ReentrantLock();
    static Condition condition = lock.newCondition();


    public static void main(String[] args) {
        lock.lock();
        try {
            condition.wait();
            condition.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        lock.unlock();
        LockSupport.park();
        LockSupport.unpark(Thread.currentThread());
    }
}
