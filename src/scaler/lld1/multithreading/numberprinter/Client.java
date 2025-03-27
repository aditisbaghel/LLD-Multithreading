package scaler.lld1.multithreading.numberprinter;

public class Client {
    public static void main(String[] args) {

        for(int i=0; i<100; i++){

            NumberPrinter numberPrinter = new NumberPrinter(i);
            Thread thread = new Thread(numberPrinter);
            thread.start();

        }
    }
}
