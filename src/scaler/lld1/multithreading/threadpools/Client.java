package scaler.lld1.multithreading.threadpools;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Client {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for(int i=1; i<=10; i++){

            if(i==5 || i==6 || i==10){
                System.out.println("DEBUG");
            }
            NumberPrinter numberPrinter = new NumberPrinter(i);
            executorService.submit(numberPrinter);
//            Thread thread = new Thread(numberPrinter);
//            thread.start();
        }
    }
}
