package scaler.lld1.multithreading.producerconsumer;

import java.util.Queue;

public class Producer implements Runnable{
    private String name;
    private Queue<Shirt> store;
    private int maxSizeOfStore;

    public Producer(String producer, Queue<Shirt> store, int maxSizeOfStore) {
    this.name = producer;
    this.store = store;
    this.maxSizeOfStore = maxSizeOfStore;
    }

    @Override
    public void run() {
        while(true) {
            if (store.size() < maxSizeOfStore) {
                System.out.println("Producer: "+name+" is producing . Current size :"+store.size());
                store.add(new Shirt());
            }
        }
    }
}
