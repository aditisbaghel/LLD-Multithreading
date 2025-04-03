package scaler.lld1.multithreading.addersubtractor.atomicInteger;

import java.util.concurrent.atomic.*;

public class Counter {
    private AtomicInteger value;
//    private AtomicLongArray al;
//    private AtomicBoolean b;
//    private AtomicIntegerArray aa;
//    private AtomicLong l;
    public Counter(AtomicInteger value) {
    this.value = value;
    }

    public AtomicInteger getValue(){
        return value;
    }
   }
