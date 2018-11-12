package Model.MyADTs;

import java.util.HashMap;

public class MyDictionary<T,T1> implements MyIDictionary<T,T1> {
    HashMap<T,T1> dictionary;

    public MyDictionary() {
        this.dictionary = new HashMap<T,T1>();
    }

    @Override
    public Object lookup(Object key) {
        return dictionary.get(key);
    }

    @Override
    public boolean isEmpty() {
        return dictionary.isEmpty();
    }

    @Override
    public String toString() {
        return dictionary.toString();
    }

    @Override
    public void put(T key, T1 v) {
        dictionary.put(key,v);
    }

    @Override
    public void remove(T key) {
        dictionary.remove(key);
    }

    public void update(T key, T1 v){
        dictionary.replace(key,v);
    }

    @Override
    public boolean isDefined(T key) {
        return dictionary.containsKey(key);
    }

    @Override
    public boolean containsValue(T1 v) { return dictionary.containsValue(v); }

    @Override
    public int size() {
        return dictionary.size();
    }

    @Override
    public void clear() {
        dictionary.clear();
    }

}
