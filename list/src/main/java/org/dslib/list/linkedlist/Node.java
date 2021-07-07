package org.dslib.list.linkedlist;

public class Node<E> {
    E data;
    Node<E> prev;
    Node<E> next;
    static final int size = 0;

    public Node() {
    }

    public Node(E data, Node<E> prev, Node<E> next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}
