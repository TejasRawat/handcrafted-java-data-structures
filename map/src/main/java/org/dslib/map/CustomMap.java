package org.dslib.map;

import java.util.*;

public class CustomMap <K, V> implements Map<K, V> {
    LinkedList<Node<K, V>>[] table = null;

    public CustomMap() {
        this.table = new LinkedList[5];

        for(int i = 0; i < this.table.length; ++i) {
            this.table[i] = new LinkedList();
        }

    }

    public V put(K key, V value) {
        int hashVal = key.hashCode() % 5;
        this.table[hashVal].add(new Node(key.hashCode(), key, value));
        return null;
    }

    public int size() {
        int size = 0;

        for(int i = 0; i < this.table.length; ++i) {
            size += this.table[i].size();
        }

        return size;
    }

    public void clear() {
        this.table = new LinkedList[5];

        for(int i = 0; i < this.table.length; ++i) {
            this.table[i] = new LinkedList();
        }

    }

    public V get(Object key) {
        int hash = key.hashCode() % 5;
        Node<K, V> node = null;
        V returnElement = null;
        LinkedList<Node<K, V>> list = this.table[hash];
        Iterator itr = list.iterator();

        while(itr.hasNext()) {
            node = (Node)itr.next();
            if (node.hash == key.hashCode()) {
                returnElement = node.value;
                break;
            }
        }

        return returnElement;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public boolean containsKey(Object key) {
        boolean flag = false;
        int hash = key.hashCode() % 5;
        Node<K, V> node = null;
        LinkedList<Node<K, V>> list = this.table[hash];
        Iterator itr = list.iterator();

        while(itr.hasNext()) {
            node = (Node)itr.next();
            if (node.hash == key.hashCode()) {
                flag = true;
                break;
            }
        }

        return flag;
    }

    public boolean containsValue(Object value) {
        boolean flag = false;

        for(int i = 0; i < this.table.length; ++i) {
            LinkedList<Node<K, V>> list = this.table[i];
            flag = this.isPresent(list, value);
            if (flag) {
                break;
            }
        }

        return flag;
    }

    private boolean isPresent(LinkedList<Node<K, V>> list, Object value) {
        Iterator itr = list.iterator();

        while(itr.hasNext()) {
            Node<K, V> node = (Node)itr.next();
            if (node.value == value) {
                return true;
            }
        }

        return false;
    }

    public V remove(Object key) {
        int hash = key.hashCode() % 5;
        Node<K, V> node = null;
        LinkedList<Node<K, V>> list = this.table[hash];
        Iterator itr = list.iterator();

        while(itr.hasNext()) {
            node = (Node)itr.next();
            if (node.hash == key.hashCode()) {
                list.remove(itr.next());
                break;
            }
        }

        return null;
    }

    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet();

        for(int i = 0; i < this.table.length; ++i) {
            List<Node<K, V>> list = this.table[i];
            set.addAll(list);
        }

        return set;
    }

    public Set<K> keySet() {
        return null;
    }

    public Collection<V> values() {
        return null;
    }

    public void putAll(Map<? extends K, ? extends V> m) {
    }
}
