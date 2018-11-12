package Model.MyADTs;
import java.util.ArrayList;

public class MyStack<T> implements MyIStack<T> {
    ArrayList<T> stack;

    public MyStack() {
        this.stack = new ArrayList<T>();
    }

    @Override
    public T pop(){
        return stack.remove(stack.size()-1);
    }

    @Override
    public void push(T v) {
        stack.add(stack.size(),v);
    }

    @Override
    public int size() {
        return stack.size();
    }

    @Override
    public void clear() {
        stack.clear();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        String result = "";
        for(int i = stack.size() - 1; i >= 0; i--) {
            if (i != 0)
                result = result + stack.get(i) + ";";
            else
                result = result + stack.get(i);
        }
        return result;
    }

}
