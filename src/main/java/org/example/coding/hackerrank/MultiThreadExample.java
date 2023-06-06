package org.example.coding.hackerrank;

//public class MultiThreadExample extends Thread {
public class MultiThreadExample implements Runnable {

    private int threadNumber;
    public MultiThreadExample(int threadNumber){
        this.threadNumber = threadNumber;
    }
    @Override
    public void run(){
        for(int i=1; i<=5; i++){
            System.out.println(i + " from thread " + threadNumber);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
