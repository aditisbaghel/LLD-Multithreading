package scaler.lld1.multithreading.producerconsumerwithsemaphore;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        int maxSizeOfStore =6;
        Queue<Shirt> store = new ConcurrentLinkedQueue<>();
        ExecutorService executorService = Executors.newCachedThreadPool();
        Semaphore producerSemaphore = new Semaphore(maxSizeOfStore);
        Semaphore consumerSemaphore = new Semaphore(0);

        executorService.submit(new Producer("Producer1", store,
//                maxSizeOfStore,
                producerSemaphore,consumerSemaphore));
        executorService.submit(new Producer("Producer2", store,
//                maxSizeOfStore,
                producerSemaphore,consumerSemaphore));
//        Producer producer3 = new Producer("Producer3", store);
//        Producer producer4 = new Producer("Producer4", store);
//        Producer producer5 = new Producer("Producer5", store);
        executorService.submit(new Consumer("Consumer1", store,producerSemaphore,consumerSemaphore));
        executorService.submit(new Consumer("Consumer2", store,producerSemaphore,consumerSemaphore));
        executorService.submit(new Consumer("Consumer3", store,producerSemaphore,consumerSemaphore));
        executorService.submit(new Consumer("Consumer4", store,producerSemaphore,consumerSemaphore));
        executorService.submit(new Consumer("Consumer5", store,producerSemaphore,consumerSemaphore));
        executorService.shutdown();


    }
}
