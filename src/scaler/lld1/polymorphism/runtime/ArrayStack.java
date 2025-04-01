package scaler.lld1.polymorphism.runtime;
//program to interface, not to an implementation(concrete classes)
// system is loosely coupled (flexibility is achieved) , clear code/ readable , maintainability
public class ArrayStack implements Stack{
    int top;
    int[] arr;
    int maxSize;

    @Override
    public void push(int ele) {
    arr[top] = ele;
    top++;
    }

    @Override
    public int pop() {
        int ele = arr[top];
        top--;
        return ele;
    }

    @Override
    public boolean isEmpty() {
        return top==0;
    }
}
