package scaler.lld1.multithreading.helloworld;

public class Client {
    public static void main(String[] args) {
            HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
//            helloWorldPrinter.run(); this will get called from main thread itself
            Thread thread = new Thread(helloWorldPrinter);
            thread.start(); // here it will create a separate and will get executed over here

    }
}
