/*package Model;
import javafx.util.Pair;
public class MyPair<String, BufferedReader> {
    public MyPair(Pair<java.lang.String, java.io.BufferedReader> pereche) {
        this.pereche = pereche;
    }

    Pair<java.lang.String, java.io.BufferedReader> pereche;


    public java.lang.String getK(){
        return pereche.getKey();
    }

    public java.io.BufferedReader getV(){
        return  pereche.getValue();
    }
}*/

package Model;
import java.util.Map;

public class MyPair<K, V> implements Map.Entry<K, V> {
    private K key;
    private V value;

    @Override
    public String toString() {
        return  "(" + key +
                "," + value +
                ")";
    }

    public MyPair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public K getKey() {
        return key;
    }

    @Override
    public V getValue() {
        return value;
    }

    @Override
    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }
}