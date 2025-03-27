package scaler.lld1.multithreading.numberprinter;

public class NumberPrinter implements Runnable {
    private int number;

    public NumberPrinter(int i) {
    this.number = i;
    }

    @Override
    public void run() {
        System.out.println("Number is :"+number+" : "+Thread.currentThread().getName());
    }
}
