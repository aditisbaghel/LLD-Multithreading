package scaler.lld1.multithreading.addersubtractor;


import java.util.concurrent.CompletableFuture;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter(0);
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
