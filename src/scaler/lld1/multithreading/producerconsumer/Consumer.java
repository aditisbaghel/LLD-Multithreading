package scaler.lld1.multithreading.producerconsumer;

import java.util.Queue;

public class Consumer implements Runnable{
    private String name;
    private Queue<Shirt> store;

    public Consumer(String consumer, Queue<Shirt> store) {
        this.name = consumer;
        this.store = store;
    }

    @Override
    public void run() {
        while(true) {
            synchronized (store) {
                if (!store.isEmpty()) {
                    System.out.println("Consumer: " + name + " is consuming . Current size :" + store.size());
                    store.remove();
                }
            }
        }
    }
}
