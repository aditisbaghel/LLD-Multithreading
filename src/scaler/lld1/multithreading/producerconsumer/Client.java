package scaler.lld1.multithreading.producerconsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Client {
    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedQueue<>();
        Producer producer1 = new Producer("Producer1", store,6);
        Producer producer2 = new Producer("Producer2", store,6);
//        Producer producer3 = new Producer("Producer3", store);
//        Producer producer4 = new Producer("Producer4", store);
//        Producer producer5 = new Producer("Producer5", store);

        Consumer consumer1 = new Consumer("Consumer1", store);
        Consumer consumer2 = new Consumer("Consumer2", store);
        Consumer consumer3 = new Consumer("Consumer3", store);
        Consumer consumer4 = new Consumer("Consumer4", store);
        Consumer consumer5 = new Consumer("Consumer5", store);
        Thread t1 = new Thread(producer1);
        Thread t2 = new Thread(producer2);
        Thread t3 = new Thread(consumer1);
        Thread t4 = new Thread(consumer2);
        Thread t5 = new Thread(consumer3);
        Thread t6 = new Thread(consumer4);
        Thread t7 = new Thread(consumer5);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
        t7.start();

    }
}
