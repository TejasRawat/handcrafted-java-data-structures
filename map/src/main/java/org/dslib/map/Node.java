package org.dslib.map;

import java.util.Map;

public class Node<K, V> implements Map.Entry<K, V> {
    int hash;
    K key;
    V value;

    public Node(int hash, K key, V value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return "Hash=" + this.hash + ", key=" + this.key + ", value=" + this.value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

    public V setValue(V value) {
        this.value = value;
        return null;
    }
}
