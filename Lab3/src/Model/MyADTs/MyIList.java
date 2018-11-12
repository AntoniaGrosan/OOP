package Model.MyADTs;

public interface MyIList<T> {
    void add(T v);
    void remove(T v);
    void remove(int index);
    void set(int index, T v);
    int indexOf(T v);
    T get(int index);
    int size();
    boolean contains(T v);
    void clear();
}
