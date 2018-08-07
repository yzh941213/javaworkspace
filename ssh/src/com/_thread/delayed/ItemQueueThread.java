package com._thread.delayed;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ItemQueueThread {

    private ItemQueueThread() {

    }


    private static class LazyHolder{
        private static ItemQueueThread itemQueueThread = new ItemQueueThread();
    }

    public static ItemQueueThread getInstance(){
        return LazyHolder.itemQueueThread;
    }


    /**
     * 缓存线程池
     */
    ExecutorService executor = Executors.newCachedThreadPool();

    /**
     * 线程
     */
    private Thread daemonThread;



    public void init(){
        daemonThread = new Thread(()->{
                execute();
        });
        daemonThread.start();
    }


    private void execute(){
        while (true){
            try {
                //从延时队列中取值，如果没有对象过期则队列一直等待
                DelayItem item = items.take();
                if (item!=null){
                    Runnable task = item.getTask();
                    if (task == null)continue;
                    executor.execute(task);
                }
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }


    /**
     * 创建空的延迟队列
     */
    private DelayQueue<DelayItem<?>>items = new DelayQueue<>();


    /**
     * 向线程池中添加任务
     * @param time 延迟时间
     * @param task 任务
     * @param timeUnit 时间单位
     */
    public void put(long time, Runnable task, TimeUnit timeUnit){
        long nanoTime = TimeUnit.NANOSECONDS.convert(time,timeUnit);
        DelayItem<?> k = new DelayItem<>(nanoTime,task);
        items.put(k);
    }


    /**
     * 结束任务
     */
    public boolean endTask(DelayItem<Runnable>task){
        return items.remove(task);
    }


}
