package Map61B;

import org.junit.Assert.*;
import java.util.List;
import java.util.ArrayList;
import org.junit.Test;


import static org.junit.Assert.*;

/**
 * An array based implementation of the Map61B class.
 */
public class ArrayMap<K, V> implements Map61B<K, V> {
    public ArrayMap() {
    }

    /** Returns the index of the given key if it exists,
     *  -1 otherwise. */
    private int keyIndex(K key) {
        return 0;
    }


    public boolean containsKey(K key) {
        return false;
    }

    public void put(K key, V value) {
        
    }

    public V get(K key) {
        return false;
    }

    public int size() {
        return 0;
    }

    public List<K> keys() {
        return null;
    }

    /*@Test
    public void test() {
        ArrayMap<Integer, Integer> am = new ArrayMap<Integer, Integer>();
        am.put(2, 5);
        int expected = 5;
        assertEquals(expected, am.get(2));
    }*/

    public static void main(String[] args) {
        ArrayMap<String, Integer> m = new ArrayMap<String, Integer>();
        m.put("horse", 3);
        m.put("fish", 9);
        m.put("house", 10);
    }
}

package Map61B;

        import java.util.List;
        import java.util.ArrayList;

/***
 * An array-based implementation of Map61B.
 ***/
public class ArrayMap<K, V> implements Map61B<K, V> {

    private K[] keys;
    private V[] values;
    int size;

    public ArrayMap() {
        keys = (K[]) new Object[100];
        values = (V[]) new Object[100];
        size = 0;
    }

    /**
     * Returns the index of the key, if it exists. Otherwise returns -1.
     **/
    private int keyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                return i;
            }
            return -1;
        }

        public boolean containsKey (K key){
            int index = keyIndex(key);
            return index > -1;
        }

        public void put (K key, V value){
            int index = keyIndex(key);
            if (index == -1) {
                keys[size] = key;
                values[size] = value;
                size += 1;
            } else {
                values[index] = value;
            }
        }

        public V get (K key){
            int index = keyIndex(key);
            return values[index];
        }

        public int size () {
            return size;
        }

        public List<K> keys () {
            List<K> keyList = new ArrayList<>();
            for (int i = 0; i < keys.length; i++) {
                keyList.add(keys[i]);
            }
            return keyList;
        }
    }
}