package scaler.lld1.polymorphism.runtime;

public interface BankAPI {
    int checkBalance();
    boolean unregister();
    Payment pay(String from,String to, String smart);
    boolean register();
}
