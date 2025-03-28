package scaler.lld1.multithreading.mergesort;

import scaler.lld1.multithreading.threadpools.NumberPrinter;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Integer> data = List.of(6,3,6,7,8,9);
        ExecutorService executorService = Executors.newCachedThreadPool();
        MergeSorter mergeSorter = new MergeSorter(data, executorService);
        Future<List<Integer>> sortedDataFuture = executorService.submit(mergeSorter);
//        List<Integer> sortedData = mergeSorter.call();
        List<Integer> sortedData = sortedDataFuture.get(); // Blocking call -> Thread waits until the result are ready
        System.out.println("Sorted data is : - " +sortedData);
        executorService.shutdown();
    }
}
