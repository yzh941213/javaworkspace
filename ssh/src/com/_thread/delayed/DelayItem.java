package com._thread.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

public class DelayItem<T extends Runnable> implements Delayed {

    /**
     * 到期时间
     */
    private final long time;

    /**
     * 任务对象
     */
    private final T task;

    /**
     * 原子类
     */
    private static final AtomicLong atomic = new AtomicLong(0);

    /**
     * 序号
     */
    private final long number;


    public DelayItem(long time, T task) {
        this.time = System.nanoTime()+time;
        this.task = task;
        this.number = atomic.getAndIncrement();
    }


    /**
     * 返回与此对象相关的剩余延迟时间，以给定的时间单位表示
     */
    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(this.time-System.nanoTime(),TimeUnit.NANOSECONDS);
    }

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
        return this.task;
    }
}
