package Model.MyADTs;
import java.util.ArrayList;

public class MyList<T> implements MyIList<T> {
    ArrayList<T> list;

    public MyList() {
        this.list = new ArrayList<T>();
    }

    @Override
    public void add(T v) {
        list.add(v);
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public void remove(T v) {
        list.remove(v);
    }

    @Override
    public void remove(int index) {
        list.remove(index);
    }

    @Override
    public void set(int index, T v) {
        list.set(index,v);
    }

    @Override
    public int indexOf(T v) {
        return list.indexOf(v);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean contains(T v) {
        return list.contains(v);
    }

    @Override
    public void clear() {
        list.clear();
    }
}
