package scaler.lld1.multithreading.addersubtractor.synchronize;

public class Subtractor implements Runnable{
    private Counter counter;

    public Subtractor(Counter counter) {
    this.counter = counter;

    }

    @Override
    public void run() {
        for(int i = 1; i <= 10000; i++){
//            synchronized (counter) {
//                counter.setValue(counter.getValue() - i);
//            }
            counter.decrementValue(i);
        }
    }
}
