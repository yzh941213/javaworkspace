package com._thread.pool;

public interface ThreadPool<Job extends Runnable> {

    /**
     * 往线程池中新增一条任务
     */
    void execute(Job job);


}
