package scaler.lld1.multithreading.producerconsumerwithsemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private String name;
    private Queue<Shirt> store;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Consumer(String consumer, Queue<Shirt> store, Semaphore producerSemaphore, Semaphore consumerSemaphore) {
        this.name = consumer;
        this.store = store;
        this.consumerSemaphore = consumerSemaphore;
        this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try  {
                consumerSemaphore.acquire();
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
//            if (!store.isEmpty()) {
                System.out.println("Consumer: " + name + " is consuming . Current size :" + store.size());
                store.remove();
//            }
            producerSemaphore.release();
        }
    }
}
