package Practical;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class multi_threading {
    static class myThread extends Thread  {
        public void run(){
            System.out.println("MyThread running:"+Thread.currentThread().getName());
        
    }
    
        
    }
    static class MyRunnable implements Runnable{
        public void run(){
            System.out.println("MyRunnable:"+Thread.currentThread().getName());
        }
    }
    public static void main(String[]args) throws InterruptedException,ExecutionException{
        Thread t1= new myThread();
        t1.setName("thread_subclass");
        t1.start();
        t1.join();
        Thread t2 = new Thread(new MyRunnable(),"Runnable-Thread");
        t2.start();
        t2.join();
        ExecutorService pool = Executors.newFixedThreadPool(2);
        Future<String> f = pool.submit(() ->{
            return "callable result from" + Thread.currentThread().getName();

        });
        System.out.println(f.get());
        pool.shutdown();
        pool.awaitTermination(3,TimeUnit.SECONDS);
        System.out.println("Main Finished");

    }
    
}
