package Model.MyADTs;

public interface MyIDictionary<T,T1> {
    T1 lookup(T key);
    boolean isEmpty();
    void put(T key, T1 v);
    void remove(T key);
    int size();
    void clear();
    void update(T key, T1 v);
    boolean isDefined(T key);
    boolean containsValue(T1 v);
}