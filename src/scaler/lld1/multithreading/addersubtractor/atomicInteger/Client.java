package scaler.lld1.multithreading.addersubtractor.atomicInteger;

//import java.util.concurrent.CompletableFuture;
//Use synchronized block when there is problem of concurrency

import java.util.concurrent.atomic.AtomicInteger;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        AtomicInteger atomicInteger = new AtomicInteger(0);
        Counter counter = new Counter(atomicInteger);
        Adder adder = new Adder(counter);
        Subtractor subtractor = new Subtractor(counter);
        Thread adderThread = new Thread(adder);
        Thread subtractorThread = new Thread(subtractor);
        adderThread.start();
        subtractorThread.start();
        adderThread.join();
        subtractorThread.join();
        System.out.println("Counter value is  :- "+counter.getValue());

     /*   CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(3000);
            }
            catch (InterruptedException e){
                throw new RuntimeException(e);
            }
            return "Hello WOrld!!";
        }).thenAccept(System.out::println);

        System.out.println("SOmething else is done by main()");
        Thread.sleep(5000);

      */
    }
}
