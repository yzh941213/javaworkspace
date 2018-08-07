package com._thread.delayed2;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 延时队列的每个节点
 * @param <T>
 */
public class DelayItem<T extends Runnable> implements Delayed {


    private final static AtomicLong atomic = new AtomicLong(0);

    /**
     * 过期时间
     */
    private long time;
    /**
     * 任务
     */
    private final T task;

    /**
     * 订单编号
     */
    private final String orderNum;

    /**
     * 序号
     */
    private final long number;

    public DelayItem(T task,long time,String orderNum) {
        this.time = System.nanoTime()+time;
        this.task = task;
        this.number = atomic.getAndIncrement();
        this.orderNum = orderNum;
    }

    /**
     * 过期时间
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

    /**
     * 排序方式
     */
    @Override
    public int compareTo(Delayed other) {
        if (other == this)
            return 0;
        if (other instanceof DelayItem)
        {
            DelayItem<?> x = (DelayItem<?>)other;
            long diff = time - x.time;
            if (diff < 0)
                return -1;
            else if (diff > 0)
                return 1;
            else if (number < x.number)
                return -1;
            else
                return 1;
        }
        long d = (getDelay(TimeUnit.NANOSECONDS) - other.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? -1 : 1);
    }


    public T getTask(){
        return task;
    }

    public String getOrderNum() {
        return orderNum;
    }
}
