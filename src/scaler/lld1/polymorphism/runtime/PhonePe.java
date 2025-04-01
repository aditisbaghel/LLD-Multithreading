package scaler.lld1.polymorphism.runtime;

public class PhonePe {
    BankAPI api;
    void addTOWallet(){
        api.checkBalance();
        api.register();
        api.pay("","","");
        api.checkBalance();
    }

}
