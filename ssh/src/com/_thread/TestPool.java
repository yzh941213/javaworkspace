package com._thread;

import com._thread.pool.ThreadPool;
import com._thread.pool.ThreadPoolImpl;

public class TestPool {

    public static void main(String[] args) {

        ThreadPool threadPool = new ThreadPoolImpl();
        for (int i=0;i<100;i++){
            threadPool.execute(()-> System.out.println(Thread.currentThread().getName()));
        }
    }
}
