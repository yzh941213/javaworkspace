package com._thread.delayed2;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ItemQueueThread {

    private ItemQueueThread() {

    }

    private static ItemQueueThread item;


    public static ItemQueueThread getInstance(){
        if (null == item){
            synchronized (ItemQueueThread.class){
                if (null == item){
                    item = new ItemQueueThread();
                }
            }
        }
        return item;
    }

    /**
     * 延时队列初始化
     * 1:创建守护线程
     * 2:
     */
    public void init(){
        new Thread(()-> execute()).start();
    }

    ExecutorService executorService = Executors.newCachedThreadPool();

    /**
     * 延时队列
     */
    private DelayQueue<DelayItem<?>>queue = new DelayQueue<>();

    private void execute(){
        while (true){
            try {
               DelayItem item = queue.take();
               Runnable runnable = item.getTask();
               if (null == runnable)continue;
               executorService.execute(runnable);
            }catch (Exception ex){
                ex.printStackTrace();
            }

        }
    }

    /**
     * put
     */
    public void put(long time,Runnable runnable,String orderNum){
        long nanoTime = TimeUnit.NANOSECONDS.convert(time,TimeUnit.SECONDS);
        queue.put(new DelayItem<>(runnable,nanoTime,orderNum));
    }


    /**
     * 移除延迟队列中的商品
     */
    public void remove(String orderNum){
        DelayItem[]delayItems = queue.toArray(new DelayItem[]{});
        if (delayItems.length==0)return;
        DelayItem target = null;
        for (DelayItem item:delayItems){
            if (orderNum.equals(item.getOrderNum())){
                target = item;
                break;
            }
        }
        if (null == target)return;
        queue.remove(target);
    }
}
