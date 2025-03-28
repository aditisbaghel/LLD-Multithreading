package scaler.lld1.multithreading.mergesort;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> array1;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> data, ExecutorService executorService) {
        this.array1 = data;
        this.executorService = executorService;
    }

//    private List

    @Override
    public List<Integer> call() throws Exception {
        if(array1.size()<=1){return array1;}
        int mid  = array1.size()/2;
        List<Integer> lArray = new ArrayList<>();
        List<Integer> rArray = new ArrayList<>();
        for(int i = 0; i<mid; i++){
            lArray.add(array1.get(i));
        }
        for(int i = mid ; i<array1.size(); i++){
            rArray.add(array1.get(i));
        }
        MergeSorter lMergeSorter = new MergeSorter(lArray,executorService);
        MergeSorter rMergeSorter = new MergeSorter(rArray, executorService);
//        ExecutorService executorService = Executors.newCachedThreadPool();
        Future<List<Integer>> lMergeSorterFuture = executorService.submit(lMergeSorter);
        Future<List<Integer>> rMergeSorterFuture = executorService.submit(rMergeSorter);
        List<Integer> leftSortedArray = lMergeSorterFuture.get();
        List<Integer> rightSortedArray = rMergeSorterFuture.get();
        executorService.shutdown();
//        List<Integer> leftSortedArray = lMergeSorter.call();
//        List<Integer> rightSortedArray = rMergeSorter.call();
        return merge(leftSortedArray,rightSortedArray);

    }

    private List<Integer> merge(List<Integer> leftSortedArray, List<Integer> rightSortedArray) {
    int i =0, j = 0;

    List<Integer> mergedArray = new ArrayList<>();
    while(i< leftSortedArray.size() && j < rightSortedArray.size()){
        if(leftSortedArray.get(i) <= rightSortedArray.get(j)){
            mergedArray.add(leftSortedArray.get(i));
            i++;
        }
        else{
            mergedArray.add(rightSortedArray.get(j));
            j++;
        }
    }
    while(i<leftSortedArray.size()){
        mergedArray.add(leftSortedArray.get(i));
        i++;
    }
    while(j< rightSortedArray.size()){
        mergedArray.add(rightSortedArray.get(j));
        j++;
    }
    return  mergedArray;
    }
}
