package Model.MyADTs;

public interface MyIStack<T> {
    T pop();
    void push(T v);
    int size();
    void clear();
    boolean isEmpty();
}
