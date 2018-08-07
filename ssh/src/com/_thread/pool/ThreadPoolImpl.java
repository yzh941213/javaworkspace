package com._thread.pool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ThreadPoolImpl<Job extends Runnable> implements ThreadPool<Job>{


    private final static int MAX_POOL_number = 10;

    private final static int DEFAULT_POOL_NUMBER = 5;


    private final LinkedList<Job>jobs = new LinkedList<>();

    private final List<Worker> list = Collections.synchronizedList(new ArrayList<>());


    public ThreadPoolImpl() {
        initWorker(DEFAULT_POOL_NUMBER);
    }


    @Override
    public void execute(Job job) {//生产者
        if (null == job)return;
        synchronized (jobs){
            jobs.addFirst(job);
            jobs.notify();
        }
    }




    private void initWorker(int num){
        for (int i=0;i<num;i++){
            Worker worker = new Worker();
            list.add(worker);
            Thread thread = new Thread(worker);
            thread.start();
        }
    }



    class Worker implements Runnable{//消费者线程
        private volatile boolean running = true;

        @Override
        public void run() {
            while (running){
                Job job = null;
                synchronized (jobs){
                    if (jobs.isEmpty()){
                        try {
                            jobs.wait();
                        }catch (Exception ex){
                            ex.printStackTrace();
                        }
                    }
                    job = jobs.removeFirst();
                    if (job != null)job.run();
                }
            }
        }


        public void shutDown(){
            running = false;
        }
    }
}
