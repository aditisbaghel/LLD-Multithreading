package scaler.lld1.multithreading.addersubtractor.mutex;


//import java.util.concurrent.CompletableFuture;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
        Lock lock = new ReentrantLock();
        Adder adder = new Adder(counter, lock);
        Subtractor subtractor = new Subtractor(counter, lock);
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
