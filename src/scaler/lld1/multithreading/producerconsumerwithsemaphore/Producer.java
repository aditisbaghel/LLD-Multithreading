package scaler.lld1.multithreading.producerconsumerwithsemaphore;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private String name;
    private Queue<Shirt> store;
    private int maxSizeOfStore;
    private Semaphore producerSemaphore;
    private Semaphore consumerSemaphore;

    public Producer(String producer, Queue<Shirt> store,
//                    int maxSizeOfStore,
                    Semaphore producerSemaphore, Semaphore consumerSemaphore) {
    this.name = producer;
    this.store = store;
    this.maxSizeOfStore = maxSizeOfStore;
    this.consumerSemaphore = consumerSemaphore;
    this.producerSemaphore = producerSemaphore;
    }

    @Override
    public void run() {
        while(true) {
            try  {
                producerSemaphore.acquire();

            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
//                if (store.size() < maxSizeOfStore) {
                    System.out.println("Producer: " + name + " is producing . Current size :" + store.size());
                    store.add(new Shirt());
//                }
                consumerSemaphore.release();

        }
    }
}
