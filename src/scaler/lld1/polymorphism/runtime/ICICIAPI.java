package scaler.lld1.polymorphism.runtime;

public interface ICICIAPI extends BankAPI{
    double getBal();
    boolean startRegistration();
    boolean startDeregister();
    boolean pay();

}
