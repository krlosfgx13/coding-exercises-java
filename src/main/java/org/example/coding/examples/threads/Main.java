package org.example.coding.examples.threads;

public class Main {

    public static void main(String[] args){
        //runSynchronizedThreads(); //Concurrent.
        runNonSynchronizedThreads(); //Parallel.
    }

    private static void runSynchronizedThreads(){
        Thread thread1 = new Thread(() -> {
            try {
                synchronizedMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                synchronizedMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }

    private static void runNonSynchronizedThreads(){
        Thread thread1 = new Thread(() -> {
            try {
                nonSynchronizedMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                nonSynchronizedMethod();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        thread1.setName("Thread 1");
        thread2.setName("Thread 2");
        thread1.start();
        thread2.start();
    }

    private static void runAllThreads(){
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        Thread thread3 = new Thread(new Thread3());
        Thread thread4 = new Thread(new Thread4());
        Thread thread5 = new Thread(Main::run5);
        Thread thread6 = new Thread(Main::run6);

        thread1.setName("Thread #1");
        thread2.setName("Thread #2");
        thread3.setName("Thread #3");
        thread4.setName("Thread #4");
        thread5.setName("Thread #5");
        thread6.setName("Thread #6");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();
        thread6.start();
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    //Two threads are referencing this method, however, with the synchronized keyword just one access the method,
    //after it is done, the other thread can access the method. Without the synchronized keyword, both threads can
    //access the method at the same time. Seems like with synchronized threads the start() order matters.
    synchronized private static void synchronizedMethod() throws InterruptedException {
        System.out.println("This is a synchronized method accessed by: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    private static void nonSynchronizedMethod() throws InterruptedException {
        System.out.println("This is a synchronized method accessed by: " + Thread.currentThread().getName());
        Thread.sleep(1000);
    }

    private static void run5(){
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    private static void run6(){
        System.out.println("Executing: " + Thread.currentThread().getName());
    }

    //Extending Thread class. For every thread is needed a class extending the Thread class and must contain run method.
    static class Thread1 extends Thread{
        public void run(){
            System.out.println("Executing: " + Thread.currentThread().getName());
        }
    }

    static class Thread2 extends Thread{
        public void run(){
            System.out.println("Executing: " + Thread.currentThread().getName());
        }
    }

    //Implementing Runnable Interface. For every thread is needed a class implementing the Runnable interface and must
    // implement run method.
    static class Thread3 implements Runnable{
        @Override
        public void run() {
            System.out.println("Executing: " + Thread.currentThread().getName());
        }
    }

    static class Thread4 implements Runnable{
        @Override
        public void run() {
            System.out.println("Executing: " + Thread.currentThread().getName());
        }
    }
}
