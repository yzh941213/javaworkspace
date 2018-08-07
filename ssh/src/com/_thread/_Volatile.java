package com._thread;

public class _Volatile {


    private volatile int count = 0;


    public static void main(String[] args)throws Exception {
        _Volatile v = new _Volatile();

        for (int i=0;i<100;i++){
            v.thread1();
            v.thread2(i);
        }

    }



    private void thread1(){

        new Thread(()->{
            System.out.println("get :"+get());

        }).start();
    }


    private void thread2(int i){
        new Thread(()->{
            set(i);

        }).start();
    }

    private int get(){
        return count;
    }



    private void set(int l){
        count = l;
        System.out.println("set :"+count);
    }
}
